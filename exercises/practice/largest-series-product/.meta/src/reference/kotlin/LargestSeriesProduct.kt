import java.lang.Math.max

class Series(private val digits: String) {

    init {
        require(digits.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0)
        require(digits.length >= span)

        if(digits.isEmpty()) {
            return 1
        }

        return calculateRec(digits.map { it.intValue() }, span, 0)
    }

    private tailrec fun calculateRec(digits: List<Int>, span: Int, maxSoFar: Long): Long {
        val currentProduct = digits.subList(0, span).prod()
        val newMax = kotlin.math.max(currentProduct, maxSoFar)
        if(digits.size == span) { //since we won't be checking 'remainders' of the list, the end condition is simply when the size is the same as the span
            return newMax
        }

        return calculateRec(digits.tail(), span, newMax)
    }

}

fun Char.intValue() : Int  {
    if(!this.isDigit()) {
        throw IllegalArgumentException("Char ${this} is not a legal DEC character")
    }

    return this.intDiff('0')
}

fun Char.intDiff(other: Char) = this.code - other.code

fun List<Int>.prod() : Long = this.fold(1L) {productSoFar, item -> item*productSoFar}

fun <T> List<T>.tail() = this.subList(1, this.size)
