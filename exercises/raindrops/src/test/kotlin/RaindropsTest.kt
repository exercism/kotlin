import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class RaindropsTest(val input: Int, val expectedOutput: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: raindrops({0})={1}")
        fun data() = listOf(
                // Non-primes
                arrayOf(1, "1"),
                arrayOf(52, "52"),
                arrayOf(12121, "12121"),

                // Numbers with 3 as a prime factor
                arrayOf(3, "Pling"),
                arrayOf(6, "Pling"),
                arrayOf(9, "Pling"),

                // Numbers with 5 as a prime factor
                arrayOf(5, "Plang"),
                arrayOf(10, "Plang"),
                arrayOf(25, "Plang"),

                // Numbers with 7 as a prime factor
                arrayOf(7, "Plong"),
                arrayOf(14, "Plong"),
                arrayOf(49, "Plong"),

                // Numbers with multiple activating prime factors
                arrayOf(15, "PlingPlang"),
                arrayOf(21, "PlingPlong"),
                arrayOf(35, "PlangPlong"),
                arrayOf(105, "PlingPlangPlong")
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, Raindrops.convert(input))
    }
}
