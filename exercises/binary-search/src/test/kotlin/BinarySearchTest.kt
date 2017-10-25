import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTest {

    @Test
    fun findsTheItemInASingleElementList() {
        assertEquals(0, BinarySearch.search(listOf(6), 6))
    }

    @Ignore
    @Test
    fun findsTheItemInTheMiddleOfAList() {
        assertEquals(3, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 6))
    }

    @Ignore
    @Test
    fun findsTheItemAtTheBeginningOfAList() {
        assertEquals(0, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 1))
    }

    @Ignore
    @Test
    fun findsTheItemAtTheEndOfAList() {
        assertEquals(6, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 11))
    }

    @Ignore
    @Test
    fun findsValueInAListOfOddLength() {
        assertEquals(9, BinarySearch.search(listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634), 144))
    }

    @Ignore
    @Test
    fun findsValueInAListOfEvenLength() {
        assertEquals(5, BinarySearch.search(listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377), 21))
    }

    @Ignore
    @Test
    fun identifiesThatAValueIsNotInTheList() {
        assertEquals(-1, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 7))
    }

    @Ignore
    @Test
    fun identifiesThatAValueSmallerThanTheSmallestListElementIsNotInTheList() {
        assertEquals(-1, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 0))
    }

    @Ignore
    @Test
    fun identifiesThatAValueLargerThanTheLargestListElementIsNotInTheList() {
        assertEquals(-1, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 13))
    }

    @Ignore
    @Test
    fun identifiesThatNothingCanBeFoundInAnEmptyList() {
        assertEquals(-1, BinarySearch.search(emptyList(), 1))
    }

}
