import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SquaresTest {

    @Test
    fun squareOfSum1() {
        assertEquals(1, Squares(1).squareOfSum())
    }

    @Ignore
    @Test
    fun squareOfSum5() {
        assertEquals(225, Squares(5).squareOfSum())
    }

    @Ignore
    @Test
    fun squareOfSum100() {
        assertEquals(25502500, Squares(100).squareOfSum())
    }

    @Ignore
    @Test
    fun sumOfSquares1() {
        assertEquals(1, Squares(1).sumOfSquares())
    }

    @Ignore
    @Test
    fun sumOfSquares5() {
        assertEquals(55, Squares(5).sumOfSquares())
    }

    @Ignore
    @Test
    fun sumOfSquares100() {
        assertEquals(338350, Squares(100).sumOfSquares())
    }

    @Ignore
    @Test
    fun differenceOfSquares1() {
        assertEquals(0, Squares(1).difference())
    }

    @Ignore
    @Test
    fun differenceOfSquares5() {
        assertEquals(170, Squares(5).difference())
    }

    @Ignore
    @Test
    fun differenceOfSquares100() {
        assertEquals(25164150, Squares(100).difference())
    }

}
