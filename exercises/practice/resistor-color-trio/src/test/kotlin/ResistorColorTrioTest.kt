import kotlin.test.Test
import kotlin.test.assertEquals
import Color.*

class ResistorColorTrioTest {

    @Test
    fun `orange orange black`() = assertEquals("33 ohms", ResistorColorTrio.text(ORANGE, ORANGE, BLACK))

    @Test
    fun `blue grey brown`() = assertEquals("680 ohms", ResistorColorTrio.text(BLUE, GREY, BROWN))

    @Test
    fun `red black red`() = assertEquals("2 kiloohms", ResistorColorTrio.text(RED, BLACK, RED))

    @Test
    fun `green brown orange`() = assertEquals("51 kiloohms", ResistorColorTrio.text(GREEN, BROWN, ORANGE))

    @Test
    fun `yellow violet yellow`() = assertEquals("470 kiloohms", ResistorColorTrio.text(YELLOW, VIOLET, YELLOW))

    @Test
    fun `yellow violet violet`() = assertEquals("470 megaohms", ResistorColorTrio.text(YELLOW, VIOLET, VIOLET))
}
