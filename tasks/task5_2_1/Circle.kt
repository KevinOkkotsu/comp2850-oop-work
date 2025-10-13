// Task 5.2.1: geometric properties of circles
import kotlin.math.PI

fun circleArea(radius: Double) = PI * radius * radius

fun circlePerimeter(radius: Double) = 2 * PI * radius

fun readDouble(input: String):Double {
    return input.toDouble()
}

fun main() {
    println("Enter your radius: ")
    val input = readln()
    val radius = readDouble(input)
    println("Circle area: ${circleArea(radius)}")
    println("Circle perimeter: ${circlePerimeter(radius)}")
}