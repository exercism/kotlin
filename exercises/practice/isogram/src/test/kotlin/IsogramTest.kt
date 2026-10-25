import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsogramTest() {

    @Test
    fun `empty string`() {
        assertTrue(Isogram.isIsogram(""))
    }

    @Ignore
    @Test
    fun `isogram with only lower case letters`() {
        assertTrue(Isogram.isIsogram("isogram"))
    }

    @Ignore
    @Test
    fun `word with one duplicated letter`() {
        assertFalse(Isogram.isIsogram("eleven"))
    }

    @Ignore
    @Test
    fun `word with one duplicated letter from end of alphabet`() {
        assertFalse(Isogram.isIsogram("zzyzx"))
    }

    @Ignore
    @Test
    fun `longest reported english isogram`() {
        assertTrue(Isogram.isIsogram("subdermatoglyphic"))
    }

    @Ignore
    @Test
    fun `word with duplicated character in mixed case`() {
        assertFalse(Isogram.isIsogram("Alphabet"))
    }

    @Ignore
    @Test
    fun `word with duplicated character in mixed case, lowercase first`() {
        assertFalse(Isogram.isIsogram("alphAbet"))
    }

    @Ignore
    @Test
    fun `hypothetical isogrammic word with hyphen`() {
        assertTrue(Isogram.isIsogram("thumbscrew-japingly"))
    }

    @Ignore
    @Test
    fun `hypothetical word with duplicated character following hyphen`() {
        assertFalse(Isogram.isIsogram("thumbscrew-jappingly"))
    }

    @Ignore
    @Test
    fun `isogram with duplicated hyphen`() {
        assertTrue(Isogram.isIsogram("six-year-old"))
    }

    @Ignore
    @Test
    fun `made-up name that is an isogram`() {
        assertTrue(Isogram.isIsogram("Emily Jung Schwartzkopf"))
    }

    @Ignore
    @Test
    fun `duplicated character in the middle`() {
        assertFalse(Isogram.isIsogram("accentor"))
    }

    @Ignore
    @Test
    fun `same first and last characters`() {
        assertFalse(Isogram.isIsogram("angola"))
    }

    @Ignore
    @Test
    fun `word with duplicated character and with two hyphens`() {
        assertFalse(Isogram.isIsogram("up-to-date"))
    }
}
