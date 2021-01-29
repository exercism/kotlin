object Luhn {

    fun isValid(candidate: String): Boolean =
            isValidCandidate(candidate) && checksum(number(candidate)) == 0

    private fun isValidCandidate(candidate: String): Boolean =
            candidate.filter(Char::isDigit).length > 1 &&
            candidate.all { it.isDigit() || Character.isSpaceChar(it) }

    private fun number(candidate: String) = candidate.filter(Char::isDigit).toLong()

    private fun checksum(number: Long) = addends(number).sum() % 10

    private fun addends(number: Long): List<Int> = digits(number).withIndex().reversed()
            .map { if (isOdd(it.index)) dbl(it.value) else it.value }

    private fun digits(n: Long): List<Int> = when (n) {
        0L -> emptyList()
        else -> listOf((n % 10).toInt()) + digits(n / 10)
    }

    private fun dbl(n: Int): Int {
        val dbled = n * 2
        return if (dbled > 9) dbled - 9 else dbled
    }

    private fun isOdd(i: Int) = i % 2 == 1

}
