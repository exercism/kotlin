import kotlin.math.log10
import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val duoValue = 10 * input[0].ordinal + input[1].ordinal
        val trioValue = duoValue * 10.0.pow(input[2].ordinal)

        val thousandPowers = (log10(trioValue) / 3).toInt()
        val resultValue = (trioValue / 1000.0.pow(thousandPowers)).toInt()
        val resultUnit = Unit.values()[thousandPowers].name.lowercase()

        return "$resultValue $resultUnit"
    }

}
