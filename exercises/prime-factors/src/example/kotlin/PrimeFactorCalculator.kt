object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        return primeFactors(int.toLong()).map(Long::toInt)
    }

    fun primeFactors(long: Long): List<Long> {
        val result = mutableListOf<Long>()
        var remainder = long
        var divisor: Long = 2

        while (remainder > 1) {
            while (remainder.rem(divisor) == 0L) {
                result.add(divisor)
                remainder /= divisor
            }

            divisor++
        }

        return result
    }

}
