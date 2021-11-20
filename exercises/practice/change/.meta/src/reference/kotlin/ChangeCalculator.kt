class ChangeCalculator(coins: List<Int>) {

    private val sortedCoins = coins.sorted()

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        require(grandTotal >= 0) { "Negative totals are not allowed." }

        val minimalCoinsMap = mutableMapOf<Int, List<Int>?>()
        minimalCoinsMap[0] = ArrayList()

        for (total in 1..grandTotal) {
            val minimalCoins = sortedCoins
                .filter { it <= total }
                .mapNotNull { coin ->
                    val minimalRemainderCoins = minimalCoinsMap[total - coin]
                    if (minimalRemainderCoins != null) prepend(coin, minimalRemainderCoins) else null
                }.minByOrNull { it.size }

            minimalCoinsMap[total] = minimalCoins
        }

        return minimalCoinsMap[grandTotal] ?: throw IllegalArgumentException(
                "The total $grandTotal cannot be represented in the given currency.")
    }

    private fun prepend(integer: Int, integers: List<Int>): List<Int> {
        val result = mutableListOf<Int>()
        result.add(integer)
        result.addAll(integers)
        return result
    }

}
