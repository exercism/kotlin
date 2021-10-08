import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import YachtCategory.*

class YachtTest {

    @Test
    fun yacht() = assertEquals(50, Yacht.solve(YACHT, 5, 5, 5, 5, 5))

    @Ignore
    @Test
    fun `not yacht`() = assertEquals(0, Yacht.solve(YACHT, 1, 3, 3, 2, 5))

    @Ignore
    @Test
    fun ones() = assertEquals(3, Yacht.solve(ONES, 1, 1, 1, 3, 5))

    @Ignore
    @Test
    fun `ones out of order`() = assertEquals(3, Yacht.solve(ONES, 3, 1, 1, 5, 1))

    @Ignore
    @Test
    fun `no ones`() = assertEquals(0, Yacht.solve(ONES, 4, 3, 6, 5, 5))

    @Ignore
    @Test
    fun twos() = assertEquals(2, Yacht.solve(TWOS, 2, 3, 4, 5, 6))

    @Ignore
    @Test
    fun fours() = assertEquals(8, Yacht.solve(FOURS, 1, 4, 1, 4, 1))

    @Ignore
    @Test
    fun `yacht counted as threes`() = assertEquals(15, Yacht.solve(THREES, 3, 3, 3, 3, 3))

    @Ignore
    @Test
    fun `yacht of threes counted as fives`() = assertEquals(0, Yacht.solve(FIVES, 3, 3, 3, 3, 3))

    @Ignore
    @Test
    fun sixes() = assertEquals(6, Yacht.solve(SIXES, 2, 3, 4, 5, 6))

    @Ignore
    @Test
    fun `full house two small three big`() = assertEquals(16, Yacht.solve(FULL_HOUSE, 2, 2, 4, 4, 4))

    @Ignore
    @Test
    fun `full house three small two big`() = assertEquals(19, Yacht.solve(FULL_HOUSE, 5, 3, 3, 5, 3))

    @Ignore
    @Test
    fun `two pair is not a full house`() = assertEquals(0, Yacht.solve(FULL_HOUSE, 2, 2, 4, 4, 5))

    @Ignore
    @Test
    fun `four of a kind is not a full house`() = assertEquals(0, Yacht.solve(FULL_HOUSE, 1, 4, 4, 4, 4))

    @Ignore
    @Test
    fun `yacht is not a full house`() = assertEquals(0, Yacht.solve(FULL_HOUSE, 2, 2, 2, 2, 2))

    @Ignore
    @Test
    fun `four of a kind`() = assertEquals(24, Yacht.solve(FOUR_OF_A_KIND, 6, 6, 4, 6, 6))

    @Ignore
    @Test
    fun `yacht can be scored as four of a kind`() = assertEquals(12, Yacht.solve(FOUR_OF_A_KIND, 3, 3, 3, 3, 3))

    @Ignore
    @Test
    fun `full house is not four of a kind`() = assertEquals(0, Yacht.solve(FOUR_OF_A_KIND, 3, 3, 3, 5, 5))

    @Ignore
    @Test
    fun `little straight`() = assertEquals(30, Yacht.solve(LITTLE_STRAIGHT, 3, 5, 4, 1, 2))

    @Ignore
    @Test
    fun `little straight as big straight`() = assertEquals(0, Yacht.solve(BIG_STRAIGHT, 1, 2, 3, 4, 5))

    @Ignore
    @Test
    fun `four in order but not a little straight`() = assertEquals(0, Yacht.solve(LITTLE_STRAIGHT, 1, 1, 2, 3, 4))

    @Ignore
    @Test
    fun `no pairs but not a little straight`() = assertEquals(0, Yacht.solve(LITTLE_STRAIGHT, 1, 2, 3, 4, 6))

    @Ignore
    @Test
    fun `minimum is 1 maximum is 5 but not a little straight`() =
        assertEquals(0, Yacht.solve(LITTLE_STRAIGHT, 1, 1, 3, 4, 5))

    @Ignore
    @Test
    fun `big straight`() = assertEquals(30, Yacht.solve(BIG_STRAIGHT, 4, 6, 2, 5, 3))

    @Ignore
    @Test
    fun `big straight as little straight`() = assertEquals(0, Yacht.solve(LITTLE_STRAIGHT, 6, 5, 4, 3, 2))

    @Ignore
    @Test
    fun `no pairs but not a big straight`() = assertEquals(0, Yacht.solve(BIG_STRAIGHT, 6, 5, 4, 3, 1))

    @Ignore
    @Test
    fun choice() = assertEquals(23, Yacht.solve(CHOICE, 3, 3, 5, 6, 6))

    @Ignore
    @Test
    fun `yacht as choice`() = assertEquals(10, Yacht.solve(CHOICE, 2, 2, 2, 2, 2))
}
