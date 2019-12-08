import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ClockCreationTest {

    @Test
    fun `on the hour`() = assertEquals("08:00", Clock(8, 0).toString())

    @Ignore
    @Test
    fun `past the hour`() = assertEquals("11:09", Clock(11, 9).toString())

    @Ignore
    @Test
    fun `midnight is zero hours`() = assertEquals("00:00", Clock(24, 0).toString())

    @Ignore
    @Test
    fun `hour rolls over`() = assertEquals("01:00", Clock(25, 0).toString())

    @Ignore
    @Test
    fun `hour rolls over continuously`() = assertEquals("04:00", Clock(100, 0).toString())

    @Ignore
    @Test
    fun `sixty minutes is next hour`() = assertEquals("02:00", Clock(1, 60).toString())

    @Ignore
    @Test
    fun `minutes roll over`() = assertEquals("02:40", Clock(0, 160).toString())

    @Ignore
    @Test
    fun `minutes roll over continuously`() = assertEquals("04:43", Clock(0, 1723).toString())

    @Ignore
    @Test
    fun `hour and minutes roll over`() = assertEquals("03:40", Clock(25, 160).toString())

    @Ignore
    @Test
    fun `hour and minutes roll over continuously`() = assertEquals("11:01", Clock(201, 3001).toString())

    @Ignore
    @Test
    fun `hour and minutes roll over to exactly midnight`() = assertEquals("00:00", Clock(72, 8640).toString())

    @Ignore
    @Test
    fun `negative hour`() = assertEquals("23:15", Clock(-1, 15).toString())

    @Ignore
    @Test
    fun `negative hour rolls over`() = assertEquals("23:00", Clock(-25, 0).toString())

    @Ignore
    @Test
    fun `negative hour rolls over continuously`() = assertEquals("05:00", Clock(-91, 0).toString())

    @Ignore
    @Test
    fun `negative minutes`() = assertEquals("00:20", Clock(1, -40).toString())

    @Ignore
    @Test
    fun `negative minutes roll over`() = assertEquals("22:20", Clock(1, -160).toString())

    @Ignore
    @Test
    fun `negative minutes roll over continuously`() = assertEquals("16:40", Clock(1, -4820).toString())

    @Ignore
    @Test
    fun `negative sixty minutes is previous hour`() = assertEquals("01:00", Clock(2, -60).toString())

    @Ignore
    @Test
    fun `negative hour and minutes both roll over`() = assertEquals("20:20", Clock(-25, -160).toString())

    @Ignore
    @Test
    fun `negative hour and minutes both roll over continuously`() =
        assertEquals("22:10", Clock(-121, -5810).toString())

}
