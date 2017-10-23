import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class WordCountTest {

    @Test
    fun countOneWord() {
        val expectedWordCount = mapOf("word" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("word"))
    }

    @Ignore
    @Test
    fun countOneOfEach() {
        val expectedWordCount = mapOf("one" to 1, "of" to 1, "each" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one of each"))
    }

    @Ignore
    @Test
    fun countMultipleOccurrences() {
        val expectedWordCount = mapOf("one" to 1, "fish" to 4, "two" to 1, "red" to 1, "blue" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one fish two fish red fish blue fish"))
    }

    @Ignore
    @Test
    fun countCrampedList() {
        val expectedWordCount = mapOf("one" to 1, "two" to 1, "three" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one,two,three"))
    }

    @Ignore
    @Test
    fun countExpandedList() {
        val expectedWordCount = mapOf("one" to 1, "two" to 1, "three" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one,\ntwo,\nthree"))
    }

    @Ignore
    @Test
    fun ignorePunctuation() {
        val expectedWordCount = mapOf("car" to 1, "carpet" to 1, "as" to 1, "java" to 1, "javascript" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("car: carpet as java: javascript!!&@\$%^&"))
    }

    @Ignore
    @Test
    fun countsNumbers() {
        val expectedWordCount = mapOf("testing" to 2, "1" to 1, "2" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("testing, 1, 2 testing"))
    }

    @Ignore
    @Test
    fun countsCaseInsensitively() {
        val expectedWordCount = mapOf("go" to 3, "stop" to 2)

        assertEquals(expectedWordCount, WordCount.phrase("go Go GO Stop stop"))
    }

    @Ignore
    @Test
    fun allowsApostrophes() {
        val expectedWordCount = mapOf("first" to 1, "don't" to 2, "laugh" to 1, "then" to 1, "cry" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("First: don't laugh. Then: don't cry."))
    }

    @Ignore
    @Test
    fun allowsQuotations() {
        val expectedWordCount = mapOf("joe" to 1, "can't" to 1, "tell" to 1, "between" to 1, "large" to 2, "and" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("Joe can't tell between 'large' and large."))
    }

}
