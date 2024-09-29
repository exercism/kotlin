import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class EliudsEggsTest {

    @Test
    fun `0 eggs`() = assertEquals(0, EliudsEggs.eggCount(0))

    @Ignore
    @Test
    fun `1 egg`() = assertEquals(1, EliudsEggs.eggCount(16))

    @Ignore
    @Test
    fun `4 eggs`() = assertEquals(4, EliudsEggs.eggCount(89))

    @Ignore
    @Test
    fun `13 eggs`() = assertEquals(13, EliudsEggs.eggCount(2_000_000_000))
}
