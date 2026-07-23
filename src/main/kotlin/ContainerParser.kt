package org.example

private fun isPackageId(token: String) = token.trim().startsWith("PKG-")

private fun cleanToken(token: String) = token.trim()