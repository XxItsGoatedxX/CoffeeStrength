import java.lang.reflect.Modifier

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val available = listOf("Coffee", "Milk", "Vanilla", "Sugar")
    val order = listOf("Coffee", "Milk")
    val hoursWorked: Int = 4
    val bugsFound: Int = 2
    val energy: String = "zombie"
    println(calculateCaffeineLevel(hoursWorked, bugsFound, energy))
    if(canFulfillOrder(order, available))
    {
        println(createDrinkName("Debugger", "extra coffee", "extra milk"))
    }
    else
    {
        println("Ingredient not available")
    }
}

fun calculateCaffeineLevel(hoursWorked: Int, bugsFound: Int, energy: String): String {
    var score: Int
    var energyScore: Int = 0
    var caffeineLevel: String = ""
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
    var count: Int = 0
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