import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class RandomKeyCipherTest {

    @Test
    fun `can encode`() = with(Cipher()) {
        assertEquals(key.substring(0, 10), encode("aaaaaaaaaa"))
    }

    @Ignore
    @Test
    fun `can decode`() = with(Cipher()) {
        assertEquals("aaaaaaaaaa", decode(key.substring(0, 10)))
    }

    @Ignore
    @Test
    fun `key is made only of lowercase letters`() {
        assertTrue(Cipher().key.matches(Regex("[a-z]+")))
    }

    @Ignore
    @Test
    fun `is reversible`() {
        val plainText = "abcdefghij"
        with(Cipher()) { assertEquals(plainText, decode(encode(plainText))) }
    }

    // extra tests

    @Ignore
    @Test
    fun `default key is of length 100`() {
        assertEquals(100, Cipher().key.length)
    }

    @Ignore
    @Test
    fun `two default generated keys differs`() {
        assertNotEquals(Cipher().key, Cipher().key)
    }

}
