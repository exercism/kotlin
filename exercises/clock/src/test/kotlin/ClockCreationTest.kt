import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ClockCreationTest {

    @Test
    fun canPrintTimeOnTheHour() {
        assertEquals("08:00", Clock(8, 0).toString())
    }

    @Ignore
    @Test
    fun canPrintTimeWithMinutes() {
        assertEquals("11:09", Clock(11, 9).toString())
    }

    @Ignore
    @Test
    fun midnightPrintsAsZero() {
        assertEquals("00:00", Clock(24, 0).toString())
    }

    @Ignore
    @Test
    fun hourRollsOver() {
        assertEquals("01:00", Clock(25, 0).toString())
    }

    @Ignore
    @Test
    fun hourRollsOverContinuously() {
        assertEquals("04:00", Clock(100, 0).toString())
    }

    @Ignore
    @Test
    fun sixtyMinutesIsNextHour() {
        assertEquals("02:00", Clock(1, 60).toString())
    }

    @Ignore
    @Test
    fun minutesRollOver() {
        assertEquals("02:40", Clock(0, 160).toString())
    }

    @Ignore
    @Test
    fun minutesRollOverContinuously() {
        assertEquals("04:43", Clock(0, 1723).toString())
    }

    @Ignore
    @Test
    fun hourAndMinutesRollOver() {
        assertEquals("03:40", Clock(25, 160).toString())
    }

    @Ignore
    @Test
    fun hourAndMinutesRollOverContinuously() {
        assertEquals("11:01", Clock(201, 3001).toString())
    }

    @Ignore
    @Test
    fun hourAndMinutesRollOverToExactlyMidnight() {
        assertEquals("00:00", Clock(72, 8640).toString())
    }

    @Ignore
    @Test
    fun negativeHour() {
        assertEquals("23:15", Clock(-1, 15).toString())
    }

    @Ignore
    @Test
    fun negativeHourRollsOver() {
        assertEquals("23:00", Clock(-25, 0).toString())
    }

    @Ignore
    @Test
    fun negativeHourRollsOverContinuously() {
        assertEquals("05:00", Clock(-91, 0).toString())
    }

    @Ignore
    @Test
    fun negativeMinutes() {
        assertEquals("00:20", Clock(1, -40).toString())
    }

    @Ignore
    @Test
    fun negativeMinutesRollOver() {
        assertEquals("22:20", Clock(1, -160).toString())
    }

    @Ignore
    @Test
    fun negativeMinutesRollOverContinuously() {
        assertEquals("16:40", Clock(1, -4820).toString())
    }

    @Ignore
    @Test
    fun negativeHourAndMinutesBothRollOver() {
        assertEquals("20:20", Clock(-25, -160).toString())
    }

    @Ignore
    @Test
    fun negativeHourAndMinutesBothRollOverContinuously() {
        assertEquals("22:10", Clock(-121, -5810).toString())
    }

    @Ignore
    @Test
    fun fullClockAndZeroedClock(){
        val first = Clock(24,0)
        val second = Clock(0,0)
        assertEquals(first, second)
    }

}
