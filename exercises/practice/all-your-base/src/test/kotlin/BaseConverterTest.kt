import org.junit.Assert.assertArrayEquals
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.util.*

class BaseConverterTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun testSingleBitOneToDecimal() {
        val baseConverter = BaseConverter(2, intArrayOf(1))

        val expectedDigits = intArrayOf(1)
        val actualDigits = baseConverter.convertToBase(10)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testBinaryToSingleDecimal() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1))

        val expectedDigits = intArrayOf(5)
        val actualDigits = baseConverter.convertToBase(10)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testSingleDecimalToBinary() {
        val baseConverter = BaseConverter(10, intArrayOf(5))

        val expectedDigits = intArrayOf(1, 0, 1)
        val actualDigits = baseConverter.convertToBase(2)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testBinaryToMultipleDecimal() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1, 0, 1, 0))

        val expectedDigits = intArrayOf(4, 2)
        val actualDigits = baseConverter.convertToBase(10)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testDecimalToBinary() {
        val baseConverter = BaseConverter(10, intArrayOf(4, 2))

        val expectedDigits = intArrayOf(1, 0, 1, 0, 1, 0)
        val actualDigits = baseConverter.convertToBase(2)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testTrinaryToHexadecimal() {
        val baseConverter = BaseConverter(3, intArrayOf(1, 1, 2, 0))

        val expectedDigits = intArrayOf(2, 10)
        val actualDigits = baseConverter.convertToBase(16)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testHexadecimalToTrinary() {
        val baseConverter = BaseConverter(16, intArrayOf(2, 10))

        val expectedDigits = intArrayOf(1, 1, 2, 0)
        val actualDigits = baseConverter.convertToBase(3)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun test15BitInteger() {
        val baseConverter = BaseConverter(97, intArrayOf(3, 46, 60))

        val expectedDigits = intArrayOf(6, 10, 45)
        val actualDigits = baseConverter.convertToBase(73)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testEmptyDigits() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("You must supply at least one digit.")

        BaseConverter(2, intArrayOf())
    }

    @Ignore
    @Test
    fun testSingleZero() {
        val baseConverter = BaseConverter(10, intArrayOf(0))

        val expectedDigits = intArrayOf(0)
        val actualDigits = baseConverter.convertToBase(2)

        assertArrayEquals(
            "Expected digits: ${Arrays.toString(expectedDigits)} but found digits: ${Arrays.toString(actualDigits)}",
            expectedDigits,
            actualDigits)
    }

    @Ignore
    @Test
    fun testMultipleZeros() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Digits may not contain leading zeros.")

        BaseConverter(10, intArrayOf(0, 0, 0))
    }

    @Ignore
    @Test
    fun testLeadingZeros() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Digits may not contain leading zeros.")

        BaseConverter(7, intArrayOf(0, 6, 0))
    }

    @Ignore
    @Test
    fun testFirstBaseIsOne() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Bases must be at least 2.")

        BaseConverter(1, intArrayOf(0))
    }

    @Ignore
    @Test
    fun testFirstBaseIsZero() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Bases must be at least 2.")

        BaseConverter(0, intArrayOf())
    }

    @Ignore
    @Test
    fun testFirstBaseIsNegative() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Bases must be at least 2.")

        BaseConverter(-2, intArrayOf(1))
    }

    @Ignore
    @Test
    fun testNegativeDigit() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Digits may not be negative.")

        BaseConverter(2, intArrayOf(1, -1, 1, 0, 1, 0))
    }

    @Ignore
    @Test
    fun testInvalidPositiveDigit() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("All digits must be strictly less than the base.")

        BaseConverter(2, intArrayOf(1, 2, 1, 0, 1, 0))
    }

    @Ignore
    @Test
    fun testSecondBaseIsOne() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1, 0, 1, 0))

        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Bases must be at least 2.")

        baseConverter.convertToBase(1)
    }

    @Ignore
    @Test
    fun testSecondBaseIsZero() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1, 0, 1, 0))

        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Bases must be at least 2.")

        baseConverter.convertToBase(0)
    }

    @Ignore
    @Test
    fun testSecondBaseIsNegative() {
        val baseConverter = BaseConverter(2, intArrayOf(1))

        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Bases must be at least 2.")

        baseConverter.convertToBase(-7)
    }
}
