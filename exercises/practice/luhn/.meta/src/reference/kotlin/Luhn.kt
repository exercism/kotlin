object Luhn {
    fun isValid(number: String): Boolean {
        val digits = number.replace(" ", "")
        if (digits.length < 2 || digits.any { it !in '0'..'9' }) return false

        val checksum = digits
            .reversed()
            .withIndex()
            .sumOf { (index, char) ->
                val digit = char.digitToInt()
                if (index % 2 == 1) doubleDigit(digit) else digit
            }

        return checksum % 10 == 0
    }

    private fun doubleDigit(digit: Int): Int =
        (digit * 2).let { if (it > 9) it - 9 else it }
}
