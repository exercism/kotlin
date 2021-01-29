import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class ScrabbleScoreTest(val input: String, val expectedOutput: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: scoreWord({0})={1}")
        fun data() = listOf(
                arrayOf("a", 1),
                arrayOf("A", 1),
                arrayOf("f", 4),
                arrayOf("at", 2),
                arrayOf("zoo", 12),
                arrayOf("street", 6),
                arrayOf("quirky", 22),
                arrayOf("OxyphenButazone", 41),
                arrayOf("pinata", 8),
                arrayOf("", 0),
                arrayOf("abcdefghijklmnopqrstuvwxyz", 87)
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, ScrabbleScore.scoreWord(input))
    }

}
