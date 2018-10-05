import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class RunLengthEncodingTest {

    private lateinit var runLengthEncoding: RunLengthEncoding

    @Before
    fun setUp() {
        runLengthEncoding = RunLengthEncoding()
    }

    @Test
    fun encodeEmpty() {
        assertEquals("", runLengthEncoding.encode(""))
    }

    @Test
    fun encodeWithOnlySingleValues() {
        assertEquals("XYZ", runLengthEncoding.encode("XYZ"))
    }

    @Test
    fun encodeWithNoSingleValues() {
        assertEquals("2A3B4C", runLengthEncoding.encode("AABBBCCCC"))
    }

    @Test
    fun encodeWithMixedValues() {
        assertEquals("12WB12W3B24WB", runLengthEncoding.encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))
    }

    @Test
    fun encodeWithWhitespaceValues() {
        assertEquals("2 hs2q q2w2 ", runLengthEncoding.encode("  hsqq qww  "))
    }

    @Test
    fun encodeWithLowercaseValues() {
        assertEquals("2a3b4c", runLengthEncoding.encode("aabbbcccc"))
    }

    @Test
    fun decodeEmpty() {
        assertEquals("", runLengthEncoding.decode(""))
    }

    @Test
    fun decodeWithOnlySingleValues() {
        assertEquals("XYZ", runLengthEncoding.decode("XYZ"))
    }

    @Test
    fun decodeWithNoSingleValues() {
        assertEquals("AABBBCCCC", runLengthEncoding.decode("2A3B4C"))
    }

    @Test
    fun decodeWithMixedValues() {
        assertEquals("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB", runLengthEncoding.decode("12WB12W3B24WB"))
    }

    @Test
    fun decodeWithWhitespaceValues() {
        assertEquals("  hsqq qww  ", runLengthEncoding.decode("2 hs2q q2w2 "))
    }

    @Test
    fun decodeWithLowercaseValues() {
        assertEquals("aabbbcccc", runLengthEncoding.decode("2a3b4c"))
    }

    @Test
    fun encodeThenDecode() {
        val inOut = "zzz ZZ  zZ"
        val encoded = runLengthEncoding.encode(inOut)
        assertEquals(inOut, runLengthEncoding.decode(encoded))
    }
}