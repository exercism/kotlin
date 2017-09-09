data class Matrix(val entries: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate> by lazy {
        val result = mutableSetOf<MatrixCoordinate>()

        if (entries.isNotEmpty()) {
            for (row in 0 until entries.size) {
                for (col in 0 until entries[0].size) {
                    val coordinateValue = entries[row][col]

                    if (coordinateValue == getRowMax(row) && coordinateValue == getColumnMin(col)) {
                        result.add(MatrixCoordinate(row, col))
                    }
                }
            }
        }

        result
    }

    private fun getRowMax(row: Int): Int {
        return entries[row].max() ?: 0
    }

    private fun getColumnMin(col: Int): Int {
        return entries
            .map { row -> row[col] }
            .min() ?: 0
    }

}
