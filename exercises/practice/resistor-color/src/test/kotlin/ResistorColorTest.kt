import kotlin.test.Ignore
import kotlin.test.assertEquals
import kotlin.test.Test

class ResistorColorTest {

    @Test
    fun testBlackColorCode() = assertEquals(0, ResistorColor.colorCode("black"))

    @Ignore
    @Test
    fun testWhiteColorCode() = assertEquals(9, ResistorColor.colorCode("white"))

    @Ignore
    @Test
    fun testOrangeColorCode() = assertEquals(3, ResistorColor.colorCode("orange"))

    @Ignore
    @Test
    fun testColors() {
        val expected = listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")
        assertEquals(expected, ResistorColor.colors())
    }
}
