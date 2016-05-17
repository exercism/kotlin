import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SchoolTest {

    private lateinit var school: School

    @Before
    fun beforeTest() {
        school = School()
    }

    @Test
    fun startsWithNoStudents() {
        assertTrue(school.db().isEmpty())
    }

    @Test
    fun addsStudents() {
        school.add("Aimee", 2)

        val expected = mapOf(2 to listOf("Aimee"))
        assertEquals(expected, school.db())
    }

    @Test
    fun addsMoreStudentsInSameGrade() {
        val grade = 2
        school.add("James", grade)
        school.add("Blair", grade)
        school.add("Paul", grade)

        val expected = mapOf(2 to listOf("James", "Blair", "Paul"))
        assertEquals(expected, school.db())
    }

    @Test
    fun addsStudentsInMultipleGrades() {
        school.add("Chelsea", 3)
        school.add("Logan", 7)

        val expected = mapOf(3 to listOf("Chelsea"), 7 to listOf("Logan"))
        assertEquals(expected, school.db())
    }

    @Test
    fun getsStudentsInAGrade() {
        school.add("Franklin", 5)
        school.add("Bradley", 5)
        school.add("Jeff", 1)

        val expected = mapOf(5 to listOf("Franklin", "Bradley"), 1 to listOf("Jeff"))
        assertEquals(expected, school.db())
    }

    @Test
    fun getsStudentsInEmptyGrade() {
        assertTrue(school.grade(1).isEmpty())
    }

    @Test
    fun sortsSchool() {
        school.add("Jennifer", 4)
        school.add("Kareem", 6)
        school.add("Christopher", 4)
        school.add("Kyle", 3)

        val expected = mapOf(6 to listOf("Kareem"), 4 to listOf("Christopher", "Jennifer"), 3 to listOf("Kyle"))
        val sortedClasses = school.sort()
        assertEquals(expected, sortedClasses)
        assertEquals(listOf(3, 4, 6), sortedClasses.keys.toList(), "Grades not sorted in ascending order")

        assertEquals(listOf("Jennifer", "Christopher"), school.db().get(4), "Original student order should not be mutated")
    }
}
