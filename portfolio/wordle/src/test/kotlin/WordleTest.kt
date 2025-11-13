import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import java.io.File

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here
    val testWords = listOf("BANAL","CRUET","DUCAT","ODIUM","VAPID")
    val testFilename = "testwords.txt"

    beforeTest {
        // creates a temp file called testwords.txt
        File(testFilename).writeText((testWords.joinToString("\n")))
    }

    afterTest {
        // deletes the temp file after the test is done; cleanup
        File(testFilename).delete()
    }

    "isValid should return true for valid 5-letter words" {
        isValid("BANAL") shouldBe true          // exact valid word
        isValid("CRUET") shouldBe true          // another exact valid word
        isValid("abcde") shouldBe true          // valid word in lowercase
        isValid("DucAt") shouldBe true          // valid word in lowercase and uppercase
    }

    "isValid should return false for these invalid 5-letter words" {
        isValid("BAN") shouldBe false           // too short
        isValid("PINEAPPLE") shouldBe false     // too long
        isValid("APP1E") shouldBe false         // contains numbers
        isValid("Ban a") shouldBe false         // contains spaces
        isValid("App!e") shouldBe false         // contains special characters
        isValid("") shouldBe false              // doesnt contain anything
    }

    "readWordList should read words from file correctly" {
        val wordList = readWordList(testFilename)

        wordList shouldBe testWords             // should contain testWords
        wordList.size shouldBe 5                // length of the list should be 5
        wordList shouldContain "BANAL"          // should contain the testWord "BANAL"
        wordList shouldContain "DUCAT"          // should contain the testWord "DUCAT"
    }

    "readWordList should return empty list for non-existent file" {
        val wordList = readWordList("nonexitentfile.txt")           // reads a non existent file
        wordList shouldBe emptyList()                               // should return an empty list after reading non existent file
    }

    "pickRandomWord should remove and return a random word from the list" {
        val mutableList = testWords.toMutableList()         // testWords should be mutable now
        val originalSize = mutableList.size                 // length of list before removing word
        val randomWord = pickRandomWord(mutableList)        // picking random word

        mutableList.size shouldBe originalSize -1           // length of list should be one less after picking random word
        mutableList shouldNotContain randomWord             // picking random word means removing it from mutable list
        testWords shouldContain randomWord                  // removed from testWords list as well
    }

    // rest is self explanatory within the test specification
    "evaluateGuess should return all 0s for totally wrong answer" {
        evaluateGuess("BANAL","CRUET") shouldBe listOf(0,0,0,0,0)       
    }

    "evaluateGuess should return all 1s for all same letter but in the wrong position" {
        evaluateGuess("LBANA","BANAL") shouldBe listOf(1,1,1,1,1)
    }

    "evaluateGUess should return all 2s for a perfect guess" {
        evaluateGuess("DUCAT","DUCAT") shouldBe listOf(2,2,2,2,2)
    }

    "evaluateGuess should handle a mix of incorrect, partial and perfect guesses" {
        evaluateGuess("CRATE","CRUET") shouldBe listOf(2,2,0,1,1)
    }

    "evaluateGuess should handle double letters" {
        evaluateGuess("LILYS","HELLO") shouldBe listOf(1,0,2,0,0)
    }

    "evaluateGuess should not care about case sensitivity" {
        evaluateGuess("banal","BANAL") shouldBe listOf(2,2,2,2,2)
        evaluateGuess("bAnAL","BANAL") shouldBe listOf(2,2,2,2,2)
    }
})
