import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class ChangeCalculatorTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun `change for 1 cent`() {
        var computedChange = ChangeCalculator(listOf(1, 5, 10, 25)).computeMostEfficientChange(1)
        assertContainsExactly(computedChange, listOf(1))
    }

    @Ignore
    @Test
    fun `single coin change`() {
        val computedChange = ChangeCalculator(listOf(1, 5, 10, 25, 100)).computeMostEfficientChange(25)
        assertContainsExactly(computedChange, listOf(25))
    }

    @Ignore
    @Test
    fun `multiple coin change`() {
        val computedChange = ChangeCalculator(listOf(1, 5, 10, 25, 100)).computeMostEfficientChange(15)
        assertContainsExactly(computedChange, listOf(5, 10))
    }

    @Ignore
    @Test
    fun `change with Lilliputian Coins`() {
        val computedChange = ChangeCalculator(listOf(1, 4, 15, 20, 50)).computeMostEfficientChange(23)
        assertContainsExactly(computedChange, listOf(4, 4, 15))
    }

    @Ignore
    @Test
    fun `change with Lower Elbonia Coins`() {
        val computedChange = ChangeCalculator(listOf(1, 5, 10, 21, 25)).computeMostEfficientChange(63)
        assertContainsExactly(computedChange, listOf(21, 21, 21))
    }

    @Ignore
    @Test
    fun `large target values`() {
        val computedChange = ChangeCalculator(listOf(1, 2, 5, 10, 20, 50, 100)).computeMostEfficientChange(999)
        assertContainsExactly(
            computedChange,
            listOf(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100)
        )
    }

    @Ignore
    @Test
    fun `possible change without unit coins available`() {
        val computedChange = ChangeCalculator(listOf(2, 5, 10, 20, 50)).computeMostEfficientChange(21)
        assertContainsExactly(computedChange, listOf(2, 2, 2, 5, 10))
    }

    @Ignore
    @Test
    fun `another possible change without unit coins available`() {
        val computedChange = ChangeCalculator(listOf(4, 5)).computeMostEfficientChange(27)
        assertContainsExactly(computedChange, listOf(4, 4, 4, 5, 5, 5))
    }

    @Ignore
    @Test
    fun `a greedy approach is not optimal`() {
        val computedChange = ChangeCalculator(listOf(1, 10, 11)).computeMostEfficientChange(20)
        assertContainsExactly(computedChange, listOf(10, 10))
    }

    @Ignore
    @Test
    fun `no coins make 0 change`() {
        val computedChange = ChangeCalculator(listOf(1, 5, 10, 21, 25)).computeMostEfficientChange(0)
        assertEquals(0, computedChange.size)
    }

    @Ignore
    @Test
    fun `error testing for change smaller than the smallest of coins`() {
        val changeCalculator = ChangeCalculator(listOf(5, 10))

        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("The total 3 cannot be represented in the given currency.")

        changeCalculator.computeMostEfficientChange(3)
    }

    @Ignore
    @Test
    fun `error if no combination can add up to target`() {
        val changeCalculator = ChangeCalculator(listOf(5, 10))

        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("The total 94 cannot be represented in the given currency.")

        changeCalculator.computeMostEfficientChange(94)
    }

    @Ignore
    @Test
    fun `cannot find negative change values`() {
        val changeCalculator = ChangeCalculator(listOf(1, 2, 5))

        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Negative totals are not allowed.")

        changeCalculator.computeMostEfficientChange(-5)
    }

}

private inline fun <reified T> assertContainsExactly(actualList: List<T>, expectedValues: List<T>) {
    assertEquals(expectedValues.size, actualList.size)
    expectedValues.forEach { actualList.contains(it) }
}
