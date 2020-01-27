import kotlin.test.assertEquals
import kotlin.test.Test

class ScaleTest {

    // Test chromatic scales
    @Test
    fun `chromatic scale with sharps`() {
        val expected = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
        assertEquals(expected, Scale("C").chromatic())
    }

    @Test
    fun `chromatic scale with flats`() {
        val expected = listOf("F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E")
        assertEquals(expected, Scale("F").chromatic())
    }

    // Test scales with specified intervals
    @Test
    fun `simple major scale`() {
        val expected = listOf("C", "D", "E", "F", "G", "A", "B")
        assertEquals(expected, Scale("C").interval("MMmMMMm"))
    }

    @Test
    fun `major scale with sharps`() {
        val expected = listOf("G", "A", "B", "C", "D", "E", "F#")
        assertEquals(expected, Scale("G").interval("MMmMMMm"))
    }

    @Test
    fun `major scale with flats`() {
        val expected = listOf("F", "G", "A", "Bb", "C", "D", "E")
        assertEquals(expected, Scale("F").interval("MMmMMMm"))
    }

    @Test
    fun `minor scale with sharps`() {
        val expected = listOf("F#", "G#", "A", "B", "C#", "D", "E")
        assertEquals(expected, Scale("f#").interval("MmMMmMM"))
    }

    @Test
    fun `minor scale with flats`() {
        val expected = listOf("Bb", "C", "Db", "Eb", "F", "Gb", "Ab")
        assertEquals(expected, Scale("bb").interval("MmMMmMM"))
    }

    @Test
    fun `dorian mode`() {
        val expected = listOf("D", "E", "F", "G", "A", "B", "C")
        assertEquals(expected, Scale("d").interval("MmMMMmM"))
    }

    @Test
    fun `mixolydian mode`() {
        val expected = listOf("Eb", "F", "G", "Ab", "Bb", "C", "Db")
        assertEquals(expected, Scale("Eb").interval("MMmMMmM"))
    }

    @Test
    fun `lydian mode`() {
        val expected = listOf("A", "B", "C#", "D#", "E", "F#", "G#")
        assertEquals(expected, Scale("a").interval("MMMmMMm"))
    }

    @Test
    fun `phrygian mode`() {
        val expected = listOf("E", "F", "G", "A", "B", "C", "D")
        assertEquals(expected, Scale("e").interval("mMMMmMM"))
    }

    @Test
    fun `locrian mode`() {
        val expected = listOf("G", "Ab", "Bb", "C", "Db", "Eb", "F")
        assertEquals(expected, Scale("g").interval("mMMmMMM"))
    }

    @Test
    fun `harmonic minor`() {
        val expected = listOf("D", "E", "F", "G", "A", "Bb", "Db")
        assertEquals(expected, Scale("d").interval("MmMMmAm"))
    }

    @Test
    fun octatonic() {
        val expected = listOf("C", "D", "D#", "F", "F#", "G#", "A", "B")
        assertEquals(expected, Scale("C").interval("MmMmMmMm"))
    }

    @Test
    fun hexatonic() {
        val expected = listOf("Db", "Eb", "F", "G", "A", "B")
        assertEquals(expected, Scale("Db").interval("MMMMMM"))
    }

    @Test
    fun pentatonic() {
        val expected = listOf("A", "B", "C#", "E", "F#")
        assertEquals(expected, Scale("A").interval("MMAMA"))
    }

    @Test
    fun enigmatic() {
        val expected = listOf("G", "G#", "B", "C#", "D#", "F", "F#")
        assertEquals(expected, Scale("G").interval("mAMMMmm"))
    }
}
