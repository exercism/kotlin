import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class AnagramTest {

    @Test
    fun noMatches() {
        val detector = Anagram("diaper")
        assertEquals(emptySet(), detector.match(listOf("hello", "world", "zombies", "pants")))
    }

    @Ignore
    @Test
    fun detectsTwoAnagrams() {
        val detector = Anagram("master")
        val anagrams = detector.match(listOf("stream", "pigeon", "maters"))
        assertEquals(setOf("maters", "stream"), anagrams)
    }

    @Ignore
    @Test
    fun doesNotDetectAnagramSubsets() {
        val detector = Anagram("good")
        assertEquals(emptySet(), detector.match(listOf("dog", "goody")))
    }

    @Ignore
    @Test
    fun detectsAnagram() {
        val detector = Anagram("listen")
        val anagrams = detector.match(listOf("enlists", "google", "inlets", "banana"))
        assertEquals(setOf("inlets"), anagrams)
    }

    @Ignore
    @Test
    fun detectsThreeAnagrams() {
        val detector = Anagram("allergy")
        val anagrams = detector.match(listOf("gallery", "ballerina", "regally", "clergy", "largely", "leading"))
        assertEquals(setOf("gallery", "largely", "regally"), anagrams)
    }

    @Ignore
    @Test
    fun doesNotDetectNonAnagramsWithIdenticalChecksums() {
        val detector = Anagram("mass")
        assertEquals(emptySet(), detector.match(listOf("last")))
    }

    @Ignore
    @Test
    fun detectsAnagramsCaseInsensitively() {
        val detector = Anagram("Orchestra")
        val anagrams = detector.match(listOf("cashregister", "Carthorse", "radishes"))
        assertEquals(setOf("Carthorse"), anagrams)
    }

    @Ignore
    @Test
    fun detectsAnagramsUsingCaseInsensitiveSubject() {
        val detector = Anagram("Orchestra")
        val anagrams = detector.match(listOf("cashregister", "carthorse", "radishes"))
        assertEquals(setOf("carthorse"), anagrams)
    }

    @Ignore
    @Test
    fun detectsAnagramsUsingCaseInsensitiveCandidates() {
        val detector = Anagram("orchestra")
        val anagrams = detector.match(listOf("cashregister", "Carthorse", "radishes"))
        assertEquals(setOf("Carthorse"), anagrams)
    }

    @Ignore
    @Test
    fun doesNotDetectAnAnagramIfTheOriginalWordIsRepeated() {
        val detector = Anagram("go")
        val anagrams = detector.match(listOf("go Go GO"))
        assertEquals(emptySet(), anagrams)
    }

    @Ignore
    @Test
    fun anagramsMustUseAllLettersExactlyOnce() {
        val detector = Anagram("tapper")
        val anagrams = detector.match(listOf("patter"))
        assertEquals(emptySet(), anagrams)
    }

    @Ignore
    @Test
    fun doesNotDetectIdenticalUppercasedWordAsAnagram() {
        val detector = Anagram("BANANA")
        val anagrams = detector.match(listOf("Banana"))
        assertEquals(emptySet(), anagrams)
    }
}
