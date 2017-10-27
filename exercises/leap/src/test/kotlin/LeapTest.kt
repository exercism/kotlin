import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeapTest {

    @Test
    fun yearNotDivisibleBy4() {
        assertFalse(Year(2015).isLeap)
    }

    @Ignore
    @Test
    fun yearDivisibleBy4NotDivisibleBy100() {
        assertTrue(Year(1996).isLeap)
    }

    @Ignore
    @Test
    fun yearDivisibleBy100NotDivisibleBy400() {
        assertFalse(Year(2100).isLeap)
    }

    @Ignore
    @Test
    fun yearDivisibleBy400() {
        assertTrue(Year(2000).isLeap)
    }

}
