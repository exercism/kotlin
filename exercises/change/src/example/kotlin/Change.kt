class Change(private val coins: Set<Int>) {

    private val NO_COINS_INDICATOR = listOf(-1)

    private val coinsSortedAscending = coins.sorted()

    val RESULTS_CACHE = mutableMapOf<Pair<Int, Int>, List<Int>>()

    fun issue(target: Int): List<Int> {
        require(target >= 0)

        if(0 == target) {
            return listOf()
        }

        require(target >= coinsSortedAscending.first())

        return issueRec(target, coinsSortedAscending.size-1).sorted()
    }

    /**
     * This is a Recursive solution using Top-Down dynamic programming
     *
     * It is however a poorman's 'memoized' solution because the memoization
     * logic is scattered inside the function's body
     * (a truly memoized solution would have no reference to variables outside the function's body)
     *
     * Although memoization can easily be implemented in Kotlin
     * using Lambdas and Function References, the fact that the calls
     * in this algorithm are recursive, screws up the simple implementation
     *
     */

    private fun issueRec(target: Int, maxIndex: Int) : List<Int> {
        if(0 == target) {
            return listOf()
        }

        if((target < 0) || (maxIndex < 0)) {
            return NO_COINS_INDICATOR
        }

        val trimRightCoinResult = fromCacheOrCalculate(target, maxIndex-1)
        val largestCoinOfPass = coinsSortedAscending[maxIndex]
        val usingDiffResult = fromCacheOrCalculate(target- largestCoinOfPass, maxIndex)

        if(usingDiffResult.isNoCoinsResult()) {
            return trimRightCoinResult.safeResult()
        }
        else {
            val usingDiffResultWithLargestCoin = usingDiffResult + largestCoinOfPass
            if(trimRightCoinResult.isNoCoinsResult()) {
                return usingDiffResultWithLargestCoin
            }
            else {
                return if(usingDiffResultWithLargestCoin.size < trimRightCoinResult.size) usingDiffResultWithLargestCoin else trimRightCoinResult
            }
        }

    }

    private fun fromCacheOrCalculate(target: Int, maxIndex: Int) : List<Int> = RESULTS_CACHE.getOrPut(Pair(target, maxIndex)) {
        issueRec(target, maxIndex)
    }

    private fun List<Int>.isNoCoinsResult() = (this == NO_COINS_INDICATOR)

    private fun List<Int>.safeResult() = if(this.isNoCoinsResult()) listOf() else this

}
