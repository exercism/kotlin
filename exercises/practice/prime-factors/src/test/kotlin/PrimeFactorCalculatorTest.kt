import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class PrimeFactorCalculatorTest {

    @Test
    fun `no factors`() {
        assertEquals(emptyList(), PrimeFactorCalculator.primeFactors(1))
    }

    @Ignore
    @Test
    fun `prime number`() {
        assertEquals(listOf(2), PrimeFactorCalculator.primeFactors(2))
    }

    @Ignore
    @Test
    fun `another prime number`() {
        assertEquals(listOf(3), PrimeFactorCalculator.primeFactors(3))
    }

    @Ignore
    @Test
    fun `square of a prime`() {
        assertEquals(listOf(3, 3), PrimeFactorCalculator.primeFactors(9))
    }

    @Ignore
    @Test
    fun `product of first prime`() {
        assertEquals(listOf(2, 2), PrimeFactorCalculator.primeFactors(4))
    }

    @Ignore
    @Test
    fun `cube of a prime`() {
        assertEquals(listOf(2, 2, 2), PrimeFactorCalculator.primeFactors(8))
    }

    @Ignore
    @Test
    fun `product of second prime`() {
        assertEquals(listOf(3, 3, 3), PrimeFactorCalculator.primeFactors(27))
    }

    @Ignore
    @Test
    fun `product of third prime`() {
        assertEquals(listOf(5, 5, 5, 5), PrimeFactorCalculator.primeFactors(625))
    }

    @Ignore
    @Test
    fun `product of first and second prime`() {
        assertEquals(listOf(2, 3), PrimeFactorCalculator.primeFactors(6))
    }

    @Ignore
    @Test
    fun `product of primes and non-primes`() {
        assertEquals(listOf(2, 2, 3), PrimeFactorCalculator.primeFactors(12))
    }

    @Ignore
    @Test
    fun `product of primes`() {
        assertEquals(listOf(5, 17, 23, 461), PrimeFactorCalculator.primeFactors(901255))
    }

    @Ignore
    @Test
    fun `factors include a large prime`() {
        assertEquals(listOf<Long>(11, 9539, 894119), PrimeFactorCalculator.primeFactors(93819012551L))
    }

}
