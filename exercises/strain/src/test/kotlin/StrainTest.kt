import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class StrainTest {


    @Test
    fun emptyKeep() {
        val input = emptyList<Int>()
        val expectedOutput = emptyList<Int>()
        assertEquals(expectedOutput, Strain.keep(input, { it < 10 }))
    }

    @Ignore
    @Test
    fun keepEverything() {
        val input = listOf(1, 2, 3)
        val expectedOutput = listOf(1, 2, 3)
        assertEquals(expectedOutput, Strain.keep(input, { it < 10 }))
    }

    @Ignore
    @Test
    fun keepFirstAndLast() {
        val input = listOf(1, 2, 3)
        val expectedOutput = listOf(1, 3)
        assertEquals(expectedOutput, Strain.keep(input, { it % 2 != 0 }))
    }

    @Ignore
    @Test
    fun keepNeitherFirstNorLast() {
        val input = listOf(1, 2, 3, 4, 5)
        val expectedOutput = listOf(2, 4)
        assertEquals(expectedOutput, Strain.keep(input, { it % 2 == 0 }))
    }

    @Ignore
    @Test
    fun KeepStrings() {
        val words = "apple zebra banana zombies cherimoya zelot".split(" ")
        val expectedOutput = listOf("zebra", "zombies", "zelot")
        assertEquals(expectedOutput,
                Strain.keep(words, { it.startsWith("z") }))
    }

    @Ignore
    @Test
    fun keepArrays() {
        val actual = listOf(
                listOf(1, 2, 3),
                listOf(5, 5, 5),
                listOf(5, 1, 2),
                listOf(2, 1, 2),
                listOf(1, 5, 2),
                listOf(2, 2, 1),
                listOf(1, 2, 5))
        val expectedOutput = listOf(
                listOf(5, 5, 5),
                listOf(5, 1, 2),
                listOf(1, 5, 2),
                listOf(1, 2, 5))
        assertEquals(expectedOutput,
                Strain.keep(actual, { col -> col.contains(5) }))
    }

    @Ignore
    @Test
    fun emptyDiscard() {
        val input = emptyList<Int>()
        val expectedOutput = emptyList<Int>()
        assertEquals(expectedOutput, Strain.discard(input, { it < 10 }))
    }

    @Ignore
    @Test
    fun discardNothing() {
        val input = listOf(1, 2, 3)
        val expectedOutput = listOf(1, 2, 3)
        assertEquals(expectedOutput, Strain.discard(input, { it > 10 }))
    }

    @Ignore
    @Test
    fun discardFirstAndLast() {
        val input = listOf(1, 2, 3)
        val expectedOutput = listOf(2)
        assertEquals(expectedOutput, Strain.discard(input, { it % 2 != 0 }))

    }

    @Ignore
    @Test
    fun discardNeitherFirstNorLast() {
        val input = listOf(1, 2, 3, 4, 5)
        val expectedOutput = listOf(1, 3, 5)
        assertEquals(expectedOutput, Strain.discard(input, { it % 2 == 0 }))
    }

    @Ignore
    @Test
    fun discardStrings() {
        val words = "apple zebra banana zombies cherimoya zelot".split(" ")
        val expectedOutput = listOf("apple", "banana", "cherimoya")
        assertEquals(expectedOutput,
                Strain.discard(words, { it.startsWith("z") }))
    }

    @Ignore
    @Test
    fun discardArrays() {
        val actual = listOf(
                listOf(1, 2, 3),
                listOf(5, 5, 5),
                listOf(5, 1, 2),
                listOf(2, 1, 2),
                listOf(1, 5, 2),
                listOf(2, 2, 1),
                listOf(1, 2, 5))
        val expectedOutput = listOf(
                listOf(1, 2, 3),
                listOf(2, 1, 2),
                listOf(2, 2, 1))
        assertEquals(expectedOutput,
                Strain.discard(actual, { col -> col.contains(5) }))
    }
}
