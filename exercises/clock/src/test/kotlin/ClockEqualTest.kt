import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertNotEquals
import kotlin.test.assertEquals

class ClockEqualTest {

    @Ignore
    @Test
    fun `same time`() = assertEquals(Clock(15, 37), Clock(15, 37))

    @Ignore
    @Test
    fun `clocks a minute apart`() = assertNotEquals(Clock(15, 36), Clock(15, 37))

    @Ignore
    @Test
    fun `clocks an hour apart`() = assertNotEquals(Clock(14, 37), Clock(15, 37))

    @Ignore
    @Test
    fun `hour overflow`() = assertEquals(Clock(10, 37), Clock(34, 37))

    @Ignore
    @Test
    fun `hour overflow by several days`() = assertEquals(Clock(3, 11), Clock(99, 11))

    @Ignore
    @Test
    fun `negative hour`() = assertEquals(Clock(22, 40), Clock(-2, 40))

    @Ignore
    @Test
    fun `negative hour that wraps`() = assertEquals(Clock(17, 3), Clock(-31, 3))

    @Ignore
    @Test
    fun `negative hour that wraps multiple times`() = assertEquals(Clock(13, 49), Clock(-83, 49))

    @Ignore
    @Test
    fun `minute overflow`() = assertEquals(Clock(0, 1), Clock(0, 1441))

    @Ignore
    @Test
    fun `minute overflow by several days`() = assertEquals(Clock(2, 2), Clock(2, 4322))

    @Ignore
    @Test
    fun `negative minute`() = assertEquals(Clock(2, 40), Clock(3, -20))

    @Ignore
    @Test
    fun `negative minute that wraps`() = assertEquals(Clock(4, 10), Clock(5, -1490))

    @Ignore
    @Test
    fun `negative minute that wraps multiple times`() = assertEquals(Clock(6, 15), Clock(6, -4305))

    @Ignore
    @Test
    fun `negative hours and minutes`() = assertEquals(Clock(7, 32), Clock(-12, -268))

    @Ignore
    @Test
    fun `negative hours and minutes that wrap`() = assertEquals(Clock(18, 7), Clock(-54, -11513))

    @Ignore
    @Test
    fun `full clock and zeroed clock`() = assertEquals(Clock(24, 0), Clock(0, 0))

}
