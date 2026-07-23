package org.example

private fun isPackageId(token: String) = token.trim().startsWith("PKG-")

private fun cleanToken(token: String) = token.trim()

private fun collectToken(segment: String, startIndex: Int): String {
    val sb = StringBuilder()
    var i = startIndex
    while (i < segment.length && segment[i] != ',' && segment[i] != '[' && segment[i] != ']') {
        sb.append(segment[i]); i++
    }
    return sb.toString()
}

private fun extractInnerContent(segment: String, startIndex: Int): String {
    val sb = StringBuilder()
    var i = startIndex
    var depth = 1
    while (i < segment.length && depth > 0) {
        val ch = segment[i]
        if (ch == '[') depth++ else if (ch == ']') depth--
        if (depth > 0) sb.append(ch)
        i++
    }
    if (depth != 0) throw StructuralMismatchException()
    return sb.toString()
}

private fun findClosingBracket(segment: String, startIndex: Int): Int {
    var depth = 0
    for (i in startIndex until segment.length) {
        if (segment[i] == '[') depth++
        else if (segment[i] == ']') {
            if (depth == 0) return i + 1 else depth--
        }
    }
    throw StructuralMismatchException()
}

private fun parseRecursive(segment: String): List<String> {
    val results = mutableListOf<String>()
    var i = 0
    val length = segment.length
    while (i < length) {
        val ch = segment[i]
        when {
            ch.isWhitespace() -> i++
            ch == '[' -> {
                val inner = extractInnerContent(segment, i + 1)
                results.addAll(parseRecursive(inner))
                i = findClosingBracket(segment, i + 1)
            }
            ch == ']' -> return results
            ch == ',' -> i++
            else -> {
                val token = collectToken(segment, i)
                if (isPackageId(token)) results.add(cleanToken(token))
                i += token.length
            }
        }
    }
    return results
}

fun parseContainerStructure(input: String): List<String> {
    val cleanedInput = input.trim()
    if (cleanedInput.isEmpty()) return emptyList()
    return parseRecursive(cleanedInput)
}

/*
 Recursion Execution Flow in JVM:

 1. Each time the recursive function is called, the JVM creates a new stack frame.
 2. This stack frame stores:
    - Local variables specific to that call
    - The current execution state (instruction pointer)
    - References to parameters passed into the function
 3. The program then executes inside this frame until:
    - It either makes another recursive call (creating a deeper frame)
    - Or reaches a base case and returns a value
 4. When the function returns, the JVM destroys that stack frame:
    - Memory allocated for local variables is released
    - Control is passed back to the previous frame
 5. This process continues until all recursive calls have returned,
    unwinding the stack back to the original caller.
 6. Proper base cases are critical, because without them the stack
    keeps growing and eventually causes a StackOverflowError.
*/