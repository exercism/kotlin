import kotlin.test.Test
import kotlin.test.assertEquals

class MatrixTest {

    @Test
    fun `extract row from one number matrix`() {
        val matrixAsString = "1"
        val rowIndex = 1
        val expectedRow = listOf(1)
        assertEquals(expectedRow, Matrix(matrixAsString).row(rowIndex))
    }

    @Test
    fun `extract row from matrix`() {
        val matrixAsString = "1 2\n3 4"
        val rowIndex = 2
        val expectedRow = listOf(3, 4)
        assertEquals(expectedRow, Matrix(matrixAsString).row(rowIndex))
    }

    @Test
    fun `extract row from diff widths matrix`() {
        val matrixAsString = "1 2\n10 20"
        val rowIndex = 2
        val expectedRow = listOf(10, 20)
        assertEquals(expectedRow, Matrix(matrixAsString).row(rowIndex))
    }

    @Test
    fun `extract row from non square matrix`() {
        val matrixAsString = """
            1 2 3
            4 5 6
            7 8 9
            8 7 6
            """.trimIndent()
        val rowIndex = 4
        val expectedRow = listOf(8, 7, 6)
        assertEquals(expectedRow, Matrix(matrixAsString).row(rowIndex))
    }

    @Test
    fun `extract column from one number matrix`() {
        val matrixAsString = "1"
        val columnIndex = 1
        val expectedColumn = listOf(1)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }

    @Test
    fun `extract column matrix`() {
        val matrixAsString = """
            1 2 3
            4 5 6
            7 8 9
            """.trimIndent()
        val columnIndex = 3
        val expectedColumn = listOf(3, 6, 9)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }

    @Test
    fun `extract column from non square matrix`() {
        val matrixAsString = """
            1 2 3 4
            5 6 7 8
            9 8 7 6
            """.trimIndent()
        val columnIndex = 4
        val expectedColumn = listOf(4, 8, 6)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }

    @Test
    fun `extract column from diff widths matrix`() {
        val matrixAsString = """
            89 1903   3
            18    3   1
             9    4 800
            """.replace(Regex(" +"), " ").trimIndent()
        val columnIndex = 2
        val expectedColumn = listOf(1903, 3, 4)
        assertEquals(expectedColumn, Matrix(matrixAsString).column(columnIndex))
    }
}
