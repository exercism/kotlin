import org.junit.Test
import kotlin.test.assertEquals

class AnagramTest {

    @Test
    fun noMatches() {
        val detector = Anagram("diaper")
        assertEquals(listOf(), detector.match(listOf("hello", "world", "zombies", "pants")))
    }

    @Test
    fun simpleAnagram() {
        val detector = Anagram("ant")
        val anagram = detector.match(listOf("tan", "stand", "at"))
        assertEquals(listOf("tan"), anagram)
    }

    @Test
    fun detectMultipleAnagrams() {
        val detector = Anagram("master")
        val anagrams = detector.match(listOf("stream", "pigeon", "maters"))
        assertEquals(listOf("maters", "stream"), anagrams.sorted())
    }

    @Test
    fun doesNotConfuseDifferentDuplicates() {
        val detector = Anagram("galea")
        val anagrams = detector.match(listOf("eagle"))
        assertEquals(listOf(), anagrams)
    }

    @Test
    fun identicalWordIsNotAnagram() {
        val detector = Anagram("corn")
        val anagrams = detector.match(listOf("corn", "dark", "Corn", "rank", "CORN", "cron", "park"))
        assertEquals(listOf("cron"), anagrams)
    }

    @Test
    fun eliminateAnagramsWithSameChecksum() {
        val detector = Anagram("mass")
        assertEquals(listOf(), detector.match(listOf("last")))
    }

    @Test
    fun eliminateAnagramSubsets() {
        val detector = Anagram("good")
        assertEquals(listOf(), detector.match(listOf("dog", "goody")))
    }

    @Test
    fun detectAnagrams() {
        val detector = Anagram("listen")
        val anagrams = detector.match(listOf("enlists", "google", "inlets", "banana"))
        assertEquals(listOf("inlets"), anagrams)
    }

    @Test
    fun multipleAnagrams() {
        val detector = Anagram("allergy")
        val anagrams = detector.match(listOf("gallery", "ballerina", "regally", "clergy", "largely", "leading"))
        assertEquals(listOf("gallery", "largely", "regally"), anagrams.sorted())
    }

    @Test
    fun anagramsAreCaseInsensitive() {
        val detector = Anagram("Orchestra")
        val anagrams = detector.match(listOf("cashregister", "Carthorse", "radishes"))
        assertEquals(listOf("Carthorse"), anagrams)
    }

}
