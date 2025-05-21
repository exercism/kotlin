import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.Ignore

class ArmstrongNumberTest {

    @Test
    fun `zero is an armstrong number`() = assertTrue(ArmstrongNumber.check(0))

    @Ignore
    @Test
    fun `single digit numbers are armstrong numbers`() = assertTrue(ArmstrongNumber.check(5))

    @Ignore
    @Test
    fun `there are no 2 digit armstrong numbers`() = assertFalse(ArmstrongNumber.check(10))

    @Ignore
    @Test
    fun `three digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(153))

    @Ignore
    @Test
    fun `three digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(100))

    @Ignore
    @Test
    fun `four digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(9474))

    @Ignore
    @Test
    fun `four digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(9475))

    @Ignore
    @Test
    fun `seven digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(9926315))

    @Ignore
    @Test
    fun `seven digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(9926314))
}
