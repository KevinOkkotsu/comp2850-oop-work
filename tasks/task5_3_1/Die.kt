// Task 5.1.2: die rolling simulation
import kotlin.random.Random

fun readInt(input: String): Int {
    return when (input) {
        "four","4" -> 4
        "six","6" -> 6
        "eight","8" -> 8
        "ten","10" -> 10
        "twelve","12" -> 12
        "twenty","20" -> 20
        else -> -1
    }
}

fun rollDie(sides: Int = 4) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun main() {
    while (true) {
        println("Enter a number: ")
        val input = readln().trim().lowercase()

        if (input.isBlank()) {
            println("Default dice is used.")
            rollDie()
        }
        if (input == "exit") {
            break
        }

        val sides = readInt(input)
        if (sides == -1) {
            println("Error: '$input' is not a valid die type. Please try again.")
            continue
        }
        else{
            rollDie(sides)
        }

        
        println()
    }
    println("Thanks for playing!")
}