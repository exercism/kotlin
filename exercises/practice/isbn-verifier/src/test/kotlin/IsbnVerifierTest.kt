import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsbnVerifierTest {
    @Test
    fun `valid - reguar isbn`() = assertValid("3-598-21508-8")

    @Ignore
    @Test
    fun `invalid - check digit`() = assertInvalid("3-598-21508-9")

    @Ignore
    @Test
    fun `valid - check digit is 10`() = assertValid("3-598-21507-X")

    @Ignore
    @Test
    fun `invalid - check digit is character other than X`() = assertInvalid("3-598-21507-A")

    @Ignore
    @Test
    fun `invalid - forbidden character`() = assertInvalid("3-598-P1581-X")

    @Ignore
    @Test
    fun `invalid - X is only valid as check digit`() = assertInvalid("3-598-2X507-9")

    @Ignore
    @Test
    fun `valid - without separating dashes`() = assertValid("3598215088")

    @Ignore
    @Test
    fun `valid - without separating dashes and X as check digit`() = assertValid("359821507X")

    @Ignore
    @Test
    fun `invalid - without check digit and dashes`() = assertInvalid("359821507")

    @Ignore
    @Test
    fun `invalid - too long and no dashes`() = assertInvalid("3598215078X")

    @Ignore
    @Test
    fun `invalid - too short`() = assertInvalid("00")

    @Ignore
    @Test
    fun `invalid - without check digit`() = assertInvalid("3-598-21507")

    @Ignore
    @Test
    fun `invalid - check digit of X is not used for 0`() = assertInvalid("3-598-21515-X")

    @Ignore
    @Test
    fun `invalid - empty`() = assertInvalid("")

    @Ignore
    @Test
    fun `invalid - input is 9 characters`() = assertInvalid("134456729")

    @Ignore
    @Test
    fun `invalid - prohibited characters are not ignored`() = assertInvalid("3132P34035")

    @Ignore
    @Test
    fun `invalid - too long but contains valid isbn`() = assertInvalid("98245726788")
}

private fun assertValid(isbn: String) = assertTrue(IsbnVerifier().isValid(isbn))

private fun assertInvalid(isbn: String) = assertFalse(IsbnVerifier().isValid(isbn))
