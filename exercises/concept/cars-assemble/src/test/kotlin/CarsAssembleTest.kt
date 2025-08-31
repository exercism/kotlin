import kotlin.test.Test
import kotlin.test.assertEquals

class CarsAssembleTest {

    val tolerance = 1e-9

    @Test
    fun `calculate working cars per hour with 0 production rate`() {
        assertEquals(0.0,  CarsAssemble.calculateWorkingCarsPerHour(0, 100.0), tolerance)
    }

    @Test
    fun `calculate working cars per hour with 100 percent success rate`() {
        assertEquals(221.0,  CarsAssemble.calculateWorkingCarsPerHour(221, 100.0), tolerance)
    }

    @Test
    fun `calculate working cars per hour with 80 percent success rate`() {
        assertEquals(340.8,  CarsAssemble.calculateWorkingCarsPerHour(426, 80.0), tolerance)
    }

    @Test
    fun `calculate working cars per hour with 20 point 5 percent success rate`() {
        assertEquals(1398.92,  CarsAssemble.calculateWorkingCarsPerHour(6824, 20.5), tolerance)
    }

    @Test
    fun `calculate working cars per hour with 0 percent success rate`() {
        assertEquals(0.0,  CarsAssemble.calculateWorkingCarsPerHour(8000, 0.0), tolerance)
    }

    @Test
    fun `calculate working cars per minute with 0 production rate`() {
        assertEquals(0,  CarsAssemble.calculateWorkingCarsPerMinute(0, 100.0))
    }

    @Test
    fun `calculate working cars per minute with 100 percent success rate`() {
        assertEquals(3,  CarsAssemble.calculateWorkingCarsPerMinute(221, 100.0))
    }

    @Test
    fun `calculate working cars per minute with 80 percent success rate`() {
        assertEquals(5,  CarsAssemble.calculateWorkingCarsPerMinute(426, 80.0))
    }

    @Test
    fun `calculate working cars per minute with 20 point 5 percent success rate`() {
        assertEquals(23,  CarsAssemble.calculateWorkingCarsPerMinute(6824, 20.5))
    }

    @Test
    fun `calculate working cars per minute with 0 percent success rate`() {
        assertEquals(0,  CarsAssemble.calculateWorkingCarsPerMinute(8000, 0.0))
    }

    @Test
    fun `calculate production cost for 0 cars`() {
        assertEquals(0uL,  CarsAssemble.calculateProductionCost(0))
    }

    @Test
    fun `calculate production cost for 1 car`() {
        assertEquals(10_000uL,  CarsAssemble.calculateProductionCost(1))
    }

    @Test
    fun `calculate production cost for 2 cars`() {
        assertEquals(20_000uL,  CarsAssemble.calculateProductionCost(2))
    }

    @Test
    fun `calculate production cost for 9 cars`() {
        assertEquals(90_000uL,  CarsAssemble.calculateProductionCost(9))
    }

    @Test
    fun `calculate production cost for 10 cars`() {
        assertEquals(95_000uL,  CarsAssemble.calculateProductionCost(10))
    }

    @Test
    fun `calculate production cost for 100 cars`() {
        assertEquals(95_0000uL,  CarsAssemble.calculateProductionCost(100))
    }

    @Test
    fun `calculate production cost for 21 cars`() {
        assertEquals(200_000uL,  CarsAssemble.calculateProductionCost(21))
    }

    @Test
    fun `calculate production cost for 37 cars`() {
        assertEquals(355_000uL,  CarsAssemble.calculateProductionCost(37))
    }

    @Test
    fun `calculate production cost for 56 cars`() {
        assertEquals(535_000uL,  CarsAssemble.calculateProductionCost(56))
    }

    @Test
    fun `calculate production cost for 148 cars`() {
        assertEquals(1_410_000uL,  CarsAssemble.calculateProductionCost(148))
    }
}
