import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PangramTest {


    @Test
    fun emptySentence() {
        assertFalse(Pangrams.isPangram(""))
    }

    @Ignore
    @Test
    fun lowercasePangram() {
        assertTrue(Pangrams.isPangram("the quick brown fox jumps over the lazy dog"))
    }

    @Ignore
    @Test
    fun missingCharacterX() {
        assertFalse(Pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats"))
    }

    @Ignore
    @Test
    fun anotherMissingCharacterX() {
        assertFalse(Pangrams.isPangram("the quick brown fish jumps over the lazy dog"))
    }

    @Ignore
    @Test
    fun withUnderscores() {
        assertTrue(Pangrams.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"))
    }

    @Ignore
    @Test
    fun withNumbers() {
        assertTrue(Pangrams.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"))
    }

    @Ignore
    @Test
    fun missingLettersReplacedByNumbers() {
        assertFalse(Pangrams.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"))
    }

    @Ignore
    @Test
    fun mixedCaseAndPunctuation() {
        assertTrue(Pangrams.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""))
    }
    
    @Ignore
    @Test
    fun mixedCaseDuplicatedCharacters() {
        assertFalse(Pangrams.isPangram("the quick brown fox jumps over the lazy FOX"))
    }

    @Ignore
    @Test
    fun nonAsciiCharacters() {
        assertTrue(Pangrams.isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich."))
    }

}
