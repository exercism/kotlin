import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class TwoFerTest {

    @Test
    fun noNameGiven() {
        assertEquals("One for you, one for me.", twofer())
    }

    @Ignore
    @Test
    fun aNameGiven() {
        assertEquals("One for Alice, one for me.", twofer("Alice"))
    }

    @Ignore
    @Test
    fun anotherNameGiven() {
        assertEquals("One for Bob, one for me.", twofer("Bob"))
    }

    @Ignore
    @Test
    fun emptyStringGiven() {
        assertEquals("One for , one for me.", twofer(""))
    }

}
