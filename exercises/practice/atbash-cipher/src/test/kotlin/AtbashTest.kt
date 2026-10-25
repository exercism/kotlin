import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test

class AtbashTest {

    @Test
    fun `encode yes`() {
        assertEquals("bvh", Atbash.encode("yes"))
    }

    @Ignore
    @Test
    fun `encode no`() {
        assertEquals("ml", Atbash.encode("no"))
    }

    @Ignore
    @Test
    fun `encode OMG`() {
        assertEquals("lnt", Atbash.encode("OMG"))
    }

    @Ignore
    @Test
    fun `encode spaces`() {
        assertEquals("lnt", Atbash.encode("O M G"))
    }

    @Ignore
    @Test
    fun `encode mindblowingly`() {
        assertEquals("nrmwy oldrm tob", Atbash.encode("mindblowingly"))
    }

    @Ignore
    @Test
    fun `encode numbers`() {
        assertEquals("gvhgr mt123 gvhgr mt", Atbash.encode("Testing,1 2 3, testing."))
    }

    @Ignore
    @Test
    fun `encode deep thought`() {
        assertEquals("gifgs rhurx grlm", Atbash.encode("Truth is fiction."))
    }

    @Ignore
    @Test
    fun `encode all the letters`() {
        assertEquals(
            "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt",
            Atbash.encode("The quick brown fox jumps over the lazy dog.")
        )
    }

    @Ignore
    @Test
    fun `decode exercism`() {
        assertEquals("exercism", Atbash.decode("vcvix rhn"))
    }

    @Ignore
    @Test
    fun `decode a sentence`() {
        assertEquals("anobstacleisoftenasteppingstone", Atbash.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"))
    }

    @Ignore
    @Test
    fun `decode numbers`() {
        assertEquals("testing123testing", Atbash.decode("gvhgr mt123 gvhgr mt"))
    }

    @Ignore
    @Test
    fun `decode all the letters`() {
        assertEquals("thequickbrownfoxjumpsoverthelazydog", Atbash.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"))
    }

    @Ignore
    @Test
    fun `decode with too many spaces`() {
        assertEquals("exercism", Atbash.decode("vc vix    r hn"))
    }

    @Ignore
    @Test
    fun `decode with no spaces`() {
        assertEquals("anobstacleisoftenasteppingstone", Atbash.decode("zmlyhgzxovrhlugvmzhgvkkrmthglmv"))
    }
}
