import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LuhnTest {

    @Test
    fun `invalid - single digit`() = assertInvalid("1")

    @Ignore
    @Test
    fun `invalid - a single zero`() = assertInvalid("0")

    @Ignore
    @Test
    fun `valid - simple reversable`() = assertValid("059")

    @Ignore
    @Test
    fun `valid - simple unreversable`() = assertValid("59")

    @Ignore
    @Test
    fun `valid - Canadian`() = assertValid("055 444 285")

    @Ignore
    @Test
    fun `invalid - Canadian`() = assertInvalid("055 444 286")

    @Ignore
    @Test
    fun `invalid - credit card`() = assertInvalid("8273 1232 7352 0569")

    @Ignore
    @Test
    fun `invalid - long number with an even remainder`() = assertInvalid("1 2345 6789 1234 5678 9012")

    @Ignore
    @Test
    fun `invalid long number with a remainder divisible by 5`() = assertInvalid("1 2345 6789 1234 5678 9013")

    @Ignore
    @Test
    fun `valid - even amount of digits`() = assertValid("095 245 88")

    @Ignore
    @Test
    fun `valid - odd amount of spaces`() = assertValid("234 567 891 234")

    @Ignore
    @Test
    fun `invalid - non-digit at the end of valid`() = assertInvalid("059a")

    @Ignore
    @Test
    fun `invalid - punctuation in valid`() = assertInvalid("055-444-285")

    @Ignore
    @Test
    fun `invalid - symbols in valid`() = assertInvalid("055# 444$ 285")

    @Ignore
    @Test
    fun `invalid - single zero with space`() = assertInvalid(" 0")

    @Ignore
    @Test
    fun `valid - many zeros`() = assertValid("0000 0")

    @Ignore
    @Test
    fun `valid - input digit 9`() = assertValid("091")

    /**
     * Designed to prevent converting input to a single number
     * as this approach can risk an overflow
     */
    @Ignore
    @Test
    fun `valid - very long input`() =
        assertValid("9999999999 9999999999 9999999999 9999999999")

    @Ignore
    @Test
    fun `valid | valid luhn with an odd number of digits and non zero first digit`() = assertValid("109")

    /**
     * Convert non-digits to their ascii values and then offset them by 48
     * sometimes accidentally declare an invalid string to be valid.
     * This test is designed to avoid that solution.
     */
    @Ignore
    @Test
    fun `invalid - ascii value for non-doubled non-digit in the middle`() = assertInvalid("055b 444 285")

    /**
     * Convert non-digits to their ascii values and then offset them by 48
     * sometimes accidentally declare an invalid string to be valid.
     * This test is designed to avoid that solution.
     */
    @Ignore
    @Test
    fun `invalid - ascii value for non-doubled non-digit at the start`() = assertInvalid(":9")

    @Ignore
    @Test
    fun `non-numeric, non-space char in the middle with a sum that's divisible by 10 isn't allowed`() =
        assertInvalid("59%59")
}

private fun assertValid(value: String) = assertTrue(Luhn.isValid(value))
private fun assertInvalid(value: String) = assertFalse(Luhn.isValid(value))
