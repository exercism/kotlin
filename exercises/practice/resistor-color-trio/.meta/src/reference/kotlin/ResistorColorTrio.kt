import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val (first, second, third) = input.take(3).map { it.ordinal.toLong() }

        val value: Long = ((first * 10L) + second) * 10L.pow(third.toInt())

        return when {
            value >= 1e9  -> "${value / 1_000_000_000L} gigaohms"
            value >= 1e6  -> "${value / 1_000_000L} megaohms"
            value >= 1e3  -> "${value / 1_000L} kiloohms"
            else          -> "$value ohms"
        }
    }
}

fun Long.pow(exp: Int): Long = this.toDouble().pow(exp).toLong()
