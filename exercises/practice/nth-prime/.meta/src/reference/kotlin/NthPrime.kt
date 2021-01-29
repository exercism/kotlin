import java.math.BigInteger

object Prime {

    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }

        return primes().drop(n - 1).first().toInt()
    }

    private fun primes(): Sequence<BigInteger> = generateSequence(BigInteger.valueOf(2)) { previous ->
        previous.nextProbablePrime()
    }

}
