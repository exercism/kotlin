import org.junit.Test
import org.junit.Ignore

class IncorrectKeyCipherTest {


    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAllCapsKey() {
        Cipher("ABCDEF")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAnyCapsKey() {
        Cipher("abcdEFg")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithNumericKey() {
        Cipher("12345")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAnyNumericKey() {
        Cipher("abcd345ef")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithEmptyKey() {
        Cipher("")
    }
}
