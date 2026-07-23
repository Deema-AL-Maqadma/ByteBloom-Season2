package org.example

fun generatePriorityDispatchReport(): List<String> {
    val dispatchResults = mutableListOf<String>()

    for (packageIndex in 1..50) {
        val dispatchLabel = when {
            packageIndex % 15 == 0 -> "PriorityExpress"
            packageIndex % 3 == 0 -> "Express"
            packageIndex % 5 == 0 -> "Freight"
            else -> packageIndex.toString()
        }
        dispatchResults.add(dispatchLabel)
    }

    return dispatchResults
}