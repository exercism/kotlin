class BaseConverter(originalBase: Int, originalDigits: IntArray) {

    companion object {
        private val MINIMUM_VALID_BASE = 2
        private val INVALID_BASE_ERROR_MESSAGE = "Bases must be at least 2."
    }

    private val numeral: Int

    init {
        validateInputs(originalBase, originalDigits)
        this.numeral = computeNumeral(originalBase, originalDigits)
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < MINIMUM_VALID_BASE) throw IllegalArgumentException(INVALID_BASE_ERROR_MESSAGE)

        val largestExponent = computeLargestExponentForBase(newBase)
        val result = IntArray(largestExponent + 1)
        var remainder = numeral

        for (currentExponent in largestExponent downTo 0) {
            val coefficient = Math.floor(remainder / Math.pow(newBase.toDouble(), currentExponent.toDouble())).toInt()

            result[largestExponent - currentExponent] = coefficient

            remainder -= (coefficient * Math.pow(newBase.toDouble(), currentExponent.toDouble())).toInt()
        }

        return result
    }

    private fun validateInputs(originalBase: Int, originalDigits: IntArray) {
        if (originalBase < MINIMUM_VALID_BASE) {
            throw IllegalArgumentException(INVALID_BASE_ERROR_MESSAGE)
        }

        if (originalDigits.isEmpty()) {
            throw IllegalArgumentException("You must supply at least one digit.")
        }

        if (originalDigits.size > 1 && originalDigits[0] == 0) {
            throw IllegalArgumentException("Digits may not contain leading zeros.")
        }

        if (originalDigits.min()!! < 0) {
            throw IllegalArgumentException("Digits may not be negative.")
        }

        if (originalDigits.max()!! >= originalBase) {
            throw IllegalArgumentException("All digits must be strictly less than the base.")
        }
    }

    private fun computeNumeral(originalBase: Int, originalDigits: IntArray): Int {
        val largestExponent = originalDigits.size - 1

        val result = (largestExponent downTo 0).sumBy { exponent ->
            (originalDigits[largestExponent - exponent]
                * Math.pow(originalBase.toDouble(), exponent.toDouble())).toInt()
        }

        return result
    }

    private fun computeLargestExponentForBase(newBase: Int): Int {
        var result = 0

        while (Math.pow(newBase.toDouble(), (result + 1).toDouble()) < numeral) {
            result += 1
        }

        return result
    }

}
