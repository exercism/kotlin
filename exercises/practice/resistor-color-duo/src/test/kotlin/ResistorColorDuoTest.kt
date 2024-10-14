import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class ResistorColorDuoTest {

    @Test
    fun `brown and black`() = assertEquals(10, ResistorColorDuo.value(Color.BROWN, Color.BLACK))

    @Ignore
    @Test
    fun `blue and grey`() = assertEquals(68, ResistorColorDuo.value(Color.BLUE, Color.GREY))

    @Ignore
    @Test
    fun `yellow and violet`() = assertEquals(47, ResistorColorDuo.value(Color.YELLOW, Color.VIOLET))

    @Ignore
    @Test
    fun `orange and orange`() = assertEquals(33, ResistorColorDuo.value(Color.ORANGE, Color.ORANGE))

    @Ignore
    @Test
    fun `ignore additional colors`() = assertEquals(51, ResistorColorDuo.value(Color.GREEN, Color.BROWN, Color.ORANGE))

}
