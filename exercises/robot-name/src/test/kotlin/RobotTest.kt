import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class RobotTest {

    companion object {
        val EXPECTED_ROBOT_NAME_PATTERN = Regex("[A-Z]{2}\\d{3}")
        private fun isValidName(name: String) = EXPECTED_ROBOT_NAME_PATTERN.matches(name)
    }

    val robot = Robot()


    @Test
    fun hasName() {
        assertTrue(isValidName(robot.name), "Robot name ${robot.name} didn't match expected pattern.")
    }

    @Ignore
    @Test
    fun differentRobotsHaveDifferentNames() {
        assertNotEquals(robot.name, Robot().name)
    }

    @Ignore
    @Test
    fun resetName() {
        val name = robot.name
        robot.reset()

        val name2 = robot.name
        assertNotEquals(name, name2)
        assertTrue(isValidName(name2), "Robot name $name2 didn't match expected pattern.")
    }

}
