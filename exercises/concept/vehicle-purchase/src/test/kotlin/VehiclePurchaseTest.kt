import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.Test

class VehiclePurchaseTest() {
    val tolerance = 0.00001

    @Test
    fun `car needs a license`() {
        assertTrue(needsLicense("car"))
    }

    @Test
    fun `truck needs a license`() {
        assertTrue(needsLicense("truck"))
    }

    @Test
    fun `bike does not need a license`() {
        assertFalse(needsLicense("bike"))
    }

    @Test
    fun `stroller does not need a license`() {
        assertFalse(needsLicense("stroller"))
    }

    @Test
    fun `e-scooter does not need a license`() {
        assertFalse(needsLicense("e-scooter"))
    }

    @Test
    fun `choose Bugatti over Ford`() {
        assertEquals("Bugatti Veyron is clearly the better choice.", chooseVehicle("Bugatti Veyron", "Ford Pinto"))
    }

    @Test
    fun `choose Chery over Kia`() {
        assertEquals("Cherry EQ is clearly the better choice.", chooseVehicle("Cherry EQ", "Kia Niro Elektro"))
    }

    @Test
    fun `choose Ford Focus over Ford Pinto`() {
        assertEquals("Ford Focus is clearly the better choice.", chooseVehicle("Ford Focus", "Ford Pinto"))
    }

    @Test
    fun `choose 2018 over 2020`() {
        assertEquals(
            "2018 Bergamont City is clearly the better choice.",
            chooseVehicle("2018 Bergamont City", "2020 Gazelle Medeo")
        )
    }

    @Test
    fun `chooses Bugatti over ford`() {
        assertEquals("Bugatti Veyron is clearly the better choice.", chooseVehicle("Bugatti Veyron", "ford"))
    }

    @Test
    fun `price is reduced to 80 percent for age below 3`() {
        assertEquals(32_000.0, calculateResellPrice(40_000.0, 2.0), tolerance)
    }

    @Test
    fun `price is reduced to 80 percent for age slightly below 3`() {
        assertEquals(32_000.0, calculateResellPrice(40_000.0, 2.999), tolerance)
    }

    @Test
    fun `price is reduced to 70 percent for age 3`() {
        assertEquals(28_000.0, calculateResellPrice(40_000.0, 3.0), tolerance)
    }

    @Test
    fun `price is reduced to 70 percent for age 7`() {
        assertEquals(28_000.0, calculateResellPrice(40_000.0, 7.0), tolerance)
    }

    @Test
    fun `price is reduced to 50 percent for age 10`() {
        assertEquals(12_500.0, calculateResellPrice(25_000.0, 10.0), tolerance)
    }

    @Test
    fun `price is reduced to 50 percent for age 11`() {
        assertEquals(25_000.0, calculateResellPrice(50_000.0, 11.0), tolerance)
    }
}