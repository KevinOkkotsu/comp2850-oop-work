fun main() {
    // read word from file in directory data
    val wordList = readWordList("../../../data/words.txt")
    // pick a random word
    val targetWord = pickRandomWord(wordList)
    
    // start the game
    println("Welcome to the wordle game!")
    println("Guess the word of the day!")
    println("You have 6 tries: \n")


    // checking if the word is valid is done within obtainGuess function
    // game loop
    var win = false
    
    for (attempt in 1..6) {
        val guess = obtainGuess(attempt)
        val matches = evaluateGuess(guess, targetWord)

        displayGuess(guess, matches)

        if (matches.all { it==2 }) {
            win = true
            println("You have guessed the word of the day: ${targetWord}")
            break
        }
        if (matches.any { it==1 || it==2 }) {
            println("You have guessed a letter(s)!")
        }
        else {
            println("Incorrect guess. Try again! (You have ${6-attempt} tries remaining)")
        }
    }
    if (win == false) {
        println("\nYou have ran out of tries. The word of the day is: ${targetWord}\n")
    }
}
