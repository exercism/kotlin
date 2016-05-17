import org.junit.Test

class IncorrectKeyCipherTest {

    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAllCapsKey() {
        Cipher("ABCDEF")
    }

    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAnyCapsKey() {
        Cipher("abcdEFg")
    }

    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithNumericKey() {
        Cipher("12345")
    }

    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAnyNumericKey() {
        Cipher("abcd345ef")
    }

    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithEmptyKey() {
        Cipher("")
    }
}
