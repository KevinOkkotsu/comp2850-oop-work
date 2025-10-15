// Task 5.4.1: string extension function

fun main() {
    println("Type a word or phrase: ")
    val input = readln().trim()
    println(input.tooLong)
}

val String.tooLong: String
    get() {
        var sum = 0
        for (i in this) {
            sum += 1
        }
        return if (sum > 20) {
            "TOO LONG"
        } else {
            "nevermind its not too long"
        }
    }