import org.junit.Test
import kotlin.test.assertEquals

class SeriesTest {

    @Test
    fun slicesOfOneFromOne() {
        assertEquals(
                listOf(listOf(1)),
                Series.slices(1, "1")
        )
    }

    @Test
    fun slicesOfOneFromTwo() {
        assertEquals(
                listOf(listOf(1), listOf(2)),
                Series.slices(1, "12")
        )
    }

    @Test
    fun slicesOfTwo() {
        assertEquals(
                listOf(listOf(3,5)),
                Series.slices(2, "35")
        )
    }

    @Test
    fun slicesOfTwoOverlap() {
        assertEquals(
                listOf(listOf(9,1), listOf(1,4), listOf(4,2)),
                Series.slices(2, "9142")
        )
    }

    @Test
    fun slicesCanIncludeDuplicates() {
        assertEquals(
                listOf(listOf(7,7,7), listOf(7,7,7), listOf(7,7,7), listOf(7,7,7)),
                Series.slices(3, "777777")
        )
    }

    @Test
    fun slicesOfALongSeries() {
        assertEquals(
                listOf(listOf(9,1,8,4,9),
                        listOf(1,8,4,9,3),
                        listOf(8,4,9,3,9),
                        listOf(4,9,3,9,0),
                        listOf(9,3,9,0,4),
                        listOf(3,9,0,4,2),
                        listOf(9,0,4,2,4),
                        listOf(0,4,2,4,3)),
                Series.slices(5, "918493904243")
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun sliceLengthIsTooLarge() {
        Series.slices(4, "123")
    }

    @Test(expected = IllegalArgumentException::class)
    fun sliceLengthCannotBeZero() {
        Series.slices(0, "123")
    }

    @Test(expected = IllegalArgumentException::class)
    fun sliceLengthCannotBeNegative() {
        Series.slices(-2, "123")
    }

    @Test(expected = IllegalArgumentException::class)
    fun emptySeriesIsInvalid() {
        Series.slices(1, "")
        Series.slices(1, "")
    }
}
