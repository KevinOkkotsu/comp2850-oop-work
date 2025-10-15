// Task 5.4.1: string extension function
fun main() {
    println("Type a word or phrase: ")
    val input = readln().trim()
    println(input.tooLong())
}

fun String.tooLong(): String {
    var sum = 0
    for (i in this) {
        sum += 1
    }
    if (sum > 20) {
        return "TOO LONG"
    }
    else {
        return "nevermind its not too long"
    }
}