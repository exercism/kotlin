import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ReverseStringTest {
    @Test
    fun `empty string`() = assertEquals("", reverse(""))

    @Ignore
    @Test
    fun `single word`() = assertEquals("tobor", reverse("robot"))

    @Ignore
    @Test
    fun `capitalized word`() = assertEquals("nemaR", reverse("Ramen"))

    @Ignore
    @Test
    fun `sentence with punctuation`() = assertEquals("!yrgnuh m'I", reverse("I'm hungry!"))

    @Ignore
    @Test
    fun `palindrome word`() = assertEquals("racecar", reverse("racecar"))

    @Ignore
    @Test
    fun `even-sized word`() = assertEquals("reward", reverse("drawer"))

    @Ignore
    @Test
    fun `wide characters`() = assertEquals("猫子", reverse("子猫"))

    @Ignore
    @Test
    fun `grapheme clusters with pre-combined form`() = assertEquals("dnatsnehctsrüW", reverse("Würstchenstand"))

    @Ignore
    @Test
    fun `grapheme clusters`() = assertEquals("มรกแรปโนยขีเผู้", reverse("ผู้เขียนโปรแกรม"))

    @Ignore
    @Test
    fun `apply twice`() {
        val input = "input"
        assertEquals(input, reverse(reverse(input)))
    }
}
