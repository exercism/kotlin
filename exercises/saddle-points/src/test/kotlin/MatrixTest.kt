import org.junit.Ignore
import org.junit.Test
import java.util.Collections.emptySet
import kotlin.test.assertEquals

class MatrixTest {

    @Test
    fun testCanIdentifySingleSaddlePoint() {
        val matrix = Matrix(listOf(
            listOf(9, 8, 7),
            listOf(5, 3, 2),
            listOf(6, 6, 7)
        ))

        val expectedSaddlePoints = setOf(MatrixCoordinate(1, 0))

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun testCanIdentifyThatEmptyMatrixHasNoSaddlePoints() {
        val matrix = Matrix(listOf(emptyList()))

        val expectedSaddlePoints = emptySet<MatrixCoordinate>()

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun testCanIdentifyLackOfSaddlePointsWhenThereAreNone() {
        val matrix = Matrix(listOf(
            listOf(1, 2, 3),
            listOf(3, 1, 2),
            listOf(2, 3, 1)
        ))

        val expectedSaddlePoints = emptySet<MatrixCoordinate>()

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun testCanIdentifyMultipleSaddlePoints() {
        val matrix = Matrix(listOf(
            listOf(4, 5, 4),
            listOf(3, 5, 5),
            listOf(1, 5, 4)
        ))

        val expectedSaddlePoints = setOf(
            MatrixCoordinate(0, 1),
            MatrixCoordinate(1, 1),
            MatrixCoordinate(2, 1)
        )

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Ignore
    @Test
    fun testCanIdentifySaddlePointInBottomRightCorner() {
        val matrix = Matrix(listOf(
            listOf(8, 7, 9),
            listOf(6, 7, 6),
            listOf(3, 2, 5)
        ))

        val expectedSaddlePoints = setOf(MatrixCoordinate(2, 2))

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

}
