import org.junit.Test
import kotlin.test.assertEquals

class ETLTest {

    @Test
    fun transformOneValue() {
        val old = mapOf(1 to listOf("WORLD"))
        val expected = mapOf("world" to 1)

        assertEquals(expected, ETL.transform(old))
    }

    @Test
    fun transformMoreValues() {
        val old = mapOf(1 to listOf("WORLD", "GSCHOOLERS"))
        val expected = mapOf("world" to 1, "gschoolers" to 1)

        assertEquals(expected, ETL.transform(old))
    }

    @Test
    fun moreKeys() {
        val old = mapOf(1 to listOf("APPLE", "ARTICHOKE"), 2 to listOf("BOAT", "BALLERINA"))
        val expected = mapOf("apple" to 1, "artichoke" to 1, "boat" to 2, "ballerina" to 2)

        assertEquals(expected, ETL.transform(old))
    }

    @Test
    fun fullDataset() {
        val old = mapOf(
                1 to listOf("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"),
                2 to listOf("D", "G"),
                3 to listOf("B", "C", "M", "P"),
                4 to listOf("F", "H", "V", "W", "Y"),
                5 to listOf("K"),
                8 to listOf("J", "X"),
                10 to listOf("Q", "Z")
        )
        val expected = mapOf(
                "a" to 1, "b" to 3, "c" to 3, "d" to 2, "e" to 1,
                "f" to 4, "g" to 2, "h" to 4, "i" to 1, "j" to 8,
                "k" to 5, "l" to 1, "m" to 3, "n" to 1, "o" to 1,
                "p" to 3, "q" to 10, "r" to 1, "s" to 1, "t" to 1,
                "u" to 1, "v" to 4, "w" to 4, "x" to 8, "y" to 4,
                "z" to 10
        )

        assertEquals(expected, ETL.transform(old))
    }
}
