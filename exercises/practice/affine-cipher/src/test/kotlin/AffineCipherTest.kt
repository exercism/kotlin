import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AffineCipherTest {

    @Test
    fun `encode yes`() = assertEquals("xbt", AffineCipher.encode("yes", 5, 7))

    @Test
    fun `encode no`() = assertEquals("fu", AffineCipher.encode("no", 15, 18))

    @Test
    fun `encode OMG`() = assertEquals("lvz", AffineCipher.encode("OMG", 21, 3))

    @Test
    fun `encode O M G`() = assertEquals("hjp", AffineCipher.encode("O M G", 25, 47))

    @Test
    fun `encode mindblowingly`() = assertEquals("rzcwa gnxzc dgt", AffineCipher.encode("mindblowingly", 11, 15))

    @Test
    fun `encode numbers`() = assertEquals("jqgjc rw123 jqgjc rw", AffineCipher.encode("Testing,1 2 3, testing.", 3, 4))

    @Test
    fun `encode deep thought`() = assertEquals("iynia fdqfb ifje", AffineCipher.encode("Truth is fiction.", 5, 17))

    @Test
    fun `encode all letters`() = assertEquals("swxtj npvyk lruol iejdc blaxk swxmh qzglf", AffineCipher.encode("The quick brown fox jumps over the lazy dog.", 17, 33))

    @Test
    fun `encode with a not coprime to m`() {
        assertFailsWith<IllegalArgumentException>("a and m must be coprime.") {
            AffineCipher.encode("This is a test.", 6, 17)
        }
    }

    @Test
    fun `decode exercism`() = assertEquals("exercism", AffineCipher.decode("tytgn fjr", 3, 7))

    @Test
    fun `decode a sentence`() = assertEquals("anobstacleisoftenasteppingstone", AffineCipher.decode("qdwju nqcro muwhn odqun oppmd aunwd o", 19, 16))

    @Test
    fun `decode numbers`() = assertEquals("testing123testing", AffineCipher.decode("odpoz ub123 odpoz ub", 25, 7))

    @Test
    fun `decode all the letters`() = assertEquals("thequickbrownfoxjumpsoverthelazydog", AffineCipher.decode("swxtj npvyk lruol iejdc blaxk swxmh qzglf", 17, 33))

    @Test
    fun `decode with no spaces in input`() = assertEquals("thequickbrownfoxjumpsoverthelazydog", AffineCipher.decode("swxtjnpvyklruoliejdcblaxkswxmhqzglf", 17, 33))

    @Test
    fun `decode with too many spaces`() = assertEquals("jollygreengiant", AffineCipher.decode("vszzm    cly   yd cg    qdp", 15, 16))

    @Test
    fun `decode with a not coprime to m`() {
        assertFailsWith<IllegalArgumentException>("a and m must be coprime.") {
            AffineCipher.decode("Test", 13, 5)
        }
    }
}
