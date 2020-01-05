import java.util.regex.Pattern
import kotlin.math.pow

object Wordy {

    private val startPattern = Pattern.compile("^What is (-?\\d+)(.*)\\?$")
    private val operandPattern = Pattern.compile("^ ([^-0-9]+) (-?\\d+)(.*)$")
    private val powerPattern = Pattern.compile("^ raised to the (-?\\d+)(st|nd|rd|th) power(.*)$")

    fun answer(input: String): Int {
        val startMatcher = startPattern.matcher(input)
        require(startMatcher.find())
        val firstNumber = startMatcher.group(1).toInt()
        val rest = startMatcher.group(2)
        return answerRecursive(rest, firstNumber)
    }

    private fun answerRecursive(input: String, result: Int): Int {
        val operandMatcher = operandPattern.matcher(input)
        val powerMatcher = powerPattern.matcher(input)
        return when {
            powerMatcher.find() -> {
                val operand = powerMatcher.group(1).toInt()
                val rest = powerMatcher.group(3)
                answerRecursive(rest, result.toDouble().pow(operand.toDouble()).toInt())
            }
            operandMatcher.find() -> {
                val operator = operandMatcher.group(1)
                val operand = operandMatcher.group(2).toInt()
                val rest = operandMatcher.group(3)
                when (operator) {
                    "plus" -> answerRecursive(rest, result + operand)
                    "minus" -> answerRecursive(rest, result - operand)
                    "multiplied by" -> answerRecursive(rest, result * operand)
                    "divided by" -> answerRecursive(rest, result / operand)
                    else -> throw IllegalArgumentException("Unknown operator '$operator'!")
                }
            }
            input.isEmpty() -> result
            else -> throw IllegalArgumentException("Cannot parse '$input'!")
        }
    }
}
