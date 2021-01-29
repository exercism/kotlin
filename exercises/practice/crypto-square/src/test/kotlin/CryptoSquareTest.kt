import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CryptoSquareTest {

    @Test
    fun `empty plaintext results in empty ciphertext`() {
        val plaintext = ""
        val expectedOutput = ""
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }

    @Test
    fun `letters are lower cased during encryption`() {
        val plaintext = "A"
        val expectedOutput = "a"
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }

    @Test
    fun `spaces are removed during encryption`() {
        val plaintext = " b "
        val expectedOutput = "b"
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }

    @Test
    fun `punctuation is removed during encryption`() {
        val plaintext = "@1,%!"
        val expectedOutput = "1"
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }

    @Test
    fun `nine character plaintext results in three chunks of three characters`() {
        val plaintext = "This is fun!"
        val expectedOutput = "tsf hiu isn"
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }

    @Test
    fun `eight character plaintext results in three chunks with a trailing space`() {
        val plaintext = "Chill out."
        val expectedOutput = "clu hlt io "
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }

    @Test
    fun `fifty four character plaintext results in seven chunks with trailing spaces`() {
        val plaintext = "If man was meant to stay on the ground, god would have given us roots."
        val expectedOutput = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "
        assertEquals(expectedOutput, CryptoSquare.ciphertext(plaintext))
    }
}
