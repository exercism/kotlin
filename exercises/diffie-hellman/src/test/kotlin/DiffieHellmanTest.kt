import org.junit.Before
import org.junit.Test
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DiffieHellmanTest {

    private lateinit var diffieHellman: DiffieHellman

    @Before
    fun setUp() {
        diffieHellman = DiffieHellman()
    }

    @Test
    fun testPrivateKeyInRange() {
        val prime = 23.toBigInteger()
        (0..9).map { diffieHellman.privateKey(prime) }.forEach {
            assertTrue(it >= BigInteger.ONE )
            assertTrue(it < prime)
        }
    }

    // Note: due to the nature of randomness, there is always a chance that this test fails
    // Be sure to check the actual generated values

    @Test
    fun testPrivateKeyRandomlyGenerated() {
        val prime = BigInteger.valueOf(7919)
        val privateKeyA = diffieHellman.privateKey(prime)
        val privateKeyB = diffieHellman.privateKey(prime)

        assertNotEquals(privateKeyA, privateKeyB)
    }


    @Test
    fun testPublicKeyCorrectlyCalculated() {
        val primeA = BigInteger.valueOf(23)
        val primeB = BigInteger.valueOf(5)
        val privateKey = BigInteger.valueOf(6)
        val expected = BigInteger.valueOf(8)

        assertEquals(expected, diffieHellman.publicKey(primeA, primeB, privateKey))
    }


    @Test
    fun testSecretKeyCorrectlyCalculated() {
        val prime = BigInteger.valueOf(23)
        val publicKey = BigInteger.valueOf(19)
        val privateKey = BigInteger.valueOf(6)
        val expected = BigInteger.valueOf(2)

        assertEquals(expected, diffieHellman.secret(prime, publicKey, privateKey))
    }


    @Test
    fun testExchange() {
        val primeA = BigInteger.valueOf(23)
        val primeB = BigInteger.valueOf(5)

        val alicePrivateKey = diffieHellman.privateKey(primeA)
        val bobPrivateKey = diffieHellman.privateKey(primeB)

        val alicePublicKey = diffieHellman.publicKey(primeA, primeB, alicePrivateKey)
        val bobPublicKey = diffieHellman.publicKey(primeA, primeB, bobPrivateKey)

        val secretA = diffieHellman.secret(primeA, bobPublicKey, alicePrivateKey)
        val secretB = diffieHellman.secret(primeA, alicePublicKey, bobPrivateKey)

        assertEquals(secretA, secretB)
    }

}
