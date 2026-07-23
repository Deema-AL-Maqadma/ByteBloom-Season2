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

fun reverseRouteWaypoints(route: String): String {
    val waypoints = route.split(" -> ")
    val reversedRoute = StringBuilder()

    for (index in waypoints.size - 1 downTo 0) {
        reversedRoute.append(waypoints[index])
        if (index != 0) {
            reversedRoute.append(" -> ")
        }
    }

    return reversedRoute.toString()
}

fun findHighestValidWeight(weights: DoubleArray): Double {
    var highestWeight = Double.MIN_VALUE

    for (currentWeight in weights) {
        if (currentWeight != -1.0 && currentWeight > highestWeight) {
            highestWeight = currentWeight
        }
    }

    return highestWeight
}