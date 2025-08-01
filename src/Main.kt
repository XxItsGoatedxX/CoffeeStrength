//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("☕ WELCOME TO COFFEE & CODE! ☕")
    println("Serving caffeinated programmers since 2025\n")

    println("Dev worked 4 hours, found 2 bugs, feeling tired:")
    println(calculateCaffeineLevel(4, 2, "tired"))

    val available = listOf("Coffee", "Milk", "Vanilla", "Sugar", "Wifi")
    val order = listOf("Coffee", "Milk", "Wifi")

    println("\n📦 Can fulfill order $order? ${canFulfillOrder(order, available)}")
    println("\n🍺 New drink: '${createDrinkName("NullPointer", "caffeine", "desperation", "prayers")}'")
}

fun calculateCaffeineLevel(hoursWorked: Int, bugsFound: Int, energy: String): String {
    var score: Int
    var energyScore = 0
    var caffeineLevel: String
    when (energy) {
        "tired" -> energyScore = 5
        "awake" -> energyScore = 0
        "zombie" -> energyScore = 10
    }
    score = (hoursWorked + (bugsFound + 2) + energyScore)
    if (score >= 0 && score < 6) {
        caffeineLevel = "light"
    } else if (score >= 6 && score < 11) {
        caffeineLevel = "medium"
    } else if (score >= 11 && score < 16) {
        caffeineLevel = "strong"
    } else if (score >= 16) {
        caffeineLevel = "rocket fuel"
    } else {
        caffeineLevel = "unknown"
    }
    return caffeineLevel
}

fun canFulfillOrder(orderItems: List<String>, availableIngredients: List<String>):Boolean {
    var count = 0
    for (orderItem in orderItems) {
        if (availableIngredients.contains(orderItem)) {
            count++
        }
    }
    if (count == orderItems.size ) {
        return true
    } else {
        return false
    }
}


fun createDrinkName(baseType: String, vararg modifiers: String): String {
    return "The $baseType with " + modifiers.joinToString(" ")
}