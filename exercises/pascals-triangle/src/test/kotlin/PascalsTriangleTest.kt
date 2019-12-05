import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class PascalsTriangleTest {
    @Test
    fun `zero rows`() = assertTriangleEquals(
            0,
            emptyList())


    @Ignore
    @Test
    fun `single row`() = assertTriangleEquals(
            1,
            listOf(
                    listOf(1)))

    @Ignore
    @Test
    fun `two rows`() = assertTriangleEquals(
            2,
            listOf(
                    listOf(1),
                    listOf(1, 1)))

    @Ignore
    @Test
    fun `tree rows`() = assertTriangleEquals(
            3,
            listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1)))

    @Ignore
    @Test
    fun `four rows`() = assertTriangleEquals(
            4,
            listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1)))

    @Ignore
    @Test
    fun `five rows`() = assertTriangleEquals(
            5,
            listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1),
                    listOf(1, 4, 6, 4, 1)))

    @Ignore
    @Test
    fun `six rows`() = assertTriangleEquals(
            6,
            listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1),
                    listOf(1, 4, 6, 4, 1),
                    listOf(1, 5, 10, 10, 5, 1)))

    @Ignore
    @Test
    fun `ten rows`() = assertTriangleEquals(
            10,
            listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1),
                    listOf(1, 4, 6, 4, 1),
                    listOf(1, 5, 10, 10, 5, 1),
                    listOf(1, 6, 15, 20, 15, 6, 1),
                    listOf(1, 7, 21, 35, 35, 21, 7, 1),
                    listOf(1, 8, 28, 56, 70, 56, 28, 8, 1),
                    listOf(1, 9, 36, 84, 126, 126, 84, 36, 9, 1)))

}

private fun assertTriangleEquals(rows: Int, triangles: List<List<Int>>) =
        assertEquals(triangles, PascalsTriangle.computeTriangle(rows))
