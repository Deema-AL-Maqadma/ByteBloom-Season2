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
                i = findClosingBracket(segment, i)
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