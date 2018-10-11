
import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class RomanNumeralsTest(val input: Int, val expectedOutput: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: romanNumeral({0})={1}")
        fun data() = listOf(
                arrayOf(1, "I"),
                arrayOf(2, "II"),
                arrayOf(3, "III"),
                arrayOf(4, "IV"),
                arrayOf(5, "V"),
                arrayOf(6, "VI"),
                arrayOf(9, "IX"),
                arrayOf(27, "XXVII"),
                arrayOf(48, "XLVIII"),
                arrayOf(49, "XLIX"),
                arrayOf(59, "LIX"),
                arrayOf(93, "XCIII"),
                arrayOf(141, "CXLI"),
                arrayOf(163, "CLXIII"),
                arrayOf(402, "CDII"),
                arrayOf(575, "DLXXV"),
                arrayOf(911, "CMXI"),
                arrayOf(1024, "MXXIV"),
                arrayOf(3000, "MMM")
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, RomanNumeral.value(input))
    }

}
