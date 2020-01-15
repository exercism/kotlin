import kotlin.math.pow
import kotlin.math.sqrt

object Darts {

    /** Return the correct amount earned by a dart's landing position. */
    fun score(x: Number, y: Number): Int {
        val r = sqrt(x.toDouble().pow(2.0) + y.toDouble().pow(2.0)) // Pythagoras
        return when {
            r <= 1 -> 10
            r <= 5 -> 5
            r <= 10 -> 1
            else -> 0
        }
    }

}
