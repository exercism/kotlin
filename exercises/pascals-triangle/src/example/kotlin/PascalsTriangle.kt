object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        require(rows >= 0, { "Rows can't be negative!" })

        if (rows == 0) return emptyList()
        return (1..rows).map { row -> triRow(row) }
    }

    private fun triRow(row: Int): List<Int> {
        var m = 1
        return listOf(1) + (1..row - 1).map { j ->
            m = m * (row - j) / j
            return@map m
        }
    }
}
