import org.junit.Test
import kotlin.test.assertEquals

class WordCountTest {

    @Test
    fun countOneWord() {
        val expectedWordCount = mapOf("word" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("word"))
    }

    @Test
    fun countOneOfEach() {
        val expectedWordCount = mapOf("one" to 1, "of" to 1, "each" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one of each"))
    }

    @Test
    fun countMultipleOccurences() {
        val expectedWordCount = mapOf("one" to 1, "fish" to 4, "two" to 1, "red" to 1, "blue" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one fish two fish red fish blue fish"))
    }

    @Test
    fun ignorePunctuation() {
        val expectedWordCount = mapOf("car" to 1, "carpet" to 1, "as" to 1, "java" to 1, "javascript" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("car : carpet as java : javascript!!&@$%^&"))

    }

    @Test
    fun includeNumbers() {
        val expectedWordCount = mapOf("testing" to 2, "1" to 1, "2" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("testing, 1, 2 testing"))
    }

    @Test
    fun normalizeCase() {
        val expectedWordCount = mapOf("go" to 3)

        assertEquals(expectedWordCount, WordCount.phrase("go Go GO"))
    }

    @Test
    fun allowApostrophes() {
        val expectedWordCount = mapOf("first" to 1, "don't" to 2, "laugh" to 1, "then" to 1, "cry" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("First: don't laugh. Then: don't cry."))
    }

}
