
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class BinarySearchTest {


    @Test(expected = IllegalArgumentException::class)
    fun unsortedListCannotBeSearched() {
        BinarySearch.search(listOf(1, 2, 4, 3), 1)
    }

    @Ignore
    @Test
    fun shouldReturnMinus1ForAValueNotPresentInTheList() {
        assertEquals(-1, BinarySearch.search(listOf(1, 2, 3, 4), 5))
    }

    @Ignore
    @Test
    fun shouldFindTheItemInASingleElementList() {
        assertEquals(0, BinarySearch.search(listOf(3), 3))
    }

    @Ignore
    @Test
    fun shouldFindTheFirstItemInATwoElementList() {
        assertEquals(0, BinarySearch.search(listOf(4, 11), 4))
    }

    @Ignore
    @Test
    fun shouldFindTheLastItemInATwoElementList() {
        assertEquals(1, BinarySearch.search(listOf(4, 11), 11))
    }

    @Ignore
    @Test
    fun shouldFindTheMidItemInAnOddLengthList() {
        assertEquals(2, BinarySearch.search(listOf(4, 4, 7, 9, 11), 7))
    }

    @Ignore
    @Test
    fun shouldFindThePreMidItemInAnEvenLengthList() {
        assertEquals(1, BinarySearch.search(listOf(4, 5, 9, 11), 5))
    }

    @Ignore
    @Test
    fun shouldFindThePostMidItemInAnEvenLengthList() {
        assertEquals(2, BinarySearch.search(listOf(4, 5, 17, 29), 17))
    }
}
