import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test

class RomanNumeralsTest() {

    @Test
    fun `1 is I`() {
        assertEquals("I", RomanNumerals.value(1))
    }

    @Ignore
    @Test
    fun `2 is II`() {
        assertEquals("II", RomanNumerals.value(2))
    }

    @Ignore
    @Test
    fun `3 is III`() {
        assertEquals("III", RomanNumerals.value(3))
    }

    @Ignore
    @Test
    fun `4 is IV`() {
        assertEquals("IV", RomanNumerals.value(4))
    }

    @Ignore
    @Test
    fun `5 is V`() {
        assertEquals("V", RomanNumerals.value(5))
    }

    @Ignore
    @Test
    fun `6 is VI`() {
        assertEquals("VI", RomanNumerals.value(6))
    }

    @Ignore
    @Test
    fun `9 is IX`() {
        assertEquals("IX", RomanNumerals.value(9))
    }

    @Ignore
    @Test
    fun `16 is XVI`() {
        assertEquals("XVI", RomanNumerals.value(16))
    }

    @Ignore
    @Test
    fun `27 is XXVII`() {
        assertEquals("XXVII", RomanNumerals.value(27))
    }

    @Ignore
    @Test
    fun `48 is XLVIII`() {
        assertEquals("XLVIII", RomanNumerals.value(48))
    }

    @Ignore
    @Test
    fun `49 is XLIX`() {
        assertEquals("XLIX", RomanNumerals.value(49))
    }

    @Ignore
    @Test
    fun `59 is LIX`() {
        assertEquals("LIX", RomanNumerals.value(59))
    }

    @Ignore
    @Test
    fun `66 is LXVI`() {
        assertEquals("LXVI", RomanNumerals.value(66))
    }

    @Ignore
    @Test
    fun `93 is XCIII`() {
        assertEquals("XCIII", RomanNumerals.value(93))
    }

    @Ignore
    @Test
    fun `141 is CXLI`() {
        assertEquals("CXLI", RomanNumerals.value(141))
    }

    @Ignore
    @Test
    fun `163 is CLXIII`() {
        assertEquals("CLXIII", RomanNumerals.value(163))
    }

    @Ignore
    @Test
    fun `166 is CLXVI`() {
        assertEquals("CLXVI", RomanNumerals.value(166))
    }

    @Ignore
    @Test
    fun `402 is CDII`() {
        assertEquals("CDII", RomanNumerals.value(402))
    }

    @Ignore
    @Test
    fun `575 is DLXXV`() {
        assertEquals("DLXXV", RomanNumerals.value(575))
    }

    @Ignore
    @Test
    fun `666 is DCLXVI`() {
        assertEquals("DCLXVI", RomanNumerals.value(666))
    }

    @Ignore
    @Test
    fun `911 is CMXI`() {
        assertEquals("CMXI", RomanNumerals.value(911))
    }

    @Ignore
    @Test
    fun `1024 is MXXIV`() {
        assertEquals("MXXIV", RomanNumerals.value(1024))
    }

    @Ignore
    @Test
    fun `1666 is MDCLXVI`() {
        assertEquals("MDCLXVI", RomanNumerals.value(1666))
    }

    @Ignore
    @Test
    fun `3000 is MMM`() {
        assertEquals("MMM", RomanNumerals.value(3000))
    }

    @Ignore
    @Test
    fun `3001 is MMMI`() {
        assertEquals("MMMI", RomanNumerals.value(3001))
    }

    @Ignore
    @Test
    fun `3888 is MMMDCCCLXXXVIII`() {
        assertEquals("MMMDCCCLXXXVIII", RomanNumerals.value(3888))
    }

    @Ignore
    @Test
    fun `3999 is MMMCMXCIX`() {
        assertEquals("MMMCMXCIX", RomanNumerals.value(3999))
    }
}
