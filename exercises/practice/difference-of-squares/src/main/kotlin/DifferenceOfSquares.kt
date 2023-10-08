class Squares(val square: Int) {

    fun sumOfSquares() = (1..square)
        .map { it * it }
        .sum()

    fun squareOfSum() = (1..square)
        .sum()
        .let { it * it }

    fun difference() = squareOfSum() - sumOfSquares()
}