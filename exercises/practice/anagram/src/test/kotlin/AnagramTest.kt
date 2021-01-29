import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnagramTest {

    @Test
    fun `no matches`() =
        anagramsOf("diaper")
            .searchedIn("hello", "world", "zombies", "pants")
            .shouldBeEmpty()

    @Ignore
    @Test
    fun `detects two anagrams`() =
        anagramsOf("master")
            .searchedIn("stream", "pigeon", "maters")
            .shouldBeOnly("maters", "stream")

    @Ignore
    @Test
    fun `does not detect anagram subsets`() =
        anagramsOf("good")
            .searchedIn("dog", "goody")
            .shouldBeEmpty()

    @Ignore
    @Test
    fun `detects anagram`() =
        anagramsOf("listen")
            .searchedIn("enlists", "google", "inlets", "banana")
            .shouldBeOnly("inlets")

    @Ignore
    @Test
    fun `detects three anagrams`() =
        anagramsOf("allergy")
            .searchedIn("gallery", "ballerina", "regally", "clergy", "largely", "leading")
            .shouldBeOnly("gallery", "largely", "regally")

    @Ignore
    @Test
    fun `detects multiple anagrams with different case`() =
        anagramsOf("nose")
            .searchedIn("Eons", "ONES")
            .shouldBeOnly("Eons", "ONES")

    @Ignore
    @Test
    fun `does not detect non-anagrams with identical checksum`() =
        anagramsOf("mass")
            .searchedIn("last")
            .shouldBeEmpty()

    @Ignore
    @Test
    fun `detects anagrams case-insensitively`() =
        anagramsOf("Orchestra")
            .searchedIn("cashregister", "Carthorse", "radishes")
            .shouldBeOnly("Carthorse")

    @Ignore
    @Test
    fun `detects anagrams using case-insensitive subject`() =
        anagramsOf("Orchestra")
            .searchedIn("cashregister", "carthorse", "radishes")
            .shouldBeOnly("carthorse")

    @Ignore
    @Test
    fun `detects anagrams using case-insensitive possible matches`() =

        anagramsOf("orchestra")
            .searchedIn("cashregister", "Carthorse", "radishes")
            .shouldBeOnly("Carthorse")

    @Ignore
    @Test
    fun `does not detect an anagram if the original word is repeated`() =
        anagramsOf("go")
            .searchedIn("go Go GO")
            .shouldBeEmpty()

    @Ignore
    @Test
    fun `anagrams must use all letters exactly once`() =
        anagramsOf("tapper")
            .searchedIn("patter")
            .shouldBeEmpty()

    @Ignore
    @Test
    fun `words are not anagrams of themselves (case-insensitive)`() =
        anagramsOf("BANANA")
            .searchedIn("Banana")
            .shouldBeEmpty()

    @Ignore
    @Test
    fun `words other than themselves can be anagrams`() =
        anagramsOf("LISTEN")
            .searchedIn("Listen", "Silent", "LISTEN")
            .shouldBeOnly("Silent")
}

private fun anagramsOf(source: String) = Anagram(source)
private fun Anagram.searchedIn(vararg variants: String) = this.match(setOf(*variants))
private fun Set<String>.shouldBeOnly(vararg expectation: String) = assertEquals(setOf(*expectation), this)
private fun Set<String>.shouldBeEmpty() = assertTrue(this.isEmpty())
