import org.junit.Before
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SubstitutionCipherTest {

    private val KEY = "abcdefghij"
    private lateinit var cipher: Cipher

    @Before
    fun setup() {
        this.cipher = Cipher(KEY)
    }


    @Test
    fun cipherKeepsTheSubmittedKey() {
        assertEquals(KEY, cipher.key)
    }

    @Ignore
    @Test
    fun cipherCanEncodeWithGivenKey() {
        val expectedOutput = "abcdefghij"

        assertEquals(expectedOutput, cipher.encode("aaaaaaaaaa"))
    }

    @Ignore
    @Test
    fun cipherCanDecodeWithGivenKey() {
        val expectedOutput = "aaaaaaaaaa"

        assertEquals(expectedOutput, cipher.decode("abcdefghij"))
    }

    @Ignore
    @Test
    fun cipherIsReversibleGivenKey() {
        val plainText = "abcdefghij"

        assertEquals(plainText, cipher.decode(cipher.encode("abcdefghij")))
    }

    @Ignore
    @Test
    fun cipherCanDoubleShiftEncode() {
        val plainText = "iamapandabear"
        val expectedOutput = "qayaeaagaciai"

        assertEquals(expectedOutput, Cipher(plainText).encode(plainText))
    }

    @Ignore
    @Test
    fun cipherCanWrapEncode() {
        val expectedOutput = "zabcdefghi"

        assertEquals(expectedOutput, cipher.encode("zzzzzzzzzz"))
    }

    @Ignore
    @Test
    fun cipherCanEncodeMessageThatIsShorterThanTheKey() {
        val expectedOutput = "abcde"

        assertEquals(expectedOutput, cipher.encode("aaaaa"))
    }

    @Ignore
    @Test
    fun cipherCanDecodeMessageThatIsShorterThanTheKey() {
        val expectedOutput = "aaaaa"

        assertEquals(expectedOutput, cipher.decode("abcde"))
    }
}
