data class Luhn(val number: Long) {

    val checkDigit: Int by lazy { checkDigit(number) }

    val addends: List<Int> by lazy {
        digits(number).withIndex().reversed()
                .map { if (isOdd(it.index)) dbl(it.value) else it.value }
    }

    val checksum: Int by lazy { addends.sum() }

    val isValid: Boolean by lazy { checksum % 10 == 0 }

    val create: Long by lazy {
        val zeroCheckDigitNumber = number * 10
        val luhn = Luhn(zeroCheckDigitNumber)

        if (luhn.isValid) zeroCheckDigitNumber else zeroCheckDigitNumber + (10 - luhn.checksum % 10)
    }

    companion object {
        private fun checkDigit(n: Long) = (n % 10).toInt()

        private fun digits(n: Long): List<Int> = when (n) {
            0L -> emptyList()
            else -> listOf(checkDigit(n)) + digits(n / 10)
        }

        private fun dbl(n: Int): Int {
            val dbled = n * 2
            return if (dbled > 10) dbled - 9 else dbled
        }

        private fun isOdd(i: Int) = i % 2 == 1
    }

}
