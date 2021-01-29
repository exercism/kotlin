class Matrix(private val matrixAsString: String) {

    private val matrix: List<List<Int>> = matrixAsString
            .split("\n")
            .map { column ->
                column.trim().split(Regex(" +"))
                        .map { cell -> cell.toInt() }
            }

    fun column(colNr: Int): List<Int> = matrix.indices.map { matrix[it][colNr - 1] }

    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]
}
