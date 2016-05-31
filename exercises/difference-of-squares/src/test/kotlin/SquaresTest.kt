import org.junit.Test
import kotlin.test.assertEquals

class SquaresTest {

    @Test
    fun squareOfSum5() {
        assertEquals(225, Squares(5).squareOfSum())
    }

    @Test
    fun squareOfSum10() {
        assertEquals(3025, Squares(10).squareOfSum())
    }

    @Test
    fun squareOfSum100() {
        assertEquals(25502500, Squares(100).squareOfSum())
    }

    @Test
    fun sumOfSquares5() {
        assertEquals(55, Squares(5).sumOfSquares())
    }

    @Test
    fun sumOfSquares10() {
        assertEquals(385, Squares(10).sumOfSquares())
    }

    @Test
    fun sumOfSquares100() {
        assertEquals(338350, Squares(100).sumOfSquares())
    }

    @Test
    fun differenceOfSquares0() {
        assertEquals(0, Squares(0).difference())
    }

    @Test
    fun differenceOfSquares5() {
        assertEquals(170, Squares(5).difference())
    }

    @Test
    fun differenceOfSquares10() {
        assertEquals(2640, Squares(10).difference())
    }

    @Test
    fun differenceOfSquares100() {
        assertEquals(25164150, Squares(100).difference())
    }

    @Test
    fun consistentDifference() {
        assertEquals(Squares(0).difference(), Squares(0).difference())
    }

}