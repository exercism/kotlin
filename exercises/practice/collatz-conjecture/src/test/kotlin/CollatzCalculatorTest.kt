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
    fun `zero steps for 1`() = assertStepsEqual(1, 0)

    @Ignore
    @Test
    fun `divide if even`() = assertStepsEqual(16, 4)

    @Ignore
    @Test
    fun `even and odd steps`() = assertStepsEqual(12, 9)

    @Ignore
    @Test
    fun `large number of even and odd steps`() = assertStepsEqual(1000000, 152)

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid input - zero`() {
        steps(0)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `invalid input - negative`() {
        steps(-15)
    }

}

private fun assertStepsEqual(input: Int, steps: Int) = assertEquals(steps, steps(input))

private fun steps(input: Int) = CollatzCalculator.computeStepCount(input)
