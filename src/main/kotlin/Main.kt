package org.example

fun main() {
    println("=== Problem 1: Priority Dispatcher ===")
    val dispatchReport = generatePriorityDispatchReport()
    println(dispatchReport.joinToString(", "))

    println("\n=== Problem 2: Waypoints Reverser ===")
    val route = "HubA -> HubB -> HubC"
    val reversedRoute = reverseRouteWaypoints(route)
    println("Original: $route")
    println("Reversed: $reversedRoute")

    println("\n=== Problem 3: Max Weight Filter ===")
    val weights = doubleArrayOf(12.5, -1.0, 45.3, 33.8, -1.0, 50.0)
    val maxWeight = findHighestValidWeight(weights)
    println("Highest Valid Weight: $maxWeight")

    println("\n=== Problem 4: Palindrome Transit Code ===")
    val transitCode = "TR808RT"
    val isPalindrome = isTransitCodePalindrome(transitCode)
    println("Is '$transitCode' Palindrome? $isPalindrome")

    println("\n=== Problem 5: Binary Search Lookup ===")
    val trackingIds = intArrayOf(10, 20, 30, 40, 50, 60, 70)
    val targetId = 40
    val foundIndex = binarySearchById(trackingIds, targetId)
    println("Result Index: $foundIndex")
}