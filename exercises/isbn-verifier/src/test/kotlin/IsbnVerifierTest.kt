import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsbnVerifierTest {
    private var isbnVerifier: IsbnVerifier = IsbnVerifier()

    @Test
    fun validIsbnNumber() {
        assertTrue(isbnVerifier.isValid("3-598-21508-8"))
    }

    @Ignore
    @Test
    fun invalidIsbnCheckDigit() {
        assertFalse(isbnVerifier.isValid("3-598-21508-9"))
    }

    @Ignore
    @Test
    fun validIsbnNumberWithCheckDigitOfTen() {
        assertTrue(isbnVerifier.isValid("3-598-21507-X"))
    }

    @Ignore
    @Test
    fun checkDigitIsACharacterOtherThanX() {
        assertFalse(isbnVerifier.isValid("3-598-21507-A"))
    }

    @Ignore
    @Test
    fun invalidCharacterInIsbn() {
        assertFalse(isbnVerifier.isValid("3-598-P1581-X"))
    }

    @Ignore
    @Test
    fun xIsOnlyValidAsACheckDigit() {
        assertFalse(isbnVerifier.isValid("3-598-2X507-9"))
    }

    @Ignore
    @Test
    fun validIsbnWithoutSeparatingDashes() {
        assertTrue(isbnVerifier.isValid("3598215088"))
    }

    @Ignore
    @Test
    fun isbnWithoutSeparatingDashesAndXAsCheckDigit() {
        assertTrue(isbnVerifier.isValid("359821507X"))
    }

    @Ignore
    @Test
    fun isbnWithoutCheckDigitAndDashes() {
        assertFalse(isbnVerifier.isValid("359821507"))
    }

    @Ignore
    @Test
    fun tooLongIsbnAndNoDashes() {
        assertFalse(isbnVerifier.isValid("3598215078X"))
    }

    @Ignore
    @Test
    fun isbnWithoutCheckDigit() {
        assertFalse(isbnVerifier.isValid("3-598-21507"))
    }

    @Ignore
    @Test
    fun tooLongIsbn() {
        assertFalse(isbnVerifier.isValid("3-598-21507-XX"))
    }

    @Ignore
    @Test
    fun checkDigitOfXShouldNotBeUsedForZero() {
        assertFalse(isbnVerifier.isValid("3-598-21515-X"))
    }

    @Ignore
    @Test
    fun emptyIsbn() {
        assertFalse(isbnVerifier.isValid(""))
    }

    @Ignore
    @Test
    fun inputIsNineCharacters() {
        assertFalse(isbnVerifier.isValid("134456729"))
    }

    @Ignore
    @Test
    fun invalidCharactersAreNotIgnored() {
        assertFalse(isbnVerifier.isValid("3132P34035"))
    }
}