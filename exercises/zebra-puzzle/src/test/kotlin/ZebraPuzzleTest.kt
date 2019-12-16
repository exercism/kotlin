import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ZebraPuzzleTest {

    @Test
    fun `resident who drinks water`() = assertEquals("Norwegian", ZebraPuzzle().drinksWater())

    @Test
    fun `resident who owns zebra`() = assertEquals("Japanese", ZebraPuzzle().ownsZebra())

}
