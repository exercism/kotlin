import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class SchoolTest {
    @Test
    fun `adding a student adds them to the sorted roster`() = assertRosterEquals(
        mapOf(
            "Aimee" to 2
        ),
        listOf("Aimee")
    )

    @Ignore
    @Test
    fun `adding more student adds them to the sorted roster`() =
        assertRosterEquals(
            mapOf(
                "Blair" to 2,
                "James" to 2,
                "Paul" to 2
            ),
            listOf("Blair", "James", "Paul")
        )

    @Ignore
    @Test
    fun `adding students to different grades adds them to the same sorted roster`() =
        assertRosterEquals(
            mapOf(
                "Chelsea" to 3,
                "Logan" to 7
            ),
            listOf("Chelsea", "Logan")
        )

    @Ignore
    @Test
    fun `roster returns an empty list if there are no students enrolled`() =
        assertRosterEquals(
            mapOf(),
            listOf()
        )

    @Ignore
    @Test
    fun `student names with grades are displayed in the same sorted roster`() =
        assertRosterEquals(
            mapOf(
                "Peter" to 2,
                "Anna" to 1,
                "Barb" to 1,
                "Zoe" to 2,
                "Alex" to 2,
                "Jim" to 3,
                "Charlie" to 1
            ),
            listOf("Anna", "Barb", "Charlie", "Alex", "Peter", "Zoe", "Jim")
        )

    @Ignore
    @Test
    fun `grade returns the students in that grade in alphabetical order`() =
        assertGradeEquals(
            mapOf(
                "Franklin" to 5,
                "Bradley" to 5,
                "Jeff" to 1
            ),
            5,
            listOf("Bradley", "Franklin")
        )

    @Ignore
    @Test
    fun `grade returns an empty list if there are no students in that grade`() = assertGradeEquals(
        mapOf(),
        1,
        listOf()
    )
}

private fun assertRosterEquals(students: Map<String, Int>, expectation: List<String>) =
    with(School()) {
        students.forEach { add(it.key, it.value) }
        assertEquals(expectation, roster())
    }

private fun assertGradeEquals(students: Map<String, Int>, grade: Int, expectation: List<String>) =
    with(School()) {
        students.forEach { add(it.key, it.value) }
        assertEquals(expectation, grade(grade))
    }
