import java.math.BigInteger
import java.util.Random

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        val rnd = Random()
        var bi: BigInteger
        do {
            bi = BigInteger(prime.bitCount(), rnd)
        } while (bi == BigInteger.ZERO || bi.compareTo(prime) == 1)
        return bi
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        return g.modPow(privKey, p)
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.modPow(privateKey, prime)
    }
}
