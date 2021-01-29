import org.junit.Test
import org.junit.Ignore

/**
 * Extra tests
 */
class IncorrectKeyCipherTest {

    @Test(expected = IllegalArgumentException::class)
    fun  `key cannot consist of upper cased letters`() {
        Cipher("ABCDEF")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `key cannot contain upper cased letters`() {
        Cipher("abcdEFg")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `key cannot consist of digits`() {
        Cipher("12345")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `key cannot contain digits`() {
        Cipher("abcd345ef")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `key cannot be empty`() {
        Cipher("")
    }
}
