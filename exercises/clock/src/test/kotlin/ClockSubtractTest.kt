import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ClockSubtractTest{

    @Ignore
    @Test
    fun subtractMinutes() {
        val clock = Clock(10, 3)
        clock.substract(3)
        assertEquals("10:00", clock.toString())
    }

    @Ignore
    @Test
    fun subtractToPreviousHour() {
        val clock = Clock(10, 3)
        clock.substract(30)
        assertEquals("09:33", clock.toString())
    }

    @Ignore
    @Test
    fun subtractAcrossMidnight() {
        val clock = Clock(0, 3)
        clock.substract(4)
        assertEquals("23:59", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanTwoHours() {
        val clock = Clock(0, 0)
        clock.substract(160)
        assertEquals("21:20", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanTwoHoursWithBorrow() {
        val clock = Clock(6, 15)
        clock.substract(160)
        assertEquals("03:35", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanOneDay() {
        val clock = Clock(5, 32)
        clock.substract(1500)
        assertEquals("04:32", clock.toString())
    }

    @Ignore
    @Test
    fun subtractMoreThanTwoDays() {
        val clock = Clock(2, 20)
        clock.substract(3000)
        assertEquals("00:20", clock.toString())
    }
}