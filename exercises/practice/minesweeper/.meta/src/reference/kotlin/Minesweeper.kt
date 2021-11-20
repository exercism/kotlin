import kotlin.math.max
import kotlin.math.min

private const val MINE_CHAR = '*'
private const val SPACE_CHAR = ' '

data class MinesweeperBoard(val mineLocations: List<String>) {

    private val numberOfRows by lazy {
        mineLocations.size
    }

    private val numberOfColumns by lazy {
        if (mineLocations.isEmpty()) 0 else mineLocations[0].length
    }

    fun withNumbers() = (0 until numberOfRows).map { getRowWithNumbers(it) }

    private fun getRowWithNumbers(rowNumber: Int) =
            (0 until numberOfColumns)
                    .map { columnNumber -> getCellNumber(rowNumber, columnNumber) }
                    .joinToString("")

    private fun getCellNumber(rowNumber: Int, columnNumber: Int): Char {
        // If (rowNumber, columnNumber) is a mine, we're done.
        if (mineLocations[rowNumber][columnNumber] == MINE_CHAR) {
            return MINE_CHAR
        }

        val mineCount = computeMineCountAround(rowNumber, columnNumber)

        // If computed count is positive, add it to the annotated row. Otherwise, add a blank space.
        return if (mineCount > 0) Character.forDigit(mineCount, 10) else SPACE_CHAR
    }

    private fun computeMineCountAround(rowNumber: Int, columnNumber: Int): Int {
        var result = 0

        // Compute row and column ranges to inspect (respecting board edges).
        val minRowToInspect = max(rowNumber - 1, 0)
        val maxRowToInspect = min(rowNumber + 1, numberOfRows - 1)
        val minColToInspect = max(columnNumber - 1, 0)
        val maxColToInspect = min(columnNumber + 1, numberOfColumns - 1)

        // Count mines in the cells surrounding (row, col).
        for (rowToInspect in minRowToInspect..maxRowToInspect) {
            for (colToInspect in minColToInspect..maxColToInspect) {
                if (mineLocations[rowToInspect][colToInspect] == MINE_CHAR) {
                    result += 1
                }
            }
        }

        return result
    }

}
