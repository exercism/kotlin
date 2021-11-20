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
}

private fun assertValid(value: String) = assertTrue(Luhn.isValid(value))
private fun assertInvalid(value: String) = assertFalse(Luhn.isValid(value))
