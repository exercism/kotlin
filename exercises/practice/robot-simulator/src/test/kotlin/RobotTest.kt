import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class RobotTest {

    @Test
    fun `brand new - at origin facing north`() =
        Robot()
            .should {
                face(Orientation.NORTH)
                beAt(x = 0, y = 0)
            }

    @Ignore
    @Test
    fun `brand new - at negative position facing south`() =
        Robot(GridPosition(x = -1, y = -1), Orientation.SOUTH)
            .should {
                face(Orientation.SOUTH)
                beAt(x = -1, y = -1)
            }

    @Ignore
    @Test
    fun `rotating clockwise - changes north to east`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("R")
            .should {
                face(Orientation.EAST)
            }

    @Ignore
    @Test
    fun `rotating clockwise - changes east to south`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.EAST)
            .instructed("R")
            .should {
                face(Orientation.SOUTH)
            }

    @Ignore
    @Test
    fun `rotating clockwise - changes south to west`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.SOUTH)
            .instructed("R")
            .should {
                face(Orientation.WEST)
            }

    @Ignore
    @Test
    fun `rotating clockwise - changes west to north`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.WEST)
            .instructed("R")
            .should {
                face(Orientation.NORTH)
            }

    @Ignore
    @Test
    fun `rotating counter-clockwise - changes north to west`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("L")
            .should {
                face(Orientation.WEST)
            }

    @Ignore
    @Test
    fun `rotating counter-clockwise - changes west to south`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.WEST)
            .instructed("L")
            .should {
                face(Orientation.SOUTH)
            }

    @Ignore
    @Test
    fun `rotating counter-clockwise - changes south to east`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.SOUTH)
            .instructed("L")
            .should {
                face(Orientation.EAST)
            }

    @Ignore
    @Test
    fun `rotating counter-clockwise - changes east to north`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.EAST)
            .instructed("L")
            .should {
                face(Orientation.NORTH)
            }

    @Ignore
    @Test
    fun `moving forward - facing north increments Y`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("A")
            .should {
                face(Orientation.NORTH)
                beAt(x = 0, y = 1)
            }

    @Ignore
    @Test
    fun `moving forward - facing south decrements Y`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.SOUTH)
            .instructed("A")
            .should {
                face (Orientation.SOUTH)
                beAt(x = 0, y = -1)
            }

    @Ignore
    @Test
    fun `moving forward - facing east increments X`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.EAST)
            .instructed("A")
            .should {
                face (Orientation.EAST)
                beAt(x = 1, y = 0)
            }

    @Ignore
    @Test
    fun `moving forward - facing west decrements X`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.WEST)
            .instructed("A")
            .should {
                face (Orientation.WEST)
                beAt(x = -1, y = 0)
            }

    @Ignore
    @Test
    fun `series of instructions - moving east and north example`() =
        Robot(GridPosition(x = 7, y = 3), Orientation.NORTH)
            .instructed("RAALAL")
            .should {
                face(Orientation.WEST)
                beAt(x = 9, y = 4)
            }

    @Ignore
    @Test
    fun `series of instructions - moving west and north`() =
        Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("LAAARALA")
            .should {
                face(Orientation.WEST)
                beAt(x = -4, y = 1)
            }

    @Ignore
    @Test
    fun `series of instructions - moving west and south`() =
        Robot(GridPosition(x = 2, y = -7), Orientation.EAST)
            .instructed("RRAAAAALA")
            .should {
                face(Orientation.SOUTH)
                beAt(x = -3, y = -8)
            }

    @Ignore
    @Test
    fun `series of instructions - moving east and north`() =
        Robot(GridPosition(x = 8, y = 4), Orientation.SOUTH)
            .instructed("LAAARRRALLLL")
            .should {
                face(Orientation.NORTH)
                beAt(x = 11, y = 5)
            }
}

private fun Robot.instructed(moves: String): Robot {
    simulate(moves)
    return this
}

private fun Robot.should(what: RobotShould.() -> Unit) = what(RobotShould(this))

private class RobotShould(private val robot: Robot) {
    fun face(expected: Orientation) = assertEquals(expected, robot.orientation)
    fun beAt(x: Int, y: Int) = assertEquals(GridPosition(x = x, y = y), robot.gridPosition)
}
