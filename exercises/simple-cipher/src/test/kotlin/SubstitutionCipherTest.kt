import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SubstitutionCipherTest {

    private val KEY = "abcdefghij";
    private lateinit var cipher: Cipher;

    @Before
    fun setup() {
        this.cipher = Cipher(KEY);
    }

    @Test
    fun cipherKeepsTheSubmittedKey() {
        assertEquals(KEY, cipher.key);
    }

    @Test
    fun cipherCanEncodeWithGivenKey() {
        val expectedOutput = "abcdefghij";

        assertEquals(expectedOutput, cipher.encode("aaaaaaaaaa"));
    }

    @Test
    fun cipherCanDecodeWithGivenKey() {
        val expectedOutput = "aaaaaaaaaa";

        assertEquals(expectedOutput, cipher.decode("abcdefghij"));
    }

    @Test
    fun cipherIsReversibleGivenKey() {
        val plainText = "abcdefghij";

        assertEquals(plainText, cipher.decode(cipher.encode("abcdefghij")));
    }

    @Test
    fun cipherCanDoubleShiftEncode() {
        val plainText = "iamapandabear";
        val expectedOutput = "qayaeaagaciai";

        assertEquals(expectedOutput, Cipher(plainText).encode(plainText));
    }

    @Test
    fun cipherCanWrapEncode() {
        val expectedOutput = "zabcdefghi";

        assertEquals(expectedOutput, cipher.encode("zzzzzzzzzz"));
    }

    @Test
    fun cipherCanEncodeMessageThatIsShorterThanTheKey() {
        val expectedOutput = "abcde";

        assertEquals(expectedOutput, cipher.encode("aaaaa"));
    }

    @Test
    fun cipherCanDecodeMessageThatIsShorterThanTheKey() {
        val expectedOutput = "aaaaa";

        assertEquals(expectedOutput, cipher.decode("abcde"));
    }
}
