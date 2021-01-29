import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ArmstrongNumberTest {

    @Test
    fun `zero is an armstrong number`() = assertTrue(ArmstrongNumber.check(0))

    @Test
    fun `single digit numbers are armstrong numbers`() = assertTrue(ArmstrongNumber.check(5))

    @Test
    fun `there are no 2 digit armstrong numbers`() = assertFalse(ArmstrongNumber.check(10))

    @Test
    fun `three digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(153))

    @Test
    fun `three digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(100))

    @Test
    fun `four digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(9474))

    @Test
    fun `four digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(9475))

    @Test
    fun `seven digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(9926315))

    @Test
    fun `seven digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(9926314))
}
