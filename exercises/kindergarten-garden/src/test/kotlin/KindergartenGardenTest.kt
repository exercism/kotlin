import kotlin.test.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

class KindergartenGardenTest {

    @Test
    fun `single student`() {
        val student = "Alice"
        val diagram = "RC\nGG"
        val expected = listOf("radishes", "clover", "grass", "grass")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `single student2`() {
        val student = "Alice"
        val diagram = "VC\nRC"
        val expected = listOf("violets", "clover", "radishes", "clover")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `two students`() {
        val student = "Bob"
        val diagram = "VVCG\nVVRC"
        val expected = listOf("clover", "grass", "radishes", "clover")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `one garden second student`() {
        val student = "Bob"
        val diagram = "VVCCGG\nVVCCGG"
        val expected = listOf("clover", "clover", "clover", "clover")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `one garden third student`() {
        val student = "Charlie"
        val diagram = "VVCCGG\nVVCCGG"
        val expected = listOf("grass", "grass", "grass", "grass")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `full garden first student`() {
        val student = "Alice"
        val diagram = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf("violets", "radishes", "violets", "radishes")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `full garden second student`() {
        val student = "Bob"
        val diagram = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf("clover", "grass", "clover", "clover")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `full garden second to last student`() {
        val student = "Kincaid"
        val diagram = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf("grass", "clover", "clover", "grass")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

    @Test
    fun `full garden last student`() {
        val student = "Larry"
        val diagram = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf("grass", "violets", "clover", "violets")

        assertEquals(expected, KindergartenGarden(diagram).getPlantsOfStudent(student))
    }

}
