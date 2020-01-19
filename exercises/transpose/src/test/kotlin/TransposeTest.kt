import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.test.Test
import kotlin.test.assertEquals

class TransposeTest {

    @Test
    fun `empty string`() {
        val lines = listOf<String>()
        val expected = listOf<String>()
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun `two characters in a row`() {
        val lines = listOf("A1")
        val expected = listOf("A", "1")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun `two characters in a column`() {
        val lines = listOf("A", "1")
        val expected = listOf("A1")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun simple() {
        val lines = listOf("ABC", "123")
        val expected = listOf("A1", "B2", "C3")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun `single line`() {
        val lines = listOf("Single line.")
        val expected = listOf("S", "i", "n", "g", "l", "e", " ", "l", "i", "n", "e", ".")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun `first line longer than second line`() {
        val lines = listOf("The fourth line.", "The fifth line.")
        val expected = listOf("TT", "hh", "ee", "  ", "ff", "oi", "uf", "rt", "th", "h ", " l", "li", "in", "ne", "e.", ".")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun `second line longer than first line`() {
        val lines = listOf("The first line.", "The second line.")
        val expected = listOf("TT", "hh", "ee", "  ", "fs", "ie", "rc", "so", "tn", " d", "l ", "il", "ni", "en", ".e", " .")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun `mixed line length`() {
        val lines = listOf("The longest line.", "A long line.", "A longer line.", "A line.")
        val expected = listOf("TAAA", "h   ", "elll", " ooi", "lnnn", "ogge", "n e.", "glr", "ei ", "snl", "tei", " .n", "l e", "i .", "n", "e", ".")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun square() {
        val lines = listOf("HEART", "EMBER", "ABUSE", "RESIN", "TREND")
        val expected = listOf("HEART", "EMBER", "ABUSE", "RESIN", "TREND")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun rectangle() {
        val lines = listOf("FRACTURE", "OUTLINED", "BLOOMING", "SEPTETTE")
        val expected = listOf("FOBS", "RULE", "ATOP", "CLOT", "TIME", "UNIT", "RENT", "EDGE")
        assertEquals(expected, Transpose.transpose(lines))
    }

    @Test
    fun triangle() {
        val lines = listOf("T", "EE", "AAA", "SSSS", "EEEEE", "RRRRRR")
        val expected = listOf("TEASER", " EASER", "  ASER", "   SER", "    ER", "     R")
        assertEquals(expected, Transpose.transpose(lines))
    }

}
