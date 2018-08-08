import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ReverseStringTest {
    @Test
    fun testAnEmptyString() {
        assertEquals("", reverse(""))
    }

    @Ignore
    @Test
    fun testAWord() {
        assertEquals("tobor", reverse("robot"))
    }

    @Ignore
    @Test
    fun testACapitalizedWord() {
        assertEquals("nemaR", reverse("Ramen"))
    }

    @Ignore
    @Test
    fun testASentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", reverse("I'm hungry!"))
    }

    @Ignore
    @Test
    fun testAPalindrome() {
        assertEquals("racecar", reverse("racecar"))
    }

}