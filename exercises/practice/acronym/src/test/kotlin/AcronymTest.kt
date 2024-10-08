import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class AcronymTest {
    @Test
    fun `capitalized words`() = assertAcronymEquals(
            "Portable Network Graphics",
            "PNG")

    @Test
    fun `lowercase word in the middle`() = assertAcronymEquals(
            "Ruby on Rails",
            "ROR")

    @Test
    fun `punctuation is ignored`() = assertAcronymEquals(
            "First In, First Out",
            "FIFO")

    @Test
    fun `uppercased word at the start`() = assertAcronymEquals(
            "GNU Image Manipulation Program",
            "GIMP")

    @Test
    fun `hyphen is ignored`() = assertAcronymEquals(
            "Complementary metal-oxide semiconductor",
            "CMOS")

    @Test
    fun `lots of words`() = assertAcronymEquals(
            "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me",
            "ROTFLSHTMDCOALM")

    @Test
    fun `consecutive delimiters`() = assertAcronymEquals(
            "Something - I made up from thin air",
            "SIMUFTA")

    @Test
    fun `apostrophe is ignored`() = assertAcronymEquals(
            "Halley's Comet",
            "HC")

    @Test
    fun `underscore emphasis is ignored`() = assertAcronymEquals(
            "The Road _Not_ Taken",
            "TRNT")
}

private fun assertAcronymEquals(origin: String, acronym: String) = assertEquals(acronym, Acronym.generate(origin))
