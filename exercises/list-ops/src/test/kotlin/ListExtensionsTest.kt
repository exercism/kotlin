import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

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
                listOf('1', '2', '3', '4'),
                emptyList<Char>().customAppend(listOf('1', '2', '3', '4')))
    }

    @Ignore
    @Test
    fun testAppendingNonEmptyListOnNonEmptyList() {
        assertEquals(
                listOf("1", "2", "2", "3", "4", "5"),
                listOf("1", "2").customAppend(listOf("2", "3", "4", "5")))
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
                listOf('1', '2', '3', '4', '5', '6'),
                listOf(listOf('1', '2'), listOf('3'), emptyList(), listOf('4', '5', '6')).customConcat())
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
        assertEquals(4, listOf("one", "two", "three", "four").customSize)
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
                emptyList<Int>().customFoldLeft(2.0, Double::times))
    }

    @Ignore
    @Test
    fun testFoldLeftWithDirectionIndependentOperationOnNonEmptyList() {
        assertEquals(
                15,
                listOf(1, 2, 3, 4).customFoldLeft(5, Int::plus))
    }

    @Ignore
    @Test
    fun testFoldLeftWithDirectionDependentOperationOnNonEmptyList() {
        assertEquals(
                0,
                listOf(2, 5).customFoldLeft(5, Int::div))
    }

    @Ignore
    @Test
    fun testFoldRightOnEmptyList() {
        assertEquals(
                2.0,
                emptyList<Double>().customFoldRight(2.0, Double::times))
    }

    @Ignore
    @Test
    fun testFoldRightWithDirectionIndependentOperationOnNonEmptyList() {
        assertEquals(
                15,
                listOf(1, 2, 3, 4).customFoldRight(5, Int::plus))
    }

    @Ignore
    @Test
    fun testFoldRightWithDirectionDependentOperationOnNonEmptyList() {
        assertEquals(
                2,
                listOf(2, 5).customFoldRight(5, Int::div))
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
                listOf('7', '5', '3', '1'),
                listOf('1', '3', '5', '7').customReverse())
    }

}
