// Task 6.4.2


import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
@Suppress("unused")
class AnagramTest : StringSpec({
    "Two strings of different lengths are not anagrams" {
        "listen" anagramOf "listens" shouldBe false
    }
    "An empty string is not an anagram of itself" {
        "" anagramOf "" shouldBe false
    }
    "A non-empty string is an anagram of itself" {
        "k" anagramOf "k" shouldBe true
    }
    "Two strings are anagrams if they contain the same characters in a different order" {
        "spar" anagramOf "rasp" shouldBe true
    }
    "Letter case is disregarded when comparing character sequences i.e., the lowercase and uppercase forms of a character are considered to be equivalent."{
        "Heart" anagramOf "EaRtH" shouldBe true
    }
})
