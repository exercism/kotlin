import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

/*
 * version: 1.0.0
 */
class ListExtensionsTest {

    @Test
    fun testAppendingEmptyLists() {
        assertEquals(
                emptyList(),
                emptyList<Int>().customAppend(emptyList()))
    }

    @Ignore
    @Test
    fun testAppendingNonEmptyListOnEmptyList() {
        assertEquals(
                listOf(1, 2, 3, 4),
                emptyList<Int>().customAppend(listOf(1, 2, 3, 4)))
    }

    @Ignore
    @Test
    fun testAppendingNonEmptyListOnNonEmptyList() {
        assertEquals(
                listOf(1, 2, 2, 3, 4, 5),
                listOf(1, 2).customAppend(listOf(2, 3, 4, 5)))
    }

    @Ignore
    @Test
    fun testConcatOnEmptyListOfLists() {
        assertEquals(
                emptyList(),
                emptyList<List<Int>>().customConcat())
    }

    @Ignore
    @Test
    fun testConcatOnNonEmptyListOfLists() {
        assertEquals(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(listOf(1, 2), listOf(3), emptyList(), listOf(4, 5, 6)).customConcat())
    }

    @Ignore
    @Test
    fun testFilteringEmptyList() {
        assertEquals(
                emptyList(),
                emptyList<Int>().customFilter { it % 2 == 1 })
    }

    @Ignore
    @Test
    fun testFilteringNonEmptyList() {
        assertEquals(
                listOf(1, 3, 5),
                listOf(1, 2, 3, 5).customFilter { it % 2 == 1 })
    }

    @Ignore
    @Test
    fun testSizeOfEmptyList() {
        assertEquals(0, emptyList<Int>().customSize)
    }

    @Ignore
    @Test
    fun testSizeOfNonEmptyList() {
        assertEquals(4, listOf(1, 2, 3, 4).customSize)
    }

    @Ignore
    @Test
    fun testTransformingEmptyList() {
        assertEquals(
                emptyList(),
                emptyList<Int>().customMap { it -> it + 1 })
    }

    @Ignore
    @Test
    fun testTransformingNonEmptyList() {
        assertEquals(
                listOf(2, 4, 6, 8),
                listOf(1, 3, 5, 7).customMap { it -> it + 1 })
    }

    @Ignore
    @Test
    fun testFoldLeftOnEmptyList() {
        assertEquals(
                2.0,
                emptyList<Double>().customFoldLeft(2.0) { acc, current -> current / acc })
    }

    @Ignore
    @Test
    fun testFoldLeftOnNonEmptyList() {
        assertEquals(
                64.0,
                listOf(1.0, 2.0, 3.0, 4.0).customFoldLeft(24.0) { acc, current -> current / acc })
    }

    @Ignore
    @Test
    fun testFoldRightOnEmptyList() {
        assertEquals(
                2.0,
                emptyList<Double>().customFoldRight(2.0) { acc, current -> current / acc })
    }

    @Ignore
    @Test
    fun testFoldRightOnNonEmptyList() {
        assertEquals(
                9.0,
                listOf(1.0, 2.0, 3.0, 4.0).customFoldRight(24.0) { acc, current -> current / acc })
    }

    @Ignore
    @Test
    fun testReversingEmptyList() {
        assertEquals(
                emptyList(),
                emptyList<Int>().customReverse())
    }

    @Ignore
    @Test
    fun testReversingNonEmptyList() {
        assertEquals(
                listOf(7, 5, 3, 1),
                listOf(1, 3, 5, 7).customReverse())
    }

}
