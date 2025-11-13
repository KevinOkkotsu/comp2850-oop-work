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

        // if all numbers in matches is 2
        if (matches.all { it==2 }) {
            win = true
            println("You have guessed the word of the day: ${targetWord}\n")
            break
        }
        // if any numbers in matches are 1 or 2
        if (matches.any { it==1 || it==2 }) {
            println("You have guessed a letter(s)!\n")
        }
        else {
            println("Incorrect guess. Try again! (You have ${6-attempt} tries remaining)\n")
        }
    }
    if (win == false) {
        println("You have ran out of tries. The word of the day is: ${targetWord}\n")
    }
}
