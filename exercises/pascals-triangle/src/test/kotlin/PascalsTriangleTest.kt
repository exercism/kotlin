import org.junit.Test
import org.junit.Ignore
import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class PascalsTriangleTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun zeroRows() {
        val expectedOutput = emptyList<List<Int>>()

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(0))
    }

    @Ignore
    @Test
    fun oneRow() {
        val expectedOutput = listOf(
                listOf(1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(1))
    }

    @Ignore
    @Test
    fun twoRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(2))
    }

    @Ignore
    @Test
    fun threeRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(3))
    }

    @Ignore
    @Test
    fun fourRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(4))
    }

    @Ignore
    @Test
    fun fiveRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(5))
    }

    @Ignore
    @Test
    fun sixRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1),
                listOf(1, 5, 10, 10, 5, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(6))
    }

    @Ignore
    @Test
    fun tenRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1),
                listOf(1, 5, 10, 10, 5, 1),
                listOf(1, 6, 15, 20, 15, 6, 1),
                listOf(1, 7, 21, 35, 35, 21, 7, 1),
                listOf(1, 8, 28, 56, 70, 56, 28, 8, 1),
                listOf(1, 9, 36, 84, 126, 126, 84, 36, 9, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(10))
    }

    @Ignore
    @Test
    fun validatesNotNegativeRows() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Rows can't be negative!")

        PascalsTriangle.computeTriangle(-1)
    }

}
