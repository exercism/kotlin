import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class WordyTest {

    @Test
    fun `just a number`() = assertEquals(5, Wordy.answer("What is 5?"))

    @Ignore
    @Test
    fun addition() = assertEquals(2, Wordy.answer("What is 1 plus 1?"))

    @Ignore
    @Test
    fun `more addition`() = assertEquals(55, Wordy.answer("What is 53 plus 2?"))

    @Ignore
    @Test
    fun `addition with negative numbers`() = assertEquals(-11, Wordy.answer("What is -1 plus -10?"))

    @Ignore
    @Test
    fun `large addition`() = assertEquals(45801, Wordy.answer("What is 123 plus 45678?"))

    @Ignore
    @Test
    fun subtraction() = assertEquals(16, Wordy.answer("What is 4 minus -12?"))

    @Ignore
    @Test
    fun multiplication() = assertEquals(-75, Wordy.answer("What is -3 multiplied by 25?"))

    @Ignore
    @Test
    fun division() = assertEquals(-11, Wordy.answer("What is 33 divided by -3?"))

    @Ignore
    @Test
    fun `multiple additions`() = assertEquals(3, Wordy.answer("What is 1 plus 1 plus 1?"))

    @Ignore
    @Test
    fun `addition and subtraction`() = assertEquals(8, Wordy.answer("What is 1 plus 5 minus -2?"))

    @Ignore
    @Test
    fun `multiple subtraction`() = assertEquals(3, Wordy.answer("What is 20 minus 4 minus 13?"))

    @Ignore
    @Test
    fun `subtraction then addition`() = assertEquals(14, Wordy.answer("What is 17 minus 6 plus 3?"))

    @Ignore
    @Test
    fun `multiple multiplication`() = assertEquals(-12, Wordy.answer("What is 2 multiplied by -2 multiplied by 3?"))

    @Ignore
    @Test
    fun `addition and multiplication`() = assertEquals(-8, Wordy.answer("What is -3 plus 7 multiplied by -2?"))

    @Ignore
    @Test
    fun `multiple division`() = assertEquals(2, Wordy.answer("What is -12 divided by 2 divided by -3?"))

    @Ignore
    @Test(expected = Exception::class)
    fun `unknown operation`() = Wordy.answer("What is 52 cubed?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `non math question`() = Wordy.answer("Who is the President of the United States?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `reject problem missing an operand`() = Wordy.answer("What is 1 plus?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `reject problem with no operands or operators`() = Wordy.answer("What is?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `reject two operations in a row`() = Wordy.answer("What is 1 plus plus 2?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `reject two numbers in a row`() = Wordy.answer("What is 1 plus 2 1?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `reject postfix notation`() = Wordy.answer("What is 1 2 plus?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `reject prefix notation`() = Wordy.answer("What is plus 1 2?").toUnit()

    // Additional tests for this track

    @Ignore
    @Test(expected = Exception::class)
    fun `missing operation`() = Wordy.answer("What is 2 2 minus 3?").toUnit()

    @Ignore
    @Test(expected = Exception::class)
    fun `missing number`() = Wordy.answer("What is 7 plus multiplied by -2?").toUnit()

    // Bonus Question
    @Ignore
    @Test
    fun power() = assertEquals(32, Wordy.answer("What is 2 raised to the 5th power?"))

    private fun Any.toUnit() = Unit // JUnit needs functions to return Unit
}
