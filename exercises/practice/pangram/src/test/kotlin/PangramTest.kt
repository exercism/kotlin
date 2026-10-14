import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PangramTest {

    @Test
    fun `empty sentence`() {
        assertFalse(Pangram.isPangram(""))
    }

    @Ignore
    @Test
    fun `perfect lower case`() {
        assertTrue(Pangram.isPangram("abcdefghijklmnopqrstuvwxyz"))
    }

    @Ignore
    @Test
    fun `only lower case`() {
        assertTrue(Pangram.isPangram("the quick brown fox jumps over the lazy dog"))
    }

    @Ignore
    @Test
    fun `missing the letter 'x'`() {
        assertFalse(Pangram.isPangram("a quick movement of the enemy will jeopardize five gunboats"))
    }

    @Ignore
    @Test
    fun `missing the letter 'h'`() {
        assertFalse(Pangram.isPangram("five boxing wizards jump quickly at it"))
    }

    @Ignore
    @Test
    fun `with underscores`() {
        assertTrue(Pangram.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"))
    }

    @Ignore
    @Test
    fun `with numbers`() {
        assertTrue(Pangram.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"))
    }

    @Ignore
    @Test
    fun `missing letters replaced by numbers`() {
        assertFalse(Pangram.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"))
    }

    @Ignore
    @Test
    fun `mixed case and punctuation`() {
        assertTrue(Pangram.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""))
    }

    @Ignore
    @Test
    fun `a-m and A-M are 26 different characters but not a pangram`() {
        assertFalse(Pangram.isPangram("abcdefghijklm ABCDEFGHIJKLM"))
    }

}
