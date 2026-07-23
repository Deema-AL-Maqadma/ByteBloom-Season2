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