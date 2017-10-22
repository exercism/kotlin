import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class DiamondPrinterTest {

    private lateinit var diamondPrinter: DiamondPrinter

    @Before
    fun setUp() {
        diamondPrinter = DiamondPrinter()
    }

    @Test
    fun testOneByOneDiamond() {
        val output = diamondPrinter.printToList('A')
        assertThat(output, `is`(listOf("A")))
    }

    @Ignore
    @Test
    fun testTwoByTwoDiamond() {
        val output = diamondPrinter.printToList('B')
        assertThat(output, `is`(listOf(
                " A ",
                "B B",
                " A ")))
    }

    @Ignore
    @Test
    fun testThreeByThreeDiamond() {
        val output = diamondPrinter.printToList('C')
        assertThat(output, `is`(listOf(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  ")))
    }

    @Ignore
    @Test
    fun testFiveByFiveDiamond() {
        val output = diamondPrinter.printToList('E')
        assertThat(output, `is`(listOf(
                "    A    ",
                "   B B   ",
                "  C   C  ",
                " D     D ",
                "E       E",
                " D     D ",
                "  C   C  ",
                "   B B   ",
                "    A    ")))
    }

    @Ignore
    @Test
    fun testFullDiamond() {
        val output = diamondPrinter.printToList('Z')
        assertThat(output, `is`(listOf(
                "                         A                         ",
                "                        B B                        ",
                "                       C   C                       ",
                "                      D     D                      ",
                "                     E       E                     ",
                "                    F         F                    ",
                "                   G           G                   ",
                "                  H             H                  ",
                "                 I               I                 ",
                "                J                 J                ",
                "               K                   K               ",
                "              L                     L              ",
                "             M                       M             ",
                "            N                         N            ",
                "           O                           O           ",
                "          P                             P          ",
                "         Q                               Q         ",
                "        R                                 R        ",
                "       S                                   S       ",
                "      T                                     T      ",
                "     U                                       U     ",
                "    V                                         V    ",
                "   W                                           W   ",
                "  X                                             X  ",
                " Y                                               Y ",
                "Z                                                 Z",
                " Y                                               Y ",
                "  X                                             X  ",
                "   W                                           W   ",
                "    V                                         V    ",
                "     U                                       U     ",
                "      T                                     T      ",
                "       S                                   S       ",
                "        R                                 R        ",
                "         Q                               Q         ",
                "          P                             P          ",
                "           O                           O           ",
                "            N                         N            ",
                "             M                       M             ",
                "              L                     L              ",
                "               K                   K               ",
                "                J                 J                ",
                "                 I               I                 ",
                "                  H             H                  ",
                "                   G           G                   ",
                "                    F         F                    ",
                "                     E       E                     ",
                "                      D     D                      ",
                "                       C   C                       ",
                "                        B B                        ",
                "                         A                         ")))
    }

}
