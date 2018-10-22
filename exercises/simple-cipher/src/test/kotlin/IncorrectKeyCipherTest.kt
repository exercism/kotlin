import org.junit.Test
import org.junit.Ignore

class IncorrectKeyCipherTest {


    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithAllCapsKey() {
        Cipher("ABCDEF")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithNumericKey() {
        Cipher("12345")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cipherThrowsWithEmptyKey() {
        Cipher("")
    }
}
