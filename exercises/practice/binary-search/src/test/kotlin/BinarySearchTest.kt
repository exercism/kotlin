import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTest {

    @Test
    fun `finds value in array with one element`() =
            assertEquals(0, BinarySearch.search(listOf(6), 6))

    @Ignore
    @Test
    fun `finds value in the middle of array`() =
            assertEquals(3, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 6))


    @Ignore
    @Test
    fun `finds value at the beginning of array`() =
            assertEquals(0, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 1))

    @Ignore
    @Test
    fun `finds value at the end of array`() =
            assertEquals(6, BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 11))

    @Ignore
    @Test
    fun `finds value in array of odd length`() =
            assertEquals(9, BinarySearch.search(listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634), 144))

    @Ignore
    @Test
    fun `finds value in array of even length`() =
            assertEquals(5, BinarySearch.search(listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377), 21))

    @Ignore
    @Test(expected = NoSuchElementException::class)
    fun `identifies that value is not included in array`() {
        BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 7)
    }

    @Ignore
    @Test(expected = NoSuchElementException::class)
    fun `value smaller than array's smallest value is not found`() {
        BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 0)
    }

    @Ignore
    @Test(expected = NoSuchElementException::class)
    fun `value larger than array's largest value is not found`() {
        BinarySearch.search(listOf(1, 3, 4, 6, 8, 9, 11), 13)
    }

    @Ignore
    @Test(expected = NoSuchElementException::class)
    fun `nothing is found in empty array`() {
        BinarySearch.search(emptyList(), 1)
    }

    @Ignore
    @Test(expected = NoSuchElementException::class)
    fun `nothing is found when left and right bounds cross`() {
        BinarySearch.search(listOf(1, 2), 0)
    }

}
