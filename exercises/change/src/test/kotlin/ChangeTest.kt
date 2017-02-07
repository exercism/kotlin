
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.Ignore

class ChangeTest {


    @Test
    fun singleCoinChange() {
        assertThat(Change(setOf(1, 5, 10, 25, 100)).issue(25)).containsExactly(25)
    }

    @Ignore
    @Test
    fun multipleCoinChange() {
        assertThat(Change(setOf(1, 5, 10, 25, 100)).issue(15)).containsExactly(5, 10)
    }

    @Ignore
    @Test
    fun changeWithLilliputianCoins() {
        assertThat(Change(setOf(1, 4, 15, 20, 50)).issue(23)).containsExactly(4, 4, 15)
    }

    @Ignore
    @Test
    fun changeWithLowerElboniaCoins() {
        assertThat(Change(setOf(1, 5, 10, 21, 25)).issue(63)).containsExactly(21,21,21)
    }

    @Ignore
    @Test
    fun largeTargetValues() {
        assertThat(Change(setOf(1, 2, 5, 10, 20, 50, 100)).issue(999)).containsExactly(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100)
    }

    @Ignore
    @Test
    fun noCoinsMake0Change() {
        assertThat(Change(setOf(1, 5, 10, 21, 25)).issue(0)).isEmpty()
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun errorTestingForChangeSmallerThanTheSmallestCoin() {
        Change(setOf(5, 10)).issue(3)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun cannotFindNegativeChangeValues() {
        Change(setOf(1, 2, 5)).issue(-5)
    }
}
