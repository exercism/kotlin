data class Matrix(val entries: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate> by lazy {
        val result = mutableSetOf<MatrixCoordinate>()

        if (entries.isNotEmpty()) {
            for (row in entries.indices) {
                for (col in entries[0].indices) {
                    val coordinateValue = entries[row][col]
                    if (coordinateValue == getRowMax(row) && coordinateValue == getColumnMin(col)) {
                        result.add(MatrixCoordinate(row + 1, col + 1))
                    }
                }
            }
        }

        result
    }

    private fun getRowMax(row: Int): Int {
        return entries[row].maxOrNull() ?: 0
    }

    private fun getColumnMin(col: Int): Int {
        return entries
            .map { row -> row[col] }
            .minOrNull() ?: 0
    }

}
