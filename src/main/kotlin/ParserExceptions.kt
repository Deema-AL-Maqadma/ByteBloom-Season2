package org.example

const val STRUCTURALERRORMESSAGE = "Unbalanced or malformed container structure detected."

class StructuralMismatchException : Exception(STRUCTURALERRORMESSAGE)
