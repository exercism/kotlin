import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class MinesweeperBoardTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun testInputBoardWithNoRowsAndNoColumns() {
        val inputBoard = emptyList<String>()
        val expectedNumberedBoard = emptyList<String>()
        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithOneRowAndNoColumns() {
        val inputBoard = listOf("")
        val expectedNumberedBoard = listOf("")
        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithNoMines() {
        val inputBoard = listOf(
                "   ",
                "   ",
                "   "
        )

        val expectedNumberedBoard = listOf(
                "   ",
                "   ",
                "   "
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithOnlyMines() {
        val inputBoard = listOf(
                "***",
                "***",
                "***"
        )

        val expectedNumberedBoard = listOf(
                "***",
                "***",
                "***"
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithSingleMineAtCenter() {
        val inputBoard = listOf(
                "   ",
                " * ",
                "   "
        )

        val expectedNumberedBoard = listOf(
                "111",
                "1*1",
                "111"
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithMinesAroundPerimeter() {
        val inputBoard = listOf(
                "***",
                "* *",
                "***"
        )

        val expectedNumberedBoard = listOf(
                "***",
                "*8*",
                "***"
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithSingleRowAndTwoMines() {
        val inputBoard = listOf(" * * ")

        val expectedNumberedBoard = listOf("1*2*1")

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithSingleRowAndTwoMinesAtEdges() {
        val inputBoard = listOf("*   *")

        val expectedNumberedBoard = listOf("*1 1*")

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithSingleColumnAndTwoMines() {
        val inputBoard = listOf(
                " ",
                "*",
                " ",
                "*",
                " "
        )

        val expectedNumberedBoard = listOf(
                "1",
                "*",
                "2",
                "*",
                "1"
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithSingleColumnAndTwoMinesAtEdges() {
        val inputBoard = listOf(
                "*",
                " ",
                " ",
                " ",
                "*"
        )

        val expectedNumberedBoard = listOf(
                "*",
                "1",
                " ",
                "1",
                "*"
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testInputBoardWithMinesInCross() {
        val inputBoard = listOf(
                "  *  ",
                "  *  ",
                "*****",
                "  *  ",
                "  *  "
        )

        val expectedNumberedBoard = listOf(
                " 2*2 ",
                "25*52",
                "*****",
                "25*52",
                " 2*2 "
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

    @Ignore
    @Test
    fun testLargeInputBoard() {
        val inputBoard = listOf(
                " *  * ",
                "  *   ",
                "    * ",
                "   * *",
                " *  * ",
                "      "
        )

        val expectedNumberedBoard = listOf(
                "1*22*1",
                "12*322",
                " 123*2",
                "112*4*",
                "1*22*2",
                "111111"
        )

        val actualNumberedBoard = MinesweeperBoard(inputBoard).withNumbers()

        assertEquals(expectedNumberedBoard, actualNumberedBoard)
    }

}
