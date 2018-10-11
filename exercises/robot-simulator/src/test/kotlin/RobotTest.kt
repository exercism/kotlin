import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class RobotTest {

    @Test
    fun testRobotIsCreatedWithCorrectPositionAndOrientationByDefault() {
        val robot = Robot()

        assertEquals(GridPosition(x = 0, y = 0), robot.gridPosition)
        assertEquals(Orientation.NORTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testRobotCanBeCreatedWithCustomPositionAndOrientation() {
        val robot = Robot(GridPosition(x = -1, y = -1), Orientation.SOUTH)

        assertEquals(GridPosition(x = -1, y = -1), robot.gridPosition)
        assertEquals(Orientation.SOUTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningRightCorrectlyChangesOrientationFromNorthToEast() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)

        robot.turnRight()

        assertEquals(Orientation.EAST, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningRightCorrectlyChangesOrientationFromEastToSouth() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.EAST)

        robot.turnRight()

        assertEquals(Orientation.SOUTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningRightCorrectlyChangesOrientationFromSouthToWest() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.SOUTH)

        robot.turnRight()

        assertEquals(Orientation.WEST, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningRightCorrectlyChangesOrientationFromWestToNorth() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.WEST)

        robot.turnRight()

        assertEquals(Orientation.NORTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningLeftCorrectlyChangesOrientationFromNorthToWest() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)

        robot.turnLeft()

        assertEquals(Orientation.WEST, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningLeftCorrectlyChangesOrientationFromWestToSouth() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.WEST)

        robot.turnLeft()

        assertEquals(Orientation.SOUTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningLeftCorrectlyChangesOrientationFromSouthToEast() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.SOUTH)

        robot.turnLeft()

        assertEquals(Orientation.EAST, robot.orientation)
    }

    @Ignore
    @Test
    fun testTurningLeftCorrectlyChangesOrientationFromEastToNorth() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.EAST)

        robot.turnLeft()

        assertEquals(Orientation.NORTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testAdvancingDoesNotChangeOrientation() {
        val initialOrientation = Orientation.NORTH
        val robot = Robot(GridPosition(x = 0, y = 0), initialOrientation)

        robot.advance()

        assertEquals(initialOrientation, robot.orientation)
    }

    @Ignore
    @Test
    fun testAdvancingWhenFacingNorthIncreasesYCoordinateByOne() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)

        robot.advance()

        assertEquals(GridPosition(x = 0, y = 1), robot.gridPosition)
    }

    @Ignore
    @Test
    fun testAdvancingWhenFacingSouthDecreasesYCoordinateByOne() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.SOUTH)

        robot.advance()

        assertEquals(GridPosition(x = 0, y = -1), robot.gridPosition)
    }

    @Ignore
    @Test
    fun testAdvancingWhenFacingEastIncreasesXCoordinateByOne() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.EAST)

        robot.advance()

        assertEquals(GridPosition(x = 1, y = 0), robot.gridPosition)
    }

    @Ignore
    @Test
    fun testAdvancingWhenFacingWestDecreasesXCoordinateByOne() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.WEST)

        robot.advance()

        assertEquals(GridPosition(x = -1, y = 0), robot.gridPosition)
    }

    @Ignore
    @Test
    fun testInstructionsToMoveEastAndNorthFromNorth() {
        val robot = Robot(GridPosition(x = 7, y = 3), Orientation.NORTH)

        robot.simulate("RAALAL")

        assertEquals(GridPosition(x = 9, y = 4), robot.gridPosition)
        assertEquals(Orientation.WEST, robot.orientation)
    }

    @Ignore
    @Test
    fun testInstructionsToMoveWestAndNorth() {
        val robot = Robot(GridPosition(x = 0, y = 0), Orientation.NORTH)

        robot.simulate("LAAARALA")

        assertEquals(GridPosition(x = -4, y = 1), robot.gridPosition)
        assertEquals(Orientation.WEST, robot.orientation)
    }

    @Ignore
    @Test
    fun testInstructionsToMoveWestAndSouth() {
        val robot = Robot(GridPosition(x = 2, y = -7), Orientation.EAST)

        robot.simulate("RRAAAAALA")

        assertEquals(GridPosition(x = -3, y = -8), robot.gridPosition)
        assertEquals(Orientation.SOUTH, robot.orientation)
    }

    @Ignore
    @Test
    fun testInstructionsToMoveEastAndNorthFromSouth() {
        val robot = Robot(GridPosition(x = 8, y = 4), Orientation.SOUTH)

        robot.simulate("LAAARRRALLLL")

        assertEquals(GridPosition(x = 11, y = 5), robot.gridPosition)
        assertEquals(Orientation.NORTH, robot.orientation)
    }
}
