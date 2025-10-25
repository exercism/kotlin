import org.junit.Assert.assertEquals
import kotlin.test.Test

class SecretAgentTest() {
    val protectedSecret = protectSecret("UMBRA will fill everyone's sugar bowls with salt!", "P455w0rd")

    val minionFunction1 = { yourFunc : (Int, Int) -> Int ->
        "Password=${yourFunc(1, 3)}"
    }

    val minionFunction2 = { yourFunc : (Int, Int) -> Int ->
        "UMBRA's favourite number is ${yourFunc(7, 11)}"
    }

    @Test
    fun `id generator make id for day 1`() {
        val idGenerator = makeIdGenerator(1)
        assertEquals(29, idGenerator(4, 7))
    }

    @Test
    fun `id generator make id for day 4`() {
        val idGenerator = makeIdGenerator(4)
        assertEquals(22, idGenerator(3, 6))
    }

    @Test
    fun `protected secret returns secret with correct password`() {
        assertEquals("UMBRA will fill everyone's sugar bowls with salt!", protectedSecret("P455w0rd"))
    }

    @Test
    fun `protected secret returns fail message with incorrect password`() {
        assertEquals("Sorry. No hidden secrets here.", protectedSecret("password"))
    }

    @Test
    fun `get password for room 5`() {
        assertEquals("Password=20", getPassword(5, minionFunction1))
    }

    @Test
    fun `get password for room 17`() {
        assertEquals("Password=68", getPassword(17, minionFunction1))
    }

    @Test
    fun `get password for room 5 with second function`() {
        assertEquals("UMBRA's favourite number is 90", getPassword(5, minionFunction2))
    }

    @Test
    fun `get password for room 17 with second function`() {
        assertEquals("UMBRA's favourite number is 306", getPassword(17, minionFunction2))
    }
}