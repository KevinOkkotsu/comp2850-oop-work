// Task 5.1.1: anagram checking using a function
fun main() {
    val first:String?
    val second:String?

    println("Enter first word: ")
    first = readln()
    println("Enter second word: ")
    second = readln()

    println("processing...")
    println(anagrams(first,second))
}

fun anagrams(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val firstChars = first.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars
}
