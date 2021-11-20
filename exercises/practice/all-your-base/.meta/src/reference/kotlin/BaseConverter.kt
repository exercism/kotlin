import kotlin.math.floor
import kotlin.math.pow

class BaseConverter(originalBase: Int, originalDigits: IntArray) {

    companion object {
        private const val MINIMUM_VALID_BASE = 2
        private const val INVALID_BASE_ERROR_MESSAGE = "Bases must be at least 2."
    }

    private val numeral: Int

    init {
        require(originalBase >= MINIMUM_VALID_BASE) { INVALID_BASE_ERROR_MESSAGE }
        require(originalDigits.isNotEmpty()) { "You must supply at least one digit." }
        require(originalDigits.size == 1 || originalDigits[0] != 0) { "Digits may not contain leading zeros." }
        require(originalDigits.minOrNull()!! >= 0) { "Digits may not be negative." }
        require(originalDigits.maxOrNull()!! < originalBase) { "All digits must be strictly less than the base." }

        this.numeral = computeNumeral(originalBase, originalDigits)
    }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase >= MINIMUM_VALID_BASE) { INVALID_BASE_ERROR_MESSAGE }

        val largestExponent = computeLargestExponentForBase(newBase)
        val result = IntArray(largestExponent + 1)
        var remainder = numeral

        for (currentExponent in largestExponent downTo 0) {
            val coefficient = floor(remainder / newBase.toDouble().pow(currentExponent.toDouble())).toInt()

            result[largestExponent - currentExponent] = coefficient

            remainder -= (coefficient * newBase.toDouble().pow(currentExponent.toDouble())).toInt()
        }

        return result
    }

    private fun computeNumeral(originalBase: Int, originalDigits: IntArray): Int {
        val largestExponent = originalDigits.size - 1

        val result = (largestExponent downTo 0).sumOf { exponent ->
            (originalDigits[largestExponent - exponent]
                    * originalBase.toDouble().pow(exponent.toDouble())).toInt()
        }

        return result
    }

    private fun computeLargestExponentForBase(newBase: Int): Int {
        var result = 0

        while (newBase.toDouble().pow((result + 1).toDouble()) < numeral) {
            result += 1
        }

        return result
    }

}
