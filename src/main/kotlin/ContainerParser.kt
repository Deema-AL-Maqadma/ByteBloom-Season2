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