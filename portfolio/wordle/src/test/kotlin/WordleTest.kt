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
        // test file with test words
        File(testFilename).writeText((testWords.joinToString("\n")))
    }

    afterTest {
        // clear test file
        File(testFilename).delete()
    }

    "isValid should return true for valid 5-letter words" {
        isValid("BANAL") shouldBe true
        isValid("CRUET") shouldBe true
        isValid("abcde") shouldBe true
        isValid("DucAt") shouldBe true
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

        wordList shouldBe testWords
        wordList.size shouldBe 5
        wordList shouldContain "BANAL"
        wordList shouldContain "DUCAT"
    }

    "readWordList should return empty list for non-existent file" {
        val wordList = readWordList("nonexitentfile.txt")
        wordList shouldBe emptyList()
    }

    "pickRandomWord should remove and return a random word from the list" {
        val mutableList = testWords.toMutableList()
        val originalSize = mutableList.size
        val randomWord = pickRandomWord(mutableList)

        mutableList.size shouldBe originalSize -1
        mutableList shouldNotContain randomWord
        testWords shouldContain randomWord 
    }


})
