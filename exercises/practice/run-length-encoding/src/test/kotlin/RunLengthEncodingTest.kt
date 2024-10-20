import kotlin.test.Test
import kotlin.test.assertEquals
import RunLengthEncoding.encode
import RunLengthEncoding.decode
import kotlin.test.Ignore

class RunLengthEncodingTest {

    @Test
    fun `encode_empty string`() = assertEquals("", encode(""))

    @Ignore
    @Test
    fun `encode_single characters only are encoded without count`() = assertEquals("XYZ", encode("XYZ"))

    @Ignore
    @Test
    fun `encode_string with no single characters`() = assertEquals("2A3B4C", encode("AABBBCCCC"))

    @Ignore
    @Test
    fun `encode_single characters mixed with repeated characters`() =
            assertEquals("12WB12W3B24WB", encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))

    @Ignore
    @Test
    fun `encode_multiple whitespace mixed in string`() = assertEquals("2 hs2q q2w2 ", encode("  hsqq qww  "))

    @Ignore
    @Test
    fun `encode_lowercase characters`() = assertEquals("2a3b4c", encode("aabbbcccc"))

    @Ignore
    @Test
    fun `decode_empty string`() = assertEquals("", decode(""))

    @Ignore
    @Test
    fun `decode_single characters only`() = assertEquals("XYZ", decode("XYZ"))

    @Ignore
    @Test
    fun `decode_string with no single characters`() = assertEquals("AABBBCCCC", decode("2A3B4C"))

    @Ignore
    @Test
    fun `decode_single characters with repeated characters`() =
            assertEquals("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB", decode("12WB12W3B24WB"))

    @Ignore
    @Test
    fun `decode_multiple whitespace mixed in string`() = assertEquals("  hsqq qww  ", decode("2 hs2q q2w2 "))

    @Ignore
    @Test
    fun `decode_lower case string`() = assertEquals("aabbbcccc", decode("2a3b4c"))

    @Ignore
    @Test
    fun `encode followed by decode gives original string`() = assertEquals("zzz ZZ  zZ", decode(encode("zzz ZZ  zZ")))

}
