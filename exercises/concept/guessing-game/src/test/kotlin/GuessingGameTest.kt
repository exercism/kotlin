import kotlin.test.Test
import kotlin.test.assertEquals

class GuessingGameTest {
    @Test
    fun `give hint for 42`() {
        assertEquals("Correct", reply(42, 1))
    }

    @Test
    fun `give hint for 41 on 5th guess`() {
        assertEquals("So close", reply(41, 5))
    }

    @Test
    fun `give hint for 43 on 5th guess`() {
        assertEquals("So close", reply(43, 5))
    }

    @Test
    fun `give hint for 40`() {
        assertEquals("Too low", reply(40, 1))
    }

    @Test
    fun `give hint for 1`() {
        assertEquals("Too low", reply(1, 1))
    }

    @Test
    fun `give hint for 44`() {
        assertEquals("Too high", reply(44, 1))
    }

    @Test
    fun `give hint for 100`() {
        assertEquals("Too high", reply(100, 1))
    }

    @Test
    fun `give hint for 41 on 6th guess`() {
        assertEquals("Try one higher", reply(41, 6))
    }

    @Test
    fun `give hint for 43 on 6th guess`() {
        assertEquals("Try one lower", reply(43, 6))
    }

}