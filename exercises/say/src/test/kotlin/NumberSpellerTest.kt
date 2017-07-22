import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.math.BigInteger
import kotlin.test.assertEquals

/*
 * version: 1.0.0
 */
class NumberSpellerTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun test0IsSpelledCorrectly() {
        assertEquals(
                "zero",
                NumberSpeller().say(0))
    }

    @Ignore
    @Test
    fun test1IsSpelledCorrectly() {
        assertEquals(
                "one",
                NumberSpeller().say(1))
    }

    @Ignore
    @Test
    fun test14IsSpelledCorrectly() {
        assertEquals(
                "fourteen",
                NumberSpeller().say(14))
    }

    @Ignore
    @Test
    fun test20IsSpelledCorrectly() {
        assertEquals(
                "twenty",
                NumberSpeller().say(20))
    }

    @Ignore
    @Test
    fun test22IsSpelledCorrectly() {
        assertEquals(
                "twenty-two",
                NumberSpeller().say(22))
    }

    @Ignore
    @Test
    fun test100IsSpelledCorrectly() {
        assertEquals(
                "one hundred",
                NumberSpeller().say(100))
    }

    @Ignore
    @Test
    fun test123IsSpelledCorrectly() {
        assertEquals(
                "one hundred twenty-three",
                NumberSpeller().say(123))
    }

    @Ignore
    @Test
    fun test1000IsSpelledCorrectly() {
        assertEquals(
                "one thousand",
                NumberSpeller().say(1000))
    }

    @Ignore
    @Test
    fun test1234IsSpelledCorrectly() {
        assertEquals(
                "one thousand two hundred thirty-four",
                NumberSpeller().say(1234))
    }

    @Ignore
    @Test
    fun test1000000IsSpelledCorrectly() {
        assertEquals(
                "one million",
                NumberSpeller().say(1000000))
    }

    @Ignore
    @Test
    fun test1002345IsSpelledCorrectly() {
        assertEquals(
                "one million two thousand three hundred forty-five",
                NumberSpeller().say(1002345))
    }

    @Ignore
    @Test
    fun test1000000000IsSpelledCorrectly() {
        assertEquals(
                "one billion",
                NumberSpeller().say(1000000000))
    }

    @Ignore
    @Test
    fun test987654321123IsSpelledCorrectly() {
        assertEquals(
                "nine hundred eighty-seven billion six hundred fifty-four million three hundred twenty-one thousand one hundred twenty-three",
                NumberSpeller().say(987654321123))
    }

    @Ignore
    @Test
    fun testNegativeNumbersAreOutOfRange() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Input must be non-negative")

        NumberSpeller().say(-1)
    }

    @Ignore
    @Test
    fun testNumbersAbove1000000000000AreOutOfRange() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Input must be less than 1000000000000")

        NumberSpeller().say(1000000000000)
    }

}
