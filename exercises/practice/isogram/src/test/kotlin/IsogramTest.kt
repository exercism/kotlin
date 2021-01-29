import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class IsogramTest(val input: String, val expectedOutput: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: isogram({0}) = {1}")
        fun data() = listOf(
                arrayOf("", true),
                arrayOf("isogram", true),
                arrayOf("eleven", false),
                arrayOf("zzyzx", false),
                arrayOf("subdermatoglyphic", true),
                arrayOf("Alphabet", false),
                arrayOf("alphAbet", false),
                arrayOf("thumbscrew-japingly", true),
                arrayOf("thumbscrew-jappingly", false),
                arrayOf("six-year-old", true),
                arrayOf("Emily Jung Schwartzkopf", true),
                arrayOf("accentor", false),
                arrayOf("angola", false)
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, Isogram.isIsogram(input))
    }

}
