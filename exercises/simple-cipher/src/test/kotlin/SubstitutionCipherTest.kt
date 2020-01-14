import org.junit.Before
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SubstitutionCipherTest {

    @Test
    fun `can encode`() = "abcdefghij".let { assertEquals(it, Cipher(it).encode("aaaaaaaaaa")) }

    @Ignore
    @Test
    fun `can decode`() = "abcdefghij".let { assertEquals("aaaaaaaaaa", Cipher(it).decode(it)) }

    @Ignore
    @Test
    fun `is reversible`() = with(Cipher("abcdefghij")) { assertEquals(key, decode(encode(key))) }

    @Ignore
    @Test
    fun `can double shift encode`() =
        "iamapandabear".let { assertEquals("qayaeaagaciai", Cipher(it).encode(it)) }

    @Ignore
    @Test
    fun `can wrap on encode`() =
        assertEquals("zabcdefghi", Cipher("abcdefghij").encode("zzzzzzzzzz"))

    @Ignore
    @Test
    fun `can wrap on decode`() =
        assertEquals("zzzzzzzzzz", Cipher("abcdefghij").decode("zabcdefghi"))

    @Ignore
    @Test
    fun `can encode messages longer than the key`() =
        assertEquals("iboaqcnecbfcr", Cipher("abc").encode("iamapandabear"))

    @Ignore
    @Test
    fun `can decode messages longer than the key`() =
        assertEquals("iamapandabear", Cipher("abc").decode("iboaqcnecbfcr"))

    // extra tests

    @Ignore
    @Test
    fun `keeps the given key`() = "abcdefghij".let { assertEquals(it, Cipher(it).key) }


}
