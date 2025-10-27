
fun printReversed(text: String?):String? {   // modify parameter list

    // modify function body to perform a null check
    val result = text?.let {it.uppercase().reversed()}
    return result
}

fun main() {
    print("Enter a string: ")
    val input = readLine()

    println("Input: $input")
    when (input) {
        null -> println("Result: null")
        else -> println("Result: ${printReversed(input)}")
    }
}