import kotlin.test.asserter
import kotlin.test.Test

class ScaleTest {

    // Test chromatic scales
    @Test
    fun `chromatic scale with sharps`() {
        val expected = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
        assertScalesEqual(expected, Scale("C").chromatic())
    }

    @Test
    fun `chromatic scale with flats`() {
        val expected = listOf("F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E")
        assertScalesEqual(expected, Scale("F").chromatic())
    }

    // Test scales with specified intervals
    @Test
    fun `simple major scale`() {
        val expected = listOf("C", "D", "E", "F", "G", "A", "B")
        assertScalesEqual(expected, Scale("C").interval("MMmMMMm"))
    }

    @Test
    fun `major scale with sharps`() {
        val expected = listOf("G", "A", "B", "C", "D", "E", "F#")
        assertScalesEqual(expected, Scale("G").interval("MMmMMMm"))
    }

    @Test
    fun `major scale with flats`() {
        val expected = listOf("F", "G", "A", "Bb", "C", "D", "E")
        assertScalesEqual(expected, Scale("F").interval("MMmMMMm"))
    }

    @Test
    fun `minor scale with sharps`() {
        val expected = listOf("F#", "G#", "A", "B", "C#", "D", "E")
        assertScalesEqual(expected, Scale("f#").interval("MmMMmMM"))
    }

    @Test
    fun `minor scale with flats`() {
        val expected = listOf("Bb", "C", "Db", "Eb", "F", "Gb", "Ab")
        assertScalesEqual(expected, Scale("bb").interval("MmMMmMM"))
    }

    @Test
    fun `dorian mode`() {
        val expected = listOf("D", "E", "F", "G", "A", "B", "C")
        assertScalesEqual(expected, Scale("d").interval("MmMMMmM"))
    }

    @Test
    fun `mixolydian mode`() {
        val expected = listOf("Eb", "F", "G", "Ab", "Bb", "C", "Db")
        assertScalesEqual(expected, Scale("Eb").interval("MMmMMmM"))
    }

    @Test
    fun `lydian mode`() {
        val expected = listOf("A", "B", "C#", "D#", "E", "F#", "G#")
        assertScalesEqual(expected, Scale("a").interval("MMMmMMm"))
    }

    @Test
    fun `phrygian mode`() {
        val expected = listOf("E", "F", "G", "A", "B", "C", "D")
        assertScalesEqual(expected, Scale("e").interval("mMMMmMM"))
    }

    @Test
    fun `locrian mode`() {
        val expected = listOf("G", "Ab", "Bb", "C", "Db", "Eb", "F")
        assertScalesEqual(expected, Scale("g").interval("mMMmMMM"))
    }

    @Test
    fun `harmonic minor`() {
        val expected = listOf("D", "E", "F", "G", "A", "Bb", "Db")
        assertScalesEqual(expected, Scale("d").interval("MmMMmAm"))
    }

    @Test
    fun octatonic() {
        val expected = listOf("C", "D", "D#", "F", "F#", "G#", "A", "B")
        assertScalesEqual(expected, Scale("C").interval("MmMmMmMm"))
    }

    @Test
    fun hexatonic() {
        val expected = listOf("Db", "Eb", "F", "G", "A", "B")
        assertScalesEqual(expected, Scale("Db").interval("MMMMMM"))
    }

    @Test
    fun pentatonic() {
        val expected = listOf("A", "B", "C#", "E", "F#")
        assertScalesEqual(expected, Scale("A").interval("MMAMA"))
    }

    @Test
    fun enigmatic() {
        val expected = listOf("G", "G#", "B", "C#", "D#", "F", "F#")
        assertScalesEqual(expected, Scale("G").interval("mAMMMmm"))
    }

    fun assertScalesEqual(expected: List<String>, actual: List<String>) {
        asserter.assertTrue(
            { "Scales should be equal. Expected <$expected>, actual <$actual>" },
            scalesAreEqual(expected, actual))
    }

    fun scalesAreEqual(expected: List<String>, actual: List<String>): Boolean {
        if (expected.size != actual.size) return false
        return expected.zip(actual, this::notesEqual).all { it }
    }

    // Few enough equal notes that we can just list them all
    fun notesEqual(left: String, right: String) = left.equals(right) || when(left) {
        // A# == Bb
        "A#" -> right.equals("Bb")
        "Bb" -> right.equals("A#")
        // C# == Db
        "C#" -> right.equals("Db")
        "Db" -> right.equals("C#")
        // D# == Eb
        "D#" -> right.equals("Eb")
        "Eb" -> right.equals("D#")
        // F# == Gb
        "F#" -> right.equals("Gb")
        "Gb" -> right.equals("F#")
        // G# == Ab
        "G#" -> right.equals("Ab")
        "Ab" -> right.equals("G#")
        else -> false
    }
}
