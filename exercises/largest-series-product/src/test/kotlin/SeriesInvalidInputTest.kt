
import org.junit.Test

class SeriesInvalidInputTest {

    @Test(expected = IllegalArgumentException::class)
    fun nonDigitCharacters() {
        Series("1234a5")
    }

    @Test(expected = IllegalArgumentException::class)
    fun negativeSpan() {
        Series("12345").calculate(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun spanLargerThanStringSize() {
        Series("123").calculate(4)
    }

    @Test(expected = IllegalArgumentException::class)
    fun spanLargerThanStringSizeUsingEmptyString() {
        Series("").calculate(1)
    }
}
