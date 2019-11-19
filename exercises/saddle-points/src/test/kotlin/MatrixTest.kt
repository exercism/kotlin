import org.junit.Ignore
import org.junit.Test
import java.util.Collections.emptySet
import kotlin.test.assertEquals

class MatrixTest {

    @Test
    fun `single saddle point`() {
        val matrix = Matrix(
            listOf(
                listOf(9, 8, 7),
                listOf(5, 3, 2),
                listOf(6, 6, 7)
            )
        )

        val expectedSaddlePoints = setOf(MatrixCoordinate(2, 1))

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `no saddle points for empty matrix`() {
        val matrix = Matrix(listOf(emptyList()))

        val expectedSaddlePoints = emptySet<MatrixCoordinate>()

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `no saddle points for nonempty matrix`() {
        val matrix = Matrix(
            listOf(
                listOf(1, 2, 3),
                listOf(3, 1, 2),
                listOf(2, 3, 1)
            )
        )

        val expectedSaddlePoints = emptySet<MatrixCoordinate>()

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `multiple saddle points in a column`() {
        val matrix = Matrix(
            listOf(
                listOf(4, 5, 4),
                listOf(3, 5, 5),
                listOf(1, 5, 4)
            )
        )

        val expectedSaddlePoints = setOf(
            MatrixCoordinate(1, 2),
            MatrixCoordinate(2, 2),
            MatrixCoordinate(3, 2)
        )

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `multiple saddle points in a row`() {
        val matrix = Matrix(
            listOf(
                listOf(6, 7, 8),
                listOf(5, 5, 5),
                listOf(7, 5, 6)
            )
        )

        val expectedSaddlePoints = setOf(
            MatrixCoordinate(2, 1),
            MatrixCoordinate(2, 2),
            MatrixCoordinate(2, 3)
        )

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `saddle point in bottom right corner`() {
        val matrix = Matrix(
            listOf(
                listOf(8, 7, 9),
                listOf(6, 7, 6),
                listOf(3, 2, 5)
            )
        )

        val expectedSaddlePoints = setOf(MatrixCoordinate(3, 3))

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `saddle points in a single column matrix`() {
        val matrix = Matrix(
            listOf(
                listOf(2),
                listOf(1),
                listOf(4),
                listOf(1)
            )
        )

        val expectedSaddlePoints = setOf(
            MatrixCoordinate(2, 1),
            MatrixCoordinate(4, 1)
        )

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun `saddle points in a single row matrix`() {
        val matrix = Matrix(
            listOf(
                listOf(2, 5, 3, 5)
            )
        )

        val expectedSaddlePoints = setOf(
            MatrixCoordinate(1, 2),
            MatrixCoordinate(1, 4)
        )

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }
}
