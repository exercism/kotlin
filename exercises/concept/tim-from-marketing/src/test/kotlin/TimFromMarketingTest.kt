import org.junit.Test
import kotlin.test.assertEquals

class TimFromMarketingTest {
    @Test
    fun `print badge for an employee`() {
        assertEquals(
            "[17] - Ryder Herbert - MARKETING",
            printBadge(17, "Ryder Herbert", "Marketing")
        )
    }

    @Test
    fun `print badge for new employee`() {
        assertEquals(
            "Bogdan Rosario - MARKETING",
            printBadge(null, "Bogdan Rosario", "Marketing")
        )
    }

    @Test
    fun labelForOwner() {
        assertEquals(
            "[59] - Julie Sokato - OWNER",
            printBadge(59, "Julie Sokato", null)
        )
    }

    @Test
    fun labelForNewOwner() {
        assertEquals(
            "Amare Osei - OWNER",
            printBadge(null, "Amare Osei", null)
        )
    }
}