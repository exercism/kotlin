import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class BinaryTest(val input: String, val expectedOutput: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: binary({0})={1}")
        fun data() = listOf(
                arrayOf("1", 1),
                arrayOf("10", 2),
                arrayOf("11", 3),
                arrayOf("100", 4),
                arrayOf("1001", 9),
                arrayOf("11010", 26),
                arrayOf("10001101000", 1128),
                arrayOf("2", 0),
                arrayOf("5", 0),
                arrayOf("9", 0),
                arrayOf("134678", 0),
                arrayOf("abc10z", 0),
                arrayOf("011", 3),
                arrayOf("g1", 0)
        )
    }


    @Test
    fun binaryStringToInt() {
        assertEquals(expectedOutput, Binary.toDecimal(input))
    }
}
