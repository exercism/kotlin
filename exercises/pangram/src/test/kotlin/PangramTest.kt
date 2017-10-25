import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PangramTest {

    @Test
    fun emptySentence() {
        assertFalse(Pangram.isPangram(""))
    }

    @Ignore
    @Test
    fun perfectLowercasePangram() {
        assertTrue(Pangram.isPangram("abcdefghijklmnopqrstuvwxyz"))
    }

    @Ignore
    @Test
    fun lowercasePangram() {
        assertTrue(Pangram.isPangram("the quick brown fox jumps over the lazy dog"))
    }

    @Ignore
    @Test
    fun missingCharacterX() {
        assertFalse(Pangram.isPangram("a quick movement of the enemy will jeopardize five gunboats"))
    }

    @Ignore
    @Test
    fun anotherMissingCharacterX() {
        assertFalse(Pangram.isPangram("five boxing wizards jump quickly at it"))
    }

    @Ignore
    @Test
    fun withUnderscores() {
        assertTrue(Pangram.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"))
    }

    @Ignore
    @Test
    fun withNumbers() {
        assertTrue(Pangram.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"))
    }

    @Ignore
    @Test
    fun missingLettersReplacedByNumbers() {
        assertFalse(Pangram.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"))
    }

    @Ignore
    @Test
    fun mixedCaseAndPunctuation() {
        assertTrue(Pangram.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""))
    }

    @Ignore
    @Test
    fun mixedCaseDuplicatedCharacters() {
        assertFalse(Pangram.isPangram("the quick brown fox jumps over with lazy FX"))
    }

}
