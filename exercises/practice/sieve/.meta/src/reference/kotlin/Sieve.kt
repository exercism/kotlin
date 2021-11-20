object Sieve {
    fun primesUpTo(upperBound: Int): List<Int> {
        val primes = mutableListOf<Int>()
        var candidates = (2..upperBound).toList()
        while (candidates.isNotEmpty()) {
            val prime = candidates[0]
            primes += prime
            candidates = candidates.filterIndexed { index, value -> index != 0 && value % prime != 0 }
        }

        return primes
    }
}
