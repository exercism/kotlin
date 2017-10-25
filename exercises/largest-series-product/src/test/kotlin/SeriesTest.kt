
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SeriesTest {

    @Test
    fun findsTheLargestProductIfSpanEqualsLength() {
        assertEquals(18, Series("29").getLargestProduct(2))
    }

    @Ignore
    @Test
    fun findsTheLargestProductOf2WithNumbersInOrder() {
        assertEquals(72, Series("0123456789").getLargestProduct(2))
    }

    @Ignore
    @Test
    fun findsTheLargestProductOf2() {
        assertEquals(48, Series("576802143").getLargestProduct(2))
    }

    @Ignore
    @Test
    fun findsTheLargestProductOf3WithNumbersInOrder() {
        assertEquals(504, Series("0123456789").getLargestProduct(3))
    }

    @Ignore
    @Test
    fun findsTheLargestProductOf3() {
        assertEquals(270, Series("1027839564").getLargestProduct(3))
    }

    @Ignore
    @Test
    fun findsTheLargestProductOf5WithNumbersInOrder() {
        assertEquals(15120, Series("0123456789").getLargestProduct(5))
    }

    @Ignore
    @Test
    fun findsTheLargestProductWithinABigNumber() {
        assertEquals(23520, Series("73167176531330624919225119674426574742355349194934").getLargestProduct(6))
    }

    @Ignore
    @Test
    fun reports0IfAllDigitsAre0() {
        assertEquals(0, Series("0000").getLargestProduct(2))
    }

    @Ignore
    @Test
    fun reports0IfAllSpansInclude0() {
        assertEquals(0, Series("99099").getLargestProduct(3))
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun rejectsSpanLongerThanStringLength() {
        Series("123").getLargestProduct(4)
    }

    @Ignore
    @Test
    fun reports1ForEmptyStringAndEmptyProduct() {
        assertEquals(1, Series("").getLargestProduct(0))
    }

    @Ignore
    @Test
    fun reports1ForNonEmptyStringAndEmptyProduct() {
        assertEquals(1, Series("123").getLargestProduct(0))
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun rejectsEmptyStringAndNonZeroSpan() {
        Series("").getLargestProduct(1)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun rejectsInvalidCharacterInDigits() {
        Series("1234a5")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun rejectsNegativeSpan() {
        Series("12345").getLargestProduct(-1)
    }

}
