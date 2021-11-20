import org.junit.Ignore
import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertNull

class PhoneNumberTest {

    @Test
    fun `valid - simple number`() = assertNumberEquals("(223) 456-7890", "2234567890")

    @Ignore
    @Test
    fun `valid - number with dots`() = assertNumberEquals("223.456.7890", "2234567890")

    @Ignore
    @Test
    fun `valid - numbers with multiple spaces`() = assertNumberEquals("223 456   7890   ", "2234567890")

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - 9 digit`() {
        PhoneNumber("123456789")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - when 11 digits does not start with a 1`() {
        PhoneNumber("22234567890")
    }

    @Ignore
    @Test
    fun `valid - 11 digits and starting with 1`() = assertNumberEquals("12234567890", "2234567890")

    @Ignore
    @Test
    fun `valid - 11 digits starting with 1 with punctuation`() = assertNumberEquals("+1 (223) 456-7890", "2234567890")

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - more than 11 digits`() {
        PhoneNumber("321234567890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - letters`() {
        PhoneNumber("123-abc-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - punctuations`() {
        PhoneNumber("123-@:!-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - area code starts with 0`() {
        PhoneNumber("(023) 456-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - area code starts with 1`() {
        PhoneNumber("(123) 456-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - exchange code starts with 0`() {
        PhoneNumber("(223) 056-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - exchange code starts with 1`() {
        PhoneNumber("(223) 156-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - area code starts with 0 on valid 11-digit number`() {
        PhoneNumber("1 (023) 456-7890")
    }


    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - area code starts with 1 on valid 11-digit number`() {
        PhoneNumber("1 (123) 456-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - exchange code starts with 0 on valid 11-digit number`() {
        PhoneNumber("1 (223) 056-7890")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid - exchange code starts with 1 on valid 11-digit number`() {
        PhoneNumber("1 (223) 156-7890")
    }
}

private fun assertNumberEquals(input: String, expectation: String) = assertEquals(expectation, PhoneNumber(input).number)
