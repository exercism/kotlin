import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class HexadecimalTest(val input: String, val expectedOutput: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: binary({0})={1}")
        fun data() = listOf(
                arrayOf("1", 1),
                arrayOf("c", 12),
                arrayOf("10", 16),
                arrayOf("af", 175),
                arrayOf("AF", 175),
                arrayOf("100", 256),
                arrayOf("19ace", 105166),
                arrayOf("000000", 0),
                arrayOf("ffffff", 16777215),
                arrayOf("ffff00", 16776960),

                //Invalid input
                arrayOf("carrot1", 0),
                arrayOf("abc10z", 0),
                arrayOf("g1", 0)
        )
    }


    @Test
    fun hexStringToInt() {
        assertEquals(expectedOutput, Hexadecimal.toDecimal(input))
    }
}
