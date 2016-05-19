import org.junit.Test
import kotlin.test.assertEquals

class PascalsTriangleTest {

    @Test
    fun triangleWithFourRows() {
        val expectedOutput = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1)
        )

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(4))
    }

    @Test
    fun triangleWithSixRows() {
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

    @Test
    fun expectEmptyTriangle() {
        val expectedOutput = emptyList<List<Int>>()

        assertEquals(expectedOutput, PascalsTriangle.computeTriangle(0))
    }

    @Test(expected = IllegalArgumentException::class)
    fun validatesNotNegativeRows() {
        PascalsTriangle.computeTriangle(-1)
    }
}
