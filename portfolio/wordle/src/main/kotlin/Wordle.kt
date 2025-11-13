import java.io.File
import kotlin.random.Random

// Color codes for incorrect(WHITE), partial(ORANGE) and correct guesses(GREEN)
const val WHITE = "\u001B[0m"
const val GREEN = "\u001B[48;2;46;204;113m"
const val ORANGE = "\u001B[48;2;230;126;34m"

// isValid checks the input string
fun isValid(word: String): Boolean {
    if (word.length != 5) {
        println("Invalid word. Please enter 5 letter word.")
        return false
    }
    if (!word.all { it.isLetter() }) {
        println("Can only inlcude letters!")
        return false
    }
    else {
        return true
    }
}

// readWordList checks if we can read a words file and turn it into a mutable list
// if we cant, it returns an empty list
fun readWordList(filename: String): MutableList<String> {
    try {
        return File(filename).readLines().toMutableList()
    } catch (e: Exception) {
        return mutableListOf()     // return empty list instead of crashing
    }
}

// pickRandomWord picks a random word by choosing a random index
// pops the word by removing the index where the word was stored in the list
fun pickRandomWord(words: MutableList<String>): String {
    if (words.isEmpty()) {
        println("There is nothing in the list.")
        return ""
    }
    val randomIndex = Random.nextInt(words.size)
    return words.removeAt(randomIndex)
}

// obtainGuess collects user input and validates it using isValid function
fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt ${attempt}: ")
        val input = readln().trim()

        if (isValid(input) == false){
            continue
        }
        return input.uppercase()
    }
    
}


// 0 incorrect guess, 1 partial correct guess, 2 correct guess
fun evaluateGuess(guess: String, target: String): List<Int> {
    val matches = MutableList(5) {0} // starts off all items as 0
    val charUsed = BooleanArray(5) {false} // starts off as all false
    val guess = guess.uppercase()

    // for perfect character guesses the position of the characters will be the same
    // hence we use only one for loop
    for (i in 0..4) {
        if (guess[i] == target[i]) {
            matches[i] = 2
            charUsed[i] = true
        }
        else{
            matches[i] = 0
        }
    }

    // for partial guesses, the position of the characters are different
    // use of two for loops to compare each letter in guess with the target
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

// displayGuess chooses a color for each number in the matching and displays the guess
fun displayGuess(guess: String, matches: List<Int>) {
    for (i in 0..4) {
        when(matches[i]) {
            2 -> print("$GREEN${guess[i]}$WHITE")       // green for correct position
            1 -> print("$ORANGE${guess[i]}$WHITE")      // orange for partially correct position
            else -> print("${guess[i]}")            
        }
    }
    println()
}



