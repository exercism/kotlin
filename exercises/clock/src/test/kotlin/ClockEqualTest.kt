import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/*
 * version: 1.0.1
 */
class ClockEqualTest {

    @Ignore
    @Test
    fun clocksWithSameTimeAreEqual() {
        assertTrue(Clock(15, 37) == Clock(15, 37))
    }

    @Ignore
    @Test
    fun clocksAMinuteApartAreNotEqual() {
        assertFalse(Clock(15, 36) == Clock(15, 37))
    }

    @Ignore
    @Test
    fun clocksAnHourApartAreNotEqual() {
        assertFalse(Clock(14, 37) == Clock(15, 37))
    }

    @Ignore
    @Test
    fun clocksWithHourOverflow() {
        assertTrue(Clock(10, 37) == Clock(34, 37))
    }

    @Ignore
    @Test
    fun clocksWithHourOverflowBySeveralDays() {
        assertTrue(Clock(3, 11) == Clock(99, 11))
    }

    @Ignore
    @Test
    fun clocksWithNegateHour() {
        assertTrue(Clock(22, 40) == Clock(-2, 40))
    }

    @Ignore
    @Test
    fun clocksWithNegativeHourThatWraps() {
        assertTrue(Clock(17, 3) == Clock(-31, 3))
    }

    @Ignore
    @Test
    fun clocksWithNegativeHourThatWrapsMultipleTimes() {
        assertTrue(Clock(13, 49) == Clock(-83, 49))
    }

    @Ignore
    @Test
    fun clocksWithMinuteOverflow() {
        assertTrue(Clock(0, 1) == Clock(0, 1441))
    }

    @Ignore
    @Test
    fun clocksWithMinuteOverflowBySeveralDays() {
        assertTrue(Clock(2, 2) == Clock(2, 4322))
    }

    @Ignore
    @Test
    fun clocksWithNegativeMinutes() {
        assertTrue(Clock(2, 40) == Clock(3, -20))
    }

    @Ignore
    @Test
    fun clocksWithNegativeMinutesThatWraps() {
        assertTrue(Clock(4, 10) == Clock(5, -1490))
    }

    @Ignore
    @Test
    fun clocksWithNegativeMinutesThatWrapsMultipleTimes() {
        assertTrue(Clock(6, 15) == Clock(6, -4305))
    }

    @Ignore
    @Test
    fun clocksWithNegativeHoursAndMinutes() {
        assertTrue(Clock(7, 32) == Clock(-12, -268))
    }

    @Ignore
    @Test
    fun clocksWithNegativeHoursAndMinutesThatWrap() {
        assertTrue(Clock(18, 7) == Clock(-54, -11513))
    }

}