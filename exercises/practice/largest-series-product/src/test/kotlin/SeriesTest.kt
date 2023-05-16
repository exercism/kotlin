import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SeriesTest {

    @Test
    fun `corner - span equals length`() = assertLSPEquals("29", 2, 18)

    @Ignore
    @Test
    fun `numbers in order - span 2`() = assertLSPEquals("0123456789", 2, 72)

    @Ignore
    @Test
    fun `span 2`() = assertLSPEquals("576802143", 2, 48)

    @Ignore
    @Test
    fun `numbers in order - span 3`() = assertLSPEquals("0123456789", 3, 504)

    @Ignore
    @Test
    fun `span 3`() = assertLSPEquals("1027839564", 3, 270)

    @Ignore
    @Test
    fun `numbers in order - span 5`() = assertLSPEquals("0123456789", 5, 15120)

    @Ignore
    @Test
    fun `corner - long source sequence`() = assertLSPEquals("73167176531330624919225119674426574742355349194934", 6, 23520)

    @Ignore
    @Test
    fun `zeros - only`() = assertLSPEquals("0000", 2, 0)

    @Ignore
    @Test
    fun `zeros - dense`() = assertLSPEquals("99099", 3, 0)

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `reject - span longer than string length`() {
        lsp("123", 4)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `reject - empty string and nonzero span`() {
        lsp("", 1)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `reject - nondigits in source sequence`() {
        Series("1234a5")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `reject - negative span`() {
        lsp("12345", -1)
    }
}

private fun assertLSPEquals(input: String, span: Int, lsp: Long) {
    assertEquals(lsp(input, span), lsp)
}

private fun lsp(input: String, span: Int) = Series(input).getLargestProduct(span)

