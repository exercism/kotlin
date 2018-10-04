import kotlin.test.Test
import kotlin.test.assertEquals

class KindergartenGardenTest {

    @Test
    fun singleStudent() {
        val student = "Alice"
        val plants = "RC\nGG"
        val expected = listOf(Plant.RADISHES, Plant.CLOVER, Plant.GRASS, Plant.GRASS)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun singleStudent2() {
        val student = "Alice"
        val plants = "VC\nRC"
        val expected = listOf(Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES, Plant.CLOVER)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun twoStudents() {
        val student = "Bob"
        val plants = "VVCG\nVVRC"
        val expected = listOf(Plant.CLOVER, Plant.GRASS, Plant.RADISHES, Plant.CLOVER)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun oneGardenSecondStudent() {
        val student = "Bob"
        val plants = "VVCCGG\nVVCCGG"
        val expected = listOf(Plant.CLOVER, Plant.CLOVER, Plant.CLOVER, Plant.CLOVER)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun oneGardenThirdStudent() {
        val student = "Charlie"
        val plants = "VVCCGG\nVVCCGG"
        val expected = listOf(Plant.GRASS, Plant.GRASS, Plant.GRASS, Plant.GRASS)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun fullGardenFirstStudent() {
        val student = "Alice"
        val plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf(Plant.VIOLETS, Plant.RADISHES, Plant.VIOLETS, Plant.RADISHES)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun fullGardenSecondStudent() {
        val student = "Bob"
        val plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf(Plant.CLOVER, Plant.GRASS, Plant.CLOVER, Plant.CLOVER)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun fullGardenSecondToLastStudent() {
        val student = "Kincaid"
        val plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf(Plant.GRASS, Plant.CLOVER, Plant.CLOVER, Plant.GRASS)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

    @Test
    fun fullGardenLastStudent() {
        val student = "Larry"
        val plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV"
        val expected = listOf(Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS)

        assertEquals(expected, KindergartenGarden(plants).getPlantsOfStudent(student))
    }

}
