import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test

class ScrabbleScoreTest() {

    @Test
    fun `lowercase letter`() {
        assertEquals(1, ScrabbleScore.scoreWord("a"))
    }

    @Ignore
    @Test
    fun `uppercase letter`() {
        assertEquals(1, ScrabbleScore.scoreWord("A"))
    }

    @Ignore
    @Test
    fun `valuable letter`() {
        assertEquals(4, ScrabbleScore.scoreWord("f"))
    }

    @Ignore
    @Test
    fun `short word`() {
        assertEquals(2, ScrabbleScore.scoreWord("at"))
    }

    @Ignore
    @Test
    fun `short, valuable word`() {
        assertEquals(12, ScrabbleScore.scoreWord("zoo"))
    }

    @Ignore
    @Test
    fun `medium word`() {
        assertEquals(6, ScrabbleScore.scoreWord("street"))
    }

    @Ignore
    @Test
    fun `medium, valuable word`() {
        assertEquals(22, ScrabbleScore.scoreWord("quirky"))
    }

    @Ignore
    @Test
    fun `long, mixed-case word`() {
        assertEquals(41, ScrabbleScore.scoreWord("OxyphenButazone"))
    }

    @Ignore
    @Test
    fun `english-like word`() {
        assertEquals(8, ScrabbleScore.scoreWord("pinata"))
    }

    @Ignore
    @Test
    fun `empty input`() {
        assertEquals(0, ScrabbleScore.scoreWord(""))
    }

    @Ignore
    @Test
    fun `entire alphabet available`() {
        assertEquals(87, ScrabbleScore.scoreWord("abcdefghijklmnopqrstuvwxyz"))
    }
}