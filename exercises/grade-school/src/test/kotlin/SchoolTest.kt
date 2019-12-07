import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class SchoolTest {
    @Test
    fun `adding a student adds them to the sorted roster`() =
        students("Aimee" to 2)
            .everyone()
            .shouldBe(listOf("Aimee"))

    @Ignore
    @Test
    fun `adding more student adds them to the sorted roster`() =
        students(
            "Blair" to 2,
            "James" to 2,
            "Paul" to 2
        )
            .everyone()
            .shouldBe(listOf("Blair", "James", "Paul"))

    @Ignore
    @Test
    fun `adding students to different grades adds them to the same sorted roster`() =
        students(
            "Chelsea" to 3,
            "Logan" to 7
        )
            .everyone()
            .shouldBe(listOf("Chelsea", "Logan"))

    @Ignore
    @Test
    fun `roster returns an empty list if there are no students enrolled`() =
        students()
            .everyone()
            .shouldBe(listOf())

    @Ignore
    @Test
    fun `student names with grades are displayed in the same sorted roster`() =
        students(
            "Peter" to 2,
            "Anna" to 1,
            "Barb" to 1,
            "Zoe" to 2,
            "Alex" to 2,
            "Jim" to 3,
            "Charlie" to 1
        )
            .everyone()
            .shouldBe(listOf("Anna", "Barb", "Charlie", "Alex", "Peter", "Zoe", "Jim"))

    @Ignore
    @Test
    fun `grade returns the students in that grade in alphabetical order`() =
        students(
            "Franklin" to 5,
            "Bradley" to 5,
            "Jeff" to 1
        )
            .fromGrade(5)
            .shouldBe(listOf("Bradley", "Franklin"))

    @Ignore
    @Test
    fun `grade returns an empty list if there are no students in that grade`() =
        students()
            .fromGrade(1)
            .shouldBe(listOf())
}

private class Students(vararg students: Pair<String, Int>) {
    private val school = School()

    init {
        students.forEach { school.add(it.first, it.second) }
    }

    fun fromGrade(grade: Int) = StudentNames(school.grade(grade))
    fun everyone() = StudentNames(school.roster())
}

private class StudentNames(private val names: List<String>) {
    fun shouldBe(names: List<String>) = assertEquals(names, this.names)
}

private fun students(vararg students: Pair<String, Int>) = Students(*students)
