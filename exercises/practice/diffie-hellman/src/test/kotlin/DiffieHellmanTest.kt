import org.junit.Test
import java.math.BigInteger
import kotlin.test.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DiffieHellmanTest {

    @Test
    fun `private key is in range from 1 to prime`() {
        val prime = 23.toBigInteger()
        (0..9).map { DiffieHellman.privateKey(prime) }.forEach {
            assertTrue(it >= BigInteger.ONE)
            assertTrue(it < prime)
        }
    }

    /**
     * Due to the nature of randomness, there is always a chance that this test fails.
     * Be sure to check the actual generated values.
     */
    @Ignore
    @Test
    fun `private key is random`() {
        val prime = 7919.toBigInteger()
        val privateKeyA = DiffieHellman.privateKey(prime)
        val privateKeyB = DiffieHellman.privateKey(prime)

        assertNotEquals(privateKeyA, privateKeyB)
    }

    @Ignore
    @Test
    fun `calculate public key using private key`() {
        val primeA = 23.toBigInteger()
        val primeB = 5.toBigInteger()
        val privateKey = 6.toBigInteger()
        val expected = 8.toBigInteger()

        assertEquals(expected, DiffieHellman.publicKey(primeA, primeB, privateKey))
    }


    @Ignore
    @Test
    fun `calculate secret using other party's public key`() {
        val prime = 23.toBigInteger()
        val publicKey = 19.toBigInteger()
        val privateKey = 6.toBigInteger()
        val expected = 2.toBigInteger()

        assertEquals(expected, DiffieHellman.secret(prime, publicKey, privateKey))
    }


    @Ignore
    @Test
    fun `key exchange`() {
        val primeA = 23.toBigInteger()
        val primeB = 5.toBigInteger()

        val alicePrivateKey = DiffieHellman.privateKey(primeA)
        val bobPrivateKey = DiffieHellman.privateKey(primeB)

        val alicePublicKey = DiffieHellman.publicKey(primeA, primeB, alicePrivateKey)
        val bobPublicKey = DiffieHellman.publicKey(primeA, primeB, bobPrivateKey)

        val secretA = DiffieHellman.secret(primeA, bobPublicKey, alicePrivateKey)
        val secretB = DiffieHellman.secret(primeA, alicePublicKey, bobPrivateKey)

        assertEquals(secretA, secretB)
    }

}
