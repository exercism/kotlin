import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class AcronymTest {

    @Test
    fun fromTitleCasedPhrases() {
        val phrase = "Portable Network Graphics"
        val expected = "PNG"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromOtherTitleCasedPhrases() {
        val phrase = "Ruby on Rails"
        val expected = "ROR"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromPhrasesWithPunctuation() {
        val phrase = "First In, First Out"
        val expected = "FIFO"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromNonAcronymAllCapsWord() {
        val phrase = "GNU Image Manipulation Program"
        val expected = "GIMP"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromPhrasesWithPunctuationAndSentenceCasing() {
        val phrase = "Complementary metal-oxide semiconductor"
        val expected = "CMOS"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromVeryLongAbbreviation() {
        val phrase = "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me"
        val expected = "ROTFLSHTMDCOALM"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromConsecutiveDelimiters() {
        val phrase = "Something - I made up from thin air"
        val expected = "SIMUFTA"
        assertEquals(expected, Acronym.generate(phrase))
    }
}
