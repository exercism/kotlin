import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(OrderAnnotation::class)
class ReverseStringTest {

    @Test
    @Order(0)
    fun testAnEmptyString() {
        assertEquals("", reverse(""))
    }

    @Test
    @Order(1)
    fun testAWord() {
        assertEquals("tobor", reverse("robot"))
    }

    @Test
    @Order(2)
    fun testACapitalizedWord() {
        assertEquals("nemaR", reverse("Ramen"))
    }

    @Test
    @Order(3)
    fun testASentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", reverse("I'm hungry!"))
    }

    @Test
    @Order(4)
    fun testAPalindrome() {
        assertEquals("racecar", reverse("racecar"))
    }
}
