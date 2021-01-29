import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SpaceAgeTest {
    @Test
    fun `age on Earth`() = assertYearsEqual(31.69, SpaceAge(1000000000).onEarth())

    @Ignore
    @Test
    fun `age on Mercury`() = assertYearsEqual(280.88, SpaceAge(2134835688).onMercury())

    @Ignore
    @Test
    fun `age on Venus`() = assertYearsEqual(9.78, SpaceAge(189839836).onVenus())

    @Ignore
    @Test
    fun `age on Mars`() = assertYearsEqual(35.88, SpaceAge(2129871239).onMars())

    @Ignore
    @Test
    fun `age on Jupiter`() = assertYearsEqual(2.41, SpaceAge(901876382).onJupiter())

    @Ignore
    @Test
    fun `age on Saturn`() = assertYearsEqual(2.15, SpaceAge(2000000000).onSaturn())

    @Ignore
    @Test
    fun `age on Uranus`() = assertYearsEqual(0.46, SpaceAge(1210123456).onUranus())

    @Ignore
    @Test
    fun `age on Neptune`() = assertYearsEqual(0.35, SpaceAge(1821023456).onNeptune())
}

private fun assertYearsEqual(expectedYears: Double, actualYears: Double) = assertEquals(expectedYears, actualYears)
