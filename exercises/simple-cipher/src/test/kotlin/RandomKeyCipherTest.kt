import org.junit.Before
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class RandomKeyCipherTest {

    private lateinit var cipher: Cipher

    @Before
    fun setup() {
        cipher = Cipher()
    }


    @Test
    fun cipherKeyIsMadeOfLetters() {
        assertTrue(cipher.key.matches(Regex("[a-z]+")))
    }

    @Ignore
    @Test
    fun defaultCipherKeyIs100Characters() {
        assertEquals(100, cipher.key.length)
    }

    @Ignore
    @Test
    fun cipherKeysAreRandomlyGenerated() {
        assertNotEquals(Cipher().key, cipher.key)
    }

    /**
     * Here we take advantage of the fact that plaintext of "aaa..." doesn't output the key. This is a critical problem
     * with shift ciphers, some characters will always output the key verbatim.
     */
    @Ignore
    @Test
    fun cipherCanEncode() {
        val expectedOutput = cipher.key.substring(0, 10)

        assertEquals(expectedOutput, cipher.encode("aaaaaaaaaa"))
    }

    @Ignore
    @Test
    fun cipherCanDecode() {
        val expectedOutput = "aaaaaaaaaa"

        assertEquals(expectedOutput, cipher.decode(cipher.key.substring(0, 10)))
    }

    @Ignore
    @Test
    fun cipherIsReversible() {
        val plainText = "abcdefghij"

        assertEquals(plainText, cipher.decode(cipher.encode(plainText)))
    }
}
