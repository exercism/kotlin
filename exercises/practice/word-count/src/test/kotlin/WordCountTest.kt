import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class WordCountTest {

    @Test
    fun `one word`() = assertWordCountEqual(
        "word",
        "word" to 1
    )

    @Ignore
    @Test
    fun `one of each word`() = assertWordCountEqual(
        "one of each",
        "one" to 1,
        "of" to 1,
        "each" to 1
    )

    @Ignore
    @Test
    fun `multiple occurrences of a word`() = assertWordCountEqual(
        "one fish two fish red fish blue fish",
        "one" to 1,
        "fish" to 4,
        "two" to 1,
        "red" to 1,
        "blue" to 1
    )

    @Ignore
    @Test
    fun `cramped list`() = assertWordCountEqual(
        "one,two,three",
        "one" to 1,
        "two" to 1,
        "three" to 1
    )

    @Ignore
    @Test
    fun `expanded list`() = assertWordCountEqual(
        "one,\ntwo,\nthree",
        "one" to 1,
        "two" to 1,
        "three" to 1
    )

    @Ignore
    @Test
    fun `punctuation is ignored`() = assertWordCountEqual(
        "car: carpet as java: javascript!!&@\$%^&",
        "car" to 1,
        "carpet" to 1,
        "as" to 1,
        "java" to 1,
        "javascript" to 1
    )

    @Ignore
    @Test
    fun `numbers are allowed`() = assertWordCountEqual(
        "testing, 1, 2 testing",
        "testing" to 2,
        "1" to 1,
        "2" to 1
    )

    @Ignore
    @Test
    fun `case insensitive`() = assertWordCountEqual(
        "go Go GO Stop stop",
        "go" to 3,
        "stop" to 2
    )

    @Ignore
    @Test
    fun `apostrophes are allowed`() = assertWordCountEqual(
        "First: don't laugh. Then: don't cry.",
        "first" to 1,
        "don't" to 2,
        "laugh" to 1,
        "then" to 1,
        "cry" to 1
    )

    @Ignore
    @Test
    fun `quotations are allowed`() = assertWordCountEqual(
        "Joe can't tell between 'large' and large.",
        "joe" to 1,
        "can't" to 1,
        "tell" to 1,
        "between" to 1,
        "large" to 2,
        "and" to 1
    )

    @Ignore
    @Test
    fun `heading substring`() = assertWordCountEqual(
        "Joe can't tell between app, apple and a.",
        "joe" to 1,
        "can't" to 1,
        "tell" to 1,
        "between" to 1,
        "app" to 1,
        "apple" to 1,
        "and" to 1,
        "a" to 1
    )

    @Ignore
    @Test
    fun `multiple spaces`() = assertWordCountEqual(
        " multiple   whitespaces",
        "multiple" to 1,
        "whitespaces" to 1
    )

    @Ignore
    @Test
    fun `various separators`() =
        assertWordCountEqual(
            ",\n,one,\n ,two \n 'three'",
            "one" to 1,
            "two" to 1,
            "three" to 1
        )
}

private fun assertWordCountEqual(phrase: String, vararg expectations: Pair<String, Int>) =
    assertEquals(expectations.toMap(), WordCount.phrase(phrase))
