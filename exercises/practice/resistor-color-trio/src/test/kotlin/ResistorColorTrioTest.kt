import kotlin.test.Test
import kotlin.test.assertEquals
import Color.*
import kotlin.test.Ignore

class ResistorColorTrioTest {

    @Test
    fun `orange orange black`() = assertEquals("33 ohms", ResistorColorTrio.text(ORANGE, ORANGE, BLACK))

    @Ignore
    @Test
    fun `blue grey brown`() = assertEquals("680 ohms", ResistorColorTrio.text(BLUE, GREY, BROWN))

    @Ignore
    @Test
    fun `red black red`() = assertEquals("2 kiloohms", ResistorColorTrio.text(RED, BLACK, RED))

    @Ignore
    @Test
    fun `green brown orange`() = assertEquals("51 kiloohms", ResistorColorTrio.text(GREEN, BROWN, ORANGE))

    @Ignore
    @Test
    fun `yellow violet yellow`() = assertEquals("470 kiloohms", ResistorColorTrio.text(YELLOW, VIOLET, YELLOW))

    @Ignore
    @Test
    fun `yellow violet violet`() = assertEquals("470 megaohms", ResistorColorTrio.text(YELLOW, VIOLET, VIOLET))
}
