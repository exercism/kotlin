fun Int.squared() = Math.pow(this.toDouble(), 2.0).toInt()

class Squares(private val max: Int) {
    fun sumOfSquares() = (1..max).map { it.squared() }.sum()

    fun squareOfSum() = (1..max).sum().squared()

    fun difference() = squareOfSum() - sumOfSquares()
}
