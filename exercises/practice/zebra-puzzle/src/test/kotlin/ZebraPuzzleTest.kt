import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class ZebraPuzzleTest {

    @Test
    fun `resident who drinks water`() = assertEquals("Norwegian", ZebraPuzzle().drinksWater())

    @Ignore
    @Test
    fun `resident who owns zebra`() = assertEquals("Japanese", ZebraPuzzle().ownsZebra())

}
