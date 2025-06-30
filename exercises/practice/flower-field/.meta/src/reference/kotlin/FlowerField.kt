import kotlin.math.max
import kotlin.math.min

private const val FLOWER_CHAR = '*'
private const val SPACE_CHAR = ' '

data class FlowerFieldBoard(val flowerLocations: List<String>) {

    private val numberOfRows by lazy {
        flowerLocations.size
    }

    private val numberOfColumns by lazy {
        if (flowerLocations.isEmpty()) 0 else flowerLocations[0].length
    }

    fun withNumbers() = (0 until numberOfRows).map { getRowWithNumbers(it) }

    private fun getRowWithNumbers(rowNumber: Int) =
            (0 until numberOfColumns)
                    .map { columnNumber -> getCellNumber(rowNumber, columnNumber) }
                    .joinToString("")

    private fun getCellNumber(rowNumber: Int, columnNumber: Int): Char {
        // If (rowNumber, columnNumber) is a flower, we're done.
        if (flowerLocations[rowNumber][columnNumber] == FLOWER_CHAR) {
            return FLOWER_CHAR
        }

        val flowerCount = computeFlowerCountAround(rowNumber, columnNumber)

        // If computed count is positive, add it to the annotated row. Otherwise, add a blank space.
        return if (flowerCount > 0) Character.forDigit(flowerCount, 10) else SPACE_CHAR
    }

    private fun computeFlowerCountAround(rowNumber: Int, columnNumber: Int): Int {
        var result = 0

        // Compute row and column ranges to inspect (respecting board edges).
        val minRowToInspect = max(rowNumber - 1, 0)
        val maxRowToInspect = min(rowNumber + 1, numberOfRows - 1)
        val minColToInspect = max(columnNumber - 1, 0)
        val maxColToInspect = min(columnNumber + 1, numberOfColumns - 1)

        // Count flowerss in the cells surrounding (row, col).
        for (rowToInspect in minRowToInspect..maxRowToInspect) {
            for (colToInspect in minColToInspect..maxColToInspect) {
                if (flowerLocations[rowToInspect][colToInspect] == FLOWER_CHAR) {
                    result += 1
                }
            }
        }

        return result
    }

}
