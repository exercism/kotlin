import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeapTest {


    @Test
    fun leapYear() {
        assertTrue(Year(1996).isLeap)
    }

    @Ignore
    @Test
    fun standardOddYear() {
        assertFalse(Year(1997).isLeap)
    }

    @Ignore
    @Test
    fun standardEvenYear() {
        assertFalse(Year(1998).isLeap)
    }

    @Ignore
    @Test
    fun standardNineteenthCentury() {
        assertFalse(Year(1900).isLeap)
    }

    @Ignore
    @Test
    fun standardEighteenthCentury() {
        assertFalse(Year(1800).isLeap)
    }

    @Ignore
    @Test
    fun leapTwentyFourthCentury() {
        assertTrue(Year(2400).isLeap)
    }

    @Ignore
    @Test
    fun leapY2K() {
        assertTrue(Year(2000).isLeap)
    }
}
