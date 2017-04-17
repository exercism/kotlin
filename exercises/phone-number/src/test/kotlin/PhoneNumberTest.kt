import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.fail

class PhoneNumberTest {


    @Test
    fun cleansNumber() {
        val expectedNumber = "1234567890"
        val actualNumber = PhoneNumber("(123) 456-7890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Ignore
    @Test
    fun cleansNumberWithDots() {
        val expectedNumber = "1234567890"
        val actualNumber = PhoneNumber("123.456.7890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Ignore
    @Test
    fun validWhen11DigitsAndFirstIs1() {
        val expectedNumber = "1234567890"
        val actualNumber = PhoneNumber("11234567890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun invalidWhenOnly11Digits() {
        val actualNumber = PhoneNumber("21234567890").number

        fail("IllegalArgumentException should have been thrown")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun invalidWhen9Digits() {
        val actualNumber = PhoneNumber("123456789").number

        fail("IllegalArgumentException should have been thrown")
    }

    @Ignore
    @Test
    fun areaCode() {
        val expectedAreaCode = "123"
        val actualAreaCode = PhoneNumber("1234567890").areaCode

        assertEquals(expectedAreaCode, actualAreaCode)
    }

    @Ignore
    @Test
    fun toStringPrint() {
        val expectedtoStringNumber = "(123) 456-7890"
        val actualtoStringNumber = PhoneNumber("1234567890").toString()

        assertEquals(expectedtoStringNumber, actualtoStringNumber)
    }

    @Ignore
    @Test
    fun toStringPrintWithFullUSPhoneNumber() {
        val expectedtoStringNumber = "(123) 456-7890"
        val actualtoStringNumber = PhoneNumber("11234567890").toString()

        assertEquals(expectedtoStringNumber, actualtoStringNumber)
    }

}
