import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(private val seconds: Long) {

    companion object {
        const val EARTH_ORBITAL_PERIOD_IN_SECONDS = 31557600.0
        const val PRECISION = 2

        private enum class Planet(val relativeOrbitalPeriod: Double) {
            EARTH(1.0),
            MERCURY(0.2408467),
            VENUS(0.61519726),
            MARS(1.8808158),
            JUPITER(11.862615),
            SATURN(29.447498),
            URANUS(84.016846),
            NEPTUNE(164.79132)
        }
    }

    fun onEarth() = calculateAge(Planet.EARTH)
    fun onMercury() = calculateAge(Planet.MERCURY)
    fun onVenus() = calculateAge(Planet.VENUS)
    fun onMars() = calculateAge(Planet.MARS)
    fun onJupiter() = calculateAge(Planet.JUPITER)
    fun onSaturn() = calculateAge(Planet.SATURN)
    fun onUranus() = calculateAge(Planet.URANUS)
    fun onNeptune() = calculateAge(Planet.NEPTUNE)

    private fun calculateAge(planet: Planet): Double {
        val age: Double = seconds / (EARTH_ORBITAL_PERIOD_IN_SECONDS * planet.relativeOrbitalPeriod)

        return BigDecimal(age).setScale(PRECISION, RoundingMode.HALF_UP).toDouble()
    }
}
