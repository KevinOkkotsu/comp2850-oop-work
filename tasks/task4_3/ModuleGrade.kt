
import kotlin.math.roundToInt
fun main(args: Array <String>) {
    println("Enter the module grades:")

    if (args.size < 3) {
        println("Please provide exactly three grades.")
    }
    else {
        val g1 = args[0].toInt()
        val g2 = args[1].toInt()
        val g3 = args[2].toInt()
        val avg = (g1+g2+g3).toDouble()/3

        when (avg.roundToInt()) {
            in 0..39 -> println("Fail: $avg")
            in 40..69 -> println("Pass: $avg")
            in 70..100 -> println("Distinction: $avg")
            else -> println("Invalid Grade")
        }
    }
}