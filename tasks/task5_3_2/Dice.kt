// Task 5.3.2: dice rolling simulation
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

fun rollDie(sides: Int = 6, dice: Int = 1) {
    var sum = 0

    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        for (n in 1..dice) {
            println("Rolling a d$sides...")
            val result = Random.nextInt(1, sides + 1)
            println("You rolled $result")
            sum += result
        }
    }
    else {
            println("Error: cannot have a $sides-sided die")
    }
    println("The sum is $sum")
}

fun main() {
    while (true) {
        println("Enter a number: ")
        val input = readln().trim().lowercase()
        println("How many dice do you want to roll: ")
        val inputTwo = readln().trim().lowercase()

        if (input.isBlank()) {
            println("Default dice is used.")
            rollDie()
        }
        if (inputTwo.isBlank()) {
            println("Default roll of 1 used.")
        }

        if (input == "exit") {
            break
        }

        val sides = readInt(input)
        val dice = readInt(inputTwo)
        if (sides == -1) {
            println("Error: '$input' is not a valid die type. Please try again.")
            continue
        }
        if (dice == -1) {
            println("Error: '$inputTwo' is not a valid dice. Please try again.")
        }
        else{
            rollDie(sides, dice)
        }
        println()
    }
    println("Thanks for playing!")
}