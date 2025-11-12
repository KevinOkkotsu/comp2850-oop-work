import java.io.File
import kotlin.random.Random

// Color codes
const val RESET = "\u001B[0m"
const val GREEN = "\u001B[48;2;46;204;113m"
const val ORANGE = "\u001B[48;2;230;126;34m"

fun isValid(word: String): Boolean {
    if (word.length == 5 && word.all { it.isLetter() }) {
        return true
    }
    else {
        return false
    }
}


fun readWordList(filename: String): MutableList<String> {
    try {
        return File(filename).readLines().toMutableList()
    } catch (e: Exception) {
        return mutableListOf()     // return empty list instead of crashing
    }
}


fun pickRandomWord(words: MutableList<String>): String {
    if (words.isEmpty()) {
        println("There is nothing in the list.")
        return ""
    }
    val randomIndex = Random.nextInt(words.size)
    return words.removeAt(randomIndex)
}


fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt ${attempt}: ")
        val input = readln().trim()

        if (input.length != 5 ){
            println("Invalid word. Please enter 5 letter word.")
            continue
        }
        if (!input.all { it.isLetter() }) {
            println("Can only inlcude letters!")
            continue
        }
        return input.uppercase()
    }
    
}


// 0 incorrect guess, 1 partial correct guess, 2 correct guess
fun evaluateGuess(guess: String, target: String): List<Int> {
    val matches = MutableList(5) {0} // starts off all items as 0
    val charUsed = BooleanArray(5) {false} // starts off as all false

    for (i in 0..4) {
        if (guess[i] == target[i]) {
            matches[i] = 2
            charUsed[i] = true
        }
        else{
            matches[i] = 0
        }
    }
    for (i in 0..4){
        if (matches[i] != 2) {
            for (j in 0..4){
                // we cant compare target[j]==guess[i], since we would not be able to track double letters
                if (guess[i] == target[j] && charUsed[j] == false) {
                    matches[i] = 1
                    charUsed[j] = true
                    break
                }
            }
        }
    }
    return matches
}


fun displayGuess(guess: String, matches: List<Int>) {
    for (i in 0..4) {
        when(matches[i]) {
            2 -> print("$GREEN${guess[i]}$RESET")  // Green for correct position
            1 -> print("$ORANGE${guess[i]}$RESET") // Yellow for wrong position
            else -> print("${guess[i]}")
        }
    }
    println()
}



