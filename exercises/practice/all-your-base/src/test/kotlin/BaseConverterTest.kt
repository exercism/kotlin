import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith
import kotlin.test.Ignore
import kotlin.test.Test

class BaseConverterTest {

    @Test
    fun testSingleBitOneToDecimal() {
        val baseConverter = BaseConverter(2, intArrayOf(1))

        val expectedDigits = intArrayOf(1)
        val actualDigits = baseConverter.convertToBase(10)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testBinaryToSingleDecimal() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1))

        val expectedDigits = intArrayOf(5)
        val actualDigits = baseConverter.convertToBase(10)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testSingleDecimalToBinary() {
        val baseConverter = BaseConverter(10, intArrayOf(5))

        val expectedDigits = intArrayOf(1, 0, 1)
        val actualDigits = baseConverter.convertToBase(2)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testBinaryToMultipleDecimal() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1, 0, 1, 0))

        val expectedDigits = intArrayOf(4, 2)
        val actualDigits = baseConverter.convertToBase(10)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testDecimalToBinary() {
        val baseConverter = BaseConverter(10, intArrayOf(4, 2))

        val expectedDigits = intArrayOf(1, 0, 1, 0, 1, 0)
        val actualDigits = baseConverter.convertToBase(2)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testTrinaryToHexadecimal() {
        val baseConverter = BaseConverter(3, intArrayOf(1, 1, 2, 0))

        val expectedDigits = intArrayOf(2, 10)
        val actualDigits = baseConverter.convertToBase(16)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testHexadecimalToTrinary() {
        val baseConverter = BaseConverter(16, intArrayOf(2, 10))

        val expectedDigits = intArrayOf(1, 1, 2, 0)
        val actualDigits = baseConverter.convertToBase(3)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun test15BitInteger() {
        val baseConverter = BaseConverter(97, intArrayOf(3, 46, 60))

        val expectedDigits = intArrayOf(6, 10, 45)
        val actualDigits = baseConverter.convertToBase(73)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testEmptyDigits() {
        assertFailsWith(IllegalArgumentException::class, "You must supply at least one digit.") {
            BaseConverter(2, intArrayOf())
        }
    }

    @Ignore
    @Test
    fun testSingleZero() {
        val baseConverter = BaseConverter(10, intArrayOf(0))

        val expectedDigits = intArrayOf(0)
        val actualDigits = baseConverter.convertToBase(2)

        assertContentEquals(
            expectedDigits,
            actualDigits,
            "Expected digits: ${expectedDigits.contentToString()} but found digits: ${actualDigits.contentToString()}")
    }

    @Ignore
    @Test
    fun testMultipleZeros() {
        assertFailsWith(IllegalArgumentException::class, "Digits may not contain leading zeros.") {
            BaseConverter(10, intArrayOf(0, 0, 0))
        }
    }

    @Ignore
    @Test
    fun testLeadingZeros() {
        assertFailsWith(IllegalArgumentException::class, "Digits may not contain leading zeros.") {
            BaseConverter(7, intArrayOf(0, 6, 0))
        }
    }

    @Ignore
    @Test
    fun testFirstBaseIsOne() {
        assertFailsWith(IllegalArgumentException::class, "Bases must be at least 2.") {
            BaseConverter(1, intArrayOf(0))
        }
    }

    @Ignore
    @Test
    fun testFirstBaseIsZero() {
        assertFailsWith(IllegalArgumentException::class, "Bases must be at least 2.") {
            BaseConverter(0, intArrayOf())
        }
    }

    @Ignore
    @Test
    fun testFirstBaseIsNegative() {
        assertFailsWith(IllegalArgumentException::class, "Bases must be at least 2.") {
            BaseConverter(-2, intArrayOf(1))
        }
    }

    @Ignore
    @Test
    fun testNegativeDigit() {
        assertFailsWith(IllegalArgumentException::class, "Digits may not be negative.") {
            BaseConverter(2, intArrayOf(1, -1, 1, 0, 1, 0))
        }
    }

    @Ignore
    @Test
    fun testInvalidPositiveDigit() {
        assertFailsWith(IllegalArgumentException::class, "All digits must be strictly less than the base.") {
            BaseConverter(2, intArrayOf(1, 2, 1, 0, 1, 0))
        }
    }

    @Ignore
    @Test
    fun testSecondBaseIsOne() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1, 0, 1, 0))

        assertFailsWith(IllegalArgumentException::class, "Bases must be at least 2.") {
            baseConverter.convertToBase(1)
        }
    }

    @Ignore
    @Test
    fun testSecondBaseIsZero() {
        val baseConverter = BaseConverter(2, intArrayOf(1, 0, 1, 0, 1, 0))

        assertFailsWith(IllegalArgumentException::class, "Bases must be at least 2.") {
            baseConverter.convertToBase(0)
        }
    }

    @Ignore
    @Test
    fun testSecondBaseIsNegative() {
        val baseConverter = BaseConverter(2, intArrayOf(1))

        assertFailsWith(IllegalArgumentException::class, "Bases must be at least 2.") {
            baseConverter.convertToBase(-7)
        }
    }
}
