import org.junit.Ignore
import org.junit.Test
import org.junit.Assert.assertEquals


class TwoferTest {

    @Test
    fun aNameGiven() {
        assertEquals("One for Alice, one for me.", twofer("Alice"))
    }

    @Test
    @Ignore
    fun anotherNameGiven() {
        assertEquals("One for Bob, one for me.", twofer("Bob"))
    }

    @Test
    @Ignore
    fun emptyStringGiven() {
        assertEquals("One for you, one for me.", twofer(""))
    }
}
