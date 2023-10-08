class Matrix(private val matrixAsString: String) {

    private val matrix = matrixAsString.split("\n")
        .withIndex()
        .mapNotNull { indexedRow ->
            indexedRow.value.split(" ")
                .map { it.toInt() }
                .takeIf { it.isNotEmpty() }
                ?.let { it[0] to it }
        }

    fun column(colNr: Int) = matrix.map { it.second }
        .mapNotNull { it.getOrNull(colNr - 1) }

    fun row(rowNr: Int) = matrix.getOrNull(rowNr - 1)
        ?.second
        ?: emptyList()
}
