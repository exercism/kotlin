import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ClockAddTest {

    @Ignore
    @Test
    fun addMinutes() {
        val clock = Clock(10, 0)
        clock.add(3)
        assertEquals("10:03", clock.toString())
    }

    @Ignore
    @Test
    fun addNoMinutes() {
        val clock = Clock(6, 41)
        clock.add(0)
        assertEquals("06:41", clock.toString())
    }

    @Ignore
    @Test
    fun addToNextHour() {
        val clock = Clock(0, 45)
        clock.add(40)
        assertEquals("01:25", clock.toString())
    }

    @Ignore
    @Test
    fun addMoreThanOneHour() {
        val clock = Clock(10, 0)
        clock.add(61)
        assertEquals("11:01", clock.toString())
    }

    @Ignore
    @Test
    fun addMoreThanTwoHoursWithCarry() {
        val clock = Clock(0, 45)
        clock.add(160)
        assertEquals("03:25", clock.toString())
    }

    @Ignore
    @Test
    fun addAcrossMidnight() {
        val clock = Clock(23, 59)
        clock.add(2)
        assertEquals("00:01", clock.toString())
    }

    @Ignore
    @Test
    fun addMoreThanOneDay() {
        val clock = Clock(5, 32)
        clock.add(1500)
        assertEquals("06:32", clock.toString())
    }

    @Ignore
    @Test
    fun addMoreThanTwoDays() {
        val clock = Clock(1, 1)
        clock.add(3500)
        assertEquals("11:21", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMinutes() {
        val clock = Clock(10, 3)
        clock.add(-3)
        assertEquals("10:00", clock.toString())
    }

    @Ignore
    @Test
    fun subtractToPreviousHour() {
        val clock = Clock(10, 3)
        clock.add(-30)
        assertEquals("09:33", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanAnHour() {
        val clock = Clock(10, 3)
        clock.add(-70)
        assertEquals("08:53", clock.toString())
    }

    @Ignore
    @Test
    fun subtractAcrossMidnight() {
        val clock = Clock(0, 3)
        clock.add(-4)
        assertEquals("23:59", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanTwoHours() {
        val clock = Clock(0, 0)
        clock.add(-160)
        assertEquals("21:20", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanTwoHoursWithBorrow() {
        val clock = Clock(6, 15)
        clock.add(-160)
        assertEquals("03:35", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanOneDay() {
        val clock = Clock(5, 32)
        clock.add(-1500)
        assertEquals("04:32", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanTwoDays() {
        val clock = Clock(2, 20)
        clock.add(-3000)
        assertEquals("00:20", clock.toString())
    }

}
