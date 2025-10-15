// Task 5.1.1: anagram checking using a function
fun main() {
    val first:String?
    val second:String?

    println("Enter first word: ")
    first = readln().trim()
    println("Enter second word: ")
    second = readln().trim()

    if (first anagramOf second) {
        println("$first and $second are anagrams!")
    }
    else
    {
        println("$first and $second are NOT anagrams!")
    }
}

infix fun String.anagramOf(str: String): Boolean {
    if (this.length != str.length) {
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = str.lowercase().toList().sorted()
    return firstChars == secondChars
}