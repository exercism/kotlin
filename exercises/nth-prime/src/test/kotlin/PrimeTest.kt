import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class PrimeTest {

    @Test
    fun firstPrime() {
        assertEquals(2, Prime.nth(1))
    }

    @Ignore
    @Test
    fun secondPrime() {
        assertEquals(3, Prime.nth(2))
    }

    @Ignore
    @Test
    fun sixthPrime() {
        assertEquals(13, Prime.nth(6))
    }

    @Ignore
    @Test
    fun bigPrime() {
        assertEquals(104743, Prime.nth(10001))
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun undefinedPrime() {
        Prime.nth(0)
    }

}
