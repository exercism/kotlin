class Squares(private val max: Int) {
    private val range = 1..max

    fun sumOfSquares() = range.map { it.squared() }.sum()
    fun squareOfSum() = range.sum().squared()
    fun difference() = squareOfSum() - sumOfSquares()

    private fun Int.squared() = this * this
}
