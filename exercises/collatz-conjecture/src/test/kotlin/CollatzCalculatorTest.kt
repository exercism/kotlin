import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class CollatzCalculatorTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun testZeroStepsRequiredWhenStartingFrom1() {
        assertEquals(0, CollatzCalculator.computeStepCount(1))
    }

    @Ignore
    @Test
    fun testCorrectNumberOfStepsWhenAllStepsAreDivisions() {
        assertEquals(4, CollatzCalculator.computeStepCount(16))
    }

    @Ignore
    @Test
    fun testCorrectNumberOfStepsWhenBothStepTypesAreNeeded() {
        assertEquals(9, CollatzCalculator.computeStepCount(12))
    }

    @Ignore
    @Test
    fun testAVeryLargeInput() {
        assertEquals(152, CollatzCalculator.computeStepCount(1000000))
    }

    @Ignore
    @Test
    fun testZeroIsConsideredInvalidInput() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only natural numbers are allowed")

        CollatzCalculator.computeStepCount(0)
    }

    @Ignore
    @Test
    fun testNegativeIntegerIsConsideredInvalidInput() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only natural numbers are allowed")

        CollatzCalculator.computeStepCount(-15)
    }

}
