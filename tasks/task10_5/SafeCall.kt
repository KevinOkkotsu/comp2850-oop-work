
fun printReversed(text: String?):String? {   // modify parameter list

    // modify function body to perform a null check
    val result = text?.uppercase()?.reversed() ?: "???"
    return result
}

fun main() {
    print("Enter a string: ")
    val input = readLine()

    println("Input: $input")
    println("Result: ${printReversed(input)}")
}