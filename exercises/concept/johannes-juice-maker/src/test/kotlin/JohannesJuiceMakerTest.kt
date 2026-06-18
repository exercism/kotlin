import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JuiceMakerTest {
    val jug : Jug = Jug()

    @Test
    fun `juice maker has given capacity`() {
        val maker = JuiceMaker(300, jug)
        assertEquals(300, maker.capacity)
    }

    @Test
    fun `juice maker has given jug`() {
        val maker = JuiceMaker(300, jug)
        assertEquals(jug, maker.jug)
    }

    @Test
    fun `extend jug when capacity is 1001`() {
        JuiceMaker(1001, jug)
        assertTrue(jug.isExtended())
    }

    @Test
    fun `do not extend jug when capacity is 1000`() {
        JuiceMaker(1000, jug)
        assertFalse(jug.isExtended())
    }

    @Test
    fun `juice maker uses starter`() {
        val starter : Starter = Starter()
        JuiceMaker(300, jug, starter)
        assertTrue(starter.isInstalled())
    }

    @Test
    fun `light is red before starting`() {
        val maker = JuiceMaker(300, jug)
        assertEquals("red", maker.lightColor())
    }

    @Test
    fun `light is red when started at 1`() {
        val maker = JuiceMaker(300, jug)
        maker.start(1)
        assertEquals("green", maker.lightColor())
    }

    @Test
    fun `light is red when started at 3`() {
        val maker = JuiceMaker(300, jug)
        maker.start(3)
        assertEquals("green", maker.lightColor())
    }

    @Test
    fun `light is yellow when started at 4`() {
        val maker = JuiceMaker(300, jug)
        maker.start(4)
        assertEquals("yellow", maker.lightColor())
    }

    @Test
    fun `light goes back to red when stopped`() {
        val maker = JuiceMaker(300, jug)
        maker.start(3)
        maker.stop()
        assertEquals("red", maker.lightColor())
    }

    @Test
    fun `common configuration has capacity of 1500`() {
        val maker = buildWithCommonCapacity()
        assertEquals(1500, maker.capacity)
    }
}
