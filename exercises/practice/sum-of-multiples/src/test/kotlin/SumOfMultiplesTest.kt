import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class SumOfMultiplesTest {
    @Test
    fun `no multiples within limit`() =
            assertEquals(0, SumOfMultiples.sum(setOf(3, 5), 1))

    @Test
    @Ignore
    fun `one factor has multiples within limit`() =
            assertEquals(3, SumOfMultiples.sum(setOf(3, 5), 4))

    @Test
    @Ignore
    fun `more than one multiple within limit`() =
            assertEquals(9, SumOfMultiples.sum(setOf(3), 7))

    @Test
    @Ignore
    fun `more than one factor with multiples within limit`() =
            assertEquals(23, SumOfMultiples.sum(setOf(3, 5), 10))

    @Test
    @Ignore
    fun `each multiple is only counted once`() =
            assertEquals(2318, SumOfMultiples.sum(setOf(3, 5), 100))

    @Test
    @Ignore
    fun `much larger limit`() =
            assertEquals(233168, SumOfMultiples.sum(setOf(3, 5), 1000))

    @Test
    @Ignore
    fun `three factors`() =
            assertEquals(51, SumOfMultiples.sum(setOf(7, 13, 17), 20))

    @Test
    @Ignore
    fun `factors not relatively prime`() =
            assertEquals(30, SumOfMultiples.sum(setOf(4, 6), 15))

    @Test
    @Ignore
    fun `some pairs of factors relatively prime and some not`() =
            assertEquals(4419, SumOfMultiples.sum(setOf(5, 6, 8), 150))

    @Test
    @Ignore
    fun `one factor is a multiple of another`() =
            assertEquals(275, SumOfMultiples.sum(setOf(5, 25), 51))

    @Test
    @Ignore
    fun `much larger factors`() =
            assertEquals(2203160, SumOfMultiples.sum(setOf(43, 47), 10000))

    @Test
    @Ignore
    fun `all numbers are multiples of 1`() =
            assertEquals(4950, SumOfMultiples.sum(setOf(1), 100))

    @Test
    @Ignore
    fun `no factors means an empty sum`() =
            assertEquals(0, SumOfMultiples.sum(emptySet(), 10000))

    @Test
    @Ignore
    fun `the only multiple of 0 is 0`() =
            assertEquals(0, SumOfMultiples.sum(setOf(1), 1))

    @Test
    @Ignore
    fun `the factor 0 does not affect the sum of multiples of other factors`() =
            assertEquals(3, SumOfMultiples.sum(setOf(3, 0), 4))

    @Test
    @Ignore
    fun `include-exclude-based solutions must extend to cardinality greater than 3`() =
            assertEquals(39614537, SumOfMultiples.sum(setOf(2, 3, 5, 7, 11), 10000))
}
