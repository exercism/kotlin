import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class PrimeTest {

    @Test
    fun firstPrime() {
        assertEquals(2, Prime.nth(1))
    }

    @Test
    fun secondPrime() {
        assertEquals(3, Prime.nth(2))
    }

    @Test
    fun sixthPrime() {
        assertEquals(13, Prime.nth(6))
    }

    @Test
    fun bigPrime() {
        assertEquals(104743, Prime.nth(10001))
    }

    @Test(expected = IllegalArgumentException::class)
    fun undefinedPrime() {
        Prime.nth(0)
    }

}
