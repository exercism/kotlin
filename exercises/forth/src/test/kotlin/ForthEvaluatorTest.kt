import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

/*
 * version: 1.2.0
 */
class ForthEvaluatorTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    private lateinit var forthEvaluator: ForthEvaluator

    @Before
    fun setUp() {
        forthEvaluator = ForthEvaluator()
    }

    @Test
    fun testEmptyProgramResultsInEmptyStack() {
        assertEquals(
                emptyList(),
                forthEvaluator.evaluateProgram(emptyList()))
    }

    @Ignore
    @Test
    fun testNumbersAreJustPushedOntoTheStack() {
        assertEquals(
                listOf(1, 2, 3, 4, 5),
                forthEvaluator.evaluateProgram(listOf("1 2 3 4 5")))
    }

    @Ignore
    @Test
    fun testTwoNumbersCanBeAdded() {
        assertEquals(
                listOf(3),
                forthEvaluator.evaluateProgram(listOf("1 2 +")))
    }

    @Ignore
    @Test
    fun testErrorIfAdditionAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Addition requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("+"))
    }

    @Ignore
    @Test
    fun testErrorIfAdditionAttemptedWithOneNumberOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Addition requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("1 +"))
    }

    @Ignore
    @Test
    fun testTwoNumbersCanBeSubtracted() {
        assertEquals(
                listOf(-1),
                forthEvaluator.evaluateProgram(listOf("3 4 -")))
    }

    @Ignore
    @Test
    fun testErrorIfSubtractionAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Subtraction requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("-"))
    }

    @Ignore
    @Test
    fun testErrorIfSubtractionAttemptedWithOneNumberOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Subtraction requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("1 -"))
    }

    @Ignore
    @Test
    fun testTwoNumbersCanBeMultiplied() {
        assertEquals(
                listOf(8),
                forthEvaluator.evaluateProgram(listOf("2 4 *")))
    }

    @Ignore
    @Test
    fun testErrorIfMultiplicationAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Multiplication requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("*"))
    }

    @Ignore
    @Test
    fun testErrorIfMultiplicationAttemptedWithOneNumberOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Multiplication requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("1 *"))
    }

    @Ignore
    @Test
    fun testTwoNumbersCanBeDivided() {
        assertEquals(
                listOf(4),
                forthEvaluator.evaluateProgram(listOf("12 3 /")))
    }

    @Ignore
    @Test
    fun testThatIntegerDivisionIsUsed() {
        assertEquals(
                listOf(2),
                forthEvaluator.evaluateProgram(listOf("8 3 /")))
    }

    @Ignore
    @Test
    fun testErrorIfDividingByZero() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Division by 0 is not allowed")

        forthEvaluator.evaluateProgram(listOf("4 0 /"))
    }

    @Ignore
    @Test
    fun testErrorIfDivisionAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Division requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("/"))
    }

    @Ignore
    @Test
    fun testErrorIfDivisionAttemptedWithOneNumberOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Division requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("1 /"))
    }

    @Ignore
    @Test
    fun testCombinedAdditionAndSubtraction() {
        assertEquals(
                listOf(-1),
                forthEvaluator.evaluateProgram(listOf("1 2 + 4 -")))
    }

    @Ignore
    @Test
    fun testCombinedMultiplicationAndDivision() {
        assertEquals(
                listOf(2),
                forthEvaluator.evaluateProgram(listOf("2 4 * 3 /")))
    }

    @Ignore
    @Test
    fun testDupCopiesTheTopValueOnTheStack() {
        assertEquals(
                listOf(1, 1),
                forthEvaluator.evaluateProgram(listOf("1 DUP")))
    }

    @Ignore
    @Test
    fun testDupParsingIsCaseInsensitive() {
        assertEquals(
                listOf(1, 2, 2),
                forthEvaluator.evaluateProgram(listOf("1 2 Dup")))
    }

    @Ignore
    @Test
    fun testErrorIfDuplicatingAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Duplicating requires that the stack contain at least 1 value")

        forthEvaluator.evaluateProgram(listOf("dup"))
    }

    @Ignore
    @Test
    fun testDropRemovesTheTopValueOnTheStackIfItIsTheOnlyOne() {
        assertEquals(
                emptyList(),
                forthEvaluator.evaluateProgram(listOf("1 drop")))
    }

    @Ignore
    @Test
    fun testDropRemovesTheTopValueOnTheStackIfItIsNotTheOnlyOne() {
        assertEquals(
                listOf(1),
                forthEvaluator.evaluateProgram(listOf("1 2 drop")))
    }

    @Ignore
    @Test
    fun testErrorIfDroppingAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Dropping requires that the stack contain at least 1 value")

        forthEvaluator.evaluateProgram(listOf("drop"))
    }

    @Ignore
    @Test
    fun testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreTheOnlyOnes() {
        assertEquals(
                listOf(2, 1),
                forthEvaluator.evaluateProgram(listOf("1 2 swap")))
    }

    @Ignore
    @Test
    fun testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreNotTheOnlyOnes() {
        assertEquals(
                listOf(1, 3, 2),
                forthEvaluator.evaluateProgram(listOf("1 2 3 swap")))
    }

    @Ignore
    @Test
    fun testErrorIfSwappingAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Swapping requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("swap"))
    }

    @Ignore
    @Test
    fun testErrorIfSwappingAttemptedWithOneNumberOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Swapping requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("1 swap"))
    }

    @Ignore
    @Test
    fun testOverCopiesTheSecondElementIfThereAreOnlyTwo() {
        assertEquals(
                listOf(1, 2, 1),
                forthEvaluator.evaluateProgram(listOf("1 2 over")))
    }

    @Ignore
    @Test
    fun testOverCopiesTheSecondElementIfThereAreMoreThanTwo() {
        assertEquals(
                listOf(1, 2, 3, 2),
                forthEvaluator.evaluateProgram(listOf("1 2 3 over")))
    }

    @Ignore
    @Test
    fun testErrorIfOveringAttemptedWithNothingOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Overing requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("over"))
    }

    @Ignore
    @Test
    fun testErrorIfOveringAttemptedWithOneNumberOnTheStack() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Overing requires that the stack contain at least 2 values")

        forthEvaluator.evaluateProgram(listOf("1 over"))
    }

    @Ignore
    @Test
    fun testUserDefinedOperatorsCanConsistOfBuiltInOperators() {
        assertEquals(
                listOf(1, 1, 1),
                forthEvaluator.evaluateProgram(listOf(": dup-twice dup dup ;", "1 dup-twice")))
    }

    @Ignore
    @Test
    fun testUserDefinedOperatorsAreEvaluatedInTheCorrectOrder() {
        assertEquals(
                listOf(1, 2, 3),
                forthEvaluator.evaluateProgram(listOf(": countup 1 2 3 ;", "countup")))
    }

    @Ignore
    @Test
    fun testCanRedefineAUserDefinedOperator() {
        assertEquals(
                listOf(1, 1, 1),
                forthEvaluator.evaluateProgram(listOf(": foo dup ;", ": foo dup dup ;", "1 foo")))
    }

    @Ignore
    @Test
    fun testCanOverrideBuiltInWordOperators() {
        assertEquals(
                listOf(1, 1),
                forthEvaluator.evaluateProgram(listOf(": swap dup ;", "1 swap")))
    }

    @Ignore
    @Test
    fun testCanOverrideBuiltInArithmeticOperators() {
        assertEquals(
                listOf(12),
                forthEvaluator.evaluateProgram(listOf(": + * ;", "3 4 +")))
    }

    @Ignore
    @Test
    fun testCannotRedefineNumbers() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Cannot redefine numbers")

        forthEvaluator.evaluateProgram(listOf(": 1 2 ;"))
    }

    @Ignore
    @Test
    fun testErrorIfEvaluatingAnUndefinedOperator() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("No definition available for operator \"foo\"")

        forthEvaluator.evaluateProgram(listOf("foo"))
    }

}
