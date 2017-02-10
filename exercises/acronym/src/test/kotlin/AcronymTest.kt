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
    fun fromInconsistentlyCasedPhrases() {
        val phrase = "HyperText Markup Language"
        val expected = "HTML"
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
    fun fromOtherPhrasesWithPunctuation() {
        val phrase = "PHP: Hypertext Preprocessor"
        val expected = "PHP"
        assertEquals(expected, Acronym.generate(phrase))
    }

    @Ignore
    @Test
    fun fromPhrasesWithPunctuationAndSentenceCasing() {
        val phrase = "Complementary metal-oxide semiconductor"
        val expected = "CMOS"
        assertEquals(expected, Acronym.generate(phrase))
    }

}
