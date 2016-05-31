import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeapTest {

    @Test
    fun leapYear() {
        assertTrue(Year(1996).isLeap)
    }

    @Test
    fun standardOddYear() {
        assertFalse(Year(1997).isLeap)
    }

    @Test
    fun standardEvenYear() {
        assertFalse(Year(1998).isLeap)
    }

    @Test
    fun standardNineteenthCentury() {
        assertFalse(Year(1900).isLeap)
    }

    @Test
    fun standardEighteenthCentury() {
        assertFalse(Year(1800).isLeap)
    }

    @Test
    fun leapTwentyFourthCentury() {
        assertTrue(Year(2400).isLeap)
    }

    @Test
    fun leapY2K() {
        assertTrue(Year(2000).isLeap)
    }
}
