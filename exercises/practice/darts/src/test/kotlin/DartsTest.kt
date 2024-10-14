import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class DartsTest {

    @Test
    fun `missed target`() = assertEquals(0, Darts.score(-9, 9))

    @Ignore
    @Test
    fun `on the outer circle`() = assertEquals(1, Darts.score(0, 10))

    @Ignore
    @Test
    fun `on the middle circle`() = assertEquals(5, Darts.score(-5, 0))

    @Ignore
    @Test
    fun `on the inner circle`() = assertEquals(10, Darts.score(0, -1))

    @Ignore
    @Test
    fun `exactly on centre`() = assertEquals(10, Darts.score(0, 0))

    @Ignore
    @Test
    fun `near the centre`() = assertEquals(10, Darts.score(-0.1, -0.1))

    @Ignore
    @Test
    fun `just within the inner circle`() = assertEquals(10, Darts.score(0.7, 0.7))

    @Ignore
    @Test
    fun `just outside the inner circle`() = assertEquals(5, Darts.score(0.8, -0.8))

    @Ignore
    @Test
    fun `just within the middle circle`() = assertEquals(5, Darts.score(-3.5, 3.5))

    @Ignore
    @Test
    fun `just outside the middle circle`() = assertEquals(1, Darts.score(-3.6, -3.6))

    @Ignore
    @Test
    fun `just within the outer circle`() = assertEquals(1, Darts.score(-7.0, 7.0))

    @Ignore
    @Test
    fun `just outside the outer circle`() = assertEquals(0, Darts.score(7.1, -7.1))

    @Ignore
    @Test
    fun `asymmetric position between the inner and middle circles`() = assertEquals(5, Darts.score(0.5, -4))
}
