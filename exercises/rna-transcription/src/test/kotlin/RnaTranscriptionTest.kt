import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class RnaTranscriptionTest {
    @Test
    fun `empty RNA` ()= assertEquals("", transcribeToRna(""))

    @Test
    @Ignore
    fun `RNA complement of cytosine is guanine`() = assertEquals("G", transcribeToRna("C"))

    @Ignore
    @Test
    fun `RNA complement of guanine is cytosine`() = assertEquals("C", transcribeToRna("G"))

    @Ignore
    @Test
    fun `RNA complement of thymine is adenine`() = assertEquals("A", transcribeToRna("T"))

    @Ignore
    @Test
    fun `RNA complement of adenine is uracil`() = assertEquals("U", transcribeToRna("A"))

    @Ignore
    @Test
    fun `compound RNA`() = assertEquals("UGCACCAGAAUU", transcribeToRna("ACGTGGTCTTAA"))
}
