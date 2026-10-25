import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.Ignore
import kotlin.test.Test

class HammingTest {

    @Test
    fun `empty strands`() {
        assertEquals(0, Hamming.compute("", ""))
    }

    @Ignore
    @Test
    fun `single letter identical strands`() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Ignore
    @Test
    fun `single letter different strands`() {
        assertEquals(1, Hamming.compute("G", "T"))
    }

    @Ignore
    @Test
    fun `long identical strands`() {
        assertEquals(0, Hamming.compute("GGACTGAAATCTG", "GGACTGAAATCTG"))
    }

    @Ignore
    @Test
    fun `long different strands`() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

    @Ignore
    @Test
    fun `disallow first strand longer`() {
        assertFailsWith(IllegalArgumentException::class, "left and right strands must be of equal length") {
            Hamming.compute("AATG", "AAA")
        }
    }

    @Ignore
    @Test
    fun `disallow second strand longer`() {
        assertFailsWith(IllegalArgumentException::class, "left and right strands must be of equal length") {
            Hamming.compute("ATA", "AGTG")
        }
    }
}
