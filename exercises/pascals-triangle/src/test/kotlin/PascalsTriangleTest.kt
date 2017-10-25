import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class PascalsTriangleTest {

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
    @Test(expected = IllegalArgumentException::class)
    fun validatesNotNegativeRows() {
        PascalsTriangle.computeTriangle(-1)
    }

}
