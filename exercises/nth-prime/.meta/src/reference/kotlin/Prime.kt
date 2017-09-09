import java.math.BigInteger

object Prime {

    fun nth(n: Int): Int = primes().drop(n - 1).first().toInt()

    fun primes(): Sequence<BigInteger> = generateSequence(BigInteger.valueOf(2)) { previous ->
        previous.nextProbablePrime()
    }
}
