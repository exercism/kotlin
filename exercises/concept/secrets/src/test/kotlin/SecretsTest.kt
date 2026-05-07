import kotlin.test.Test
import kotlin.test.assertEquals

class SecretsTest {

    @Test
    fun shift8Back2Places() {
        assertEquals(2, shiftBack(8, 2))
    }

    @Test
    fun shiftNegativeNumberBack3Places() {
        assertEquals(268_829_204, shiftBack(-2_144_333_657, 3))
    }

    @Test
    fun setBitsIn5() {
        assertEquals(7, setBits(5, 3))
    }

    @Test
    fun setBitsIn5652() {
        assertEquals(30_262, setBits(5_652, 26_150))
    }

    @Test
    fun flipBitsIn5() {
        assertEquals(14, flipBits(5, 11))
    }

    @Test
    fun flipBitsIn38460() {
        assertEquals(43_603, flipBits(38_460, 15_471))
    }

    @Test
    fun clearBitsFrom5() {
        assertEquals(4,clearBits(5, 11))
    }

    @Test
    fun clearBitsFrom90() {
        assertEquals(10, clearBits(90, 240))
    }
}
