import java.util.*

sealed class Token {

    data class OpDefToken(val newOp: String, val newOpDefTokens: List<Token>): Token() {

        companion object {
            fun fromString(string: String): OpDefToken {
                val trimmedLine = string.substring(2..string.lastIndex - 2)
                val newOpEnd = trimmedLine.indexOf(" ")

                require(newOpEnd >= 0) { "Incomplete operation definition" }

                val newOpToken = Token.fromString(trimmedLine.substring(0 until newOpEnd)).first()

                require(newOpToken is OpToken) { "Cannot redefine numbers" }

                val newOpDefTokens = Token.fromString(trimmedLine.substring(newOpEnd + 1))
                return OpDefToken((newOpToken as OpToken).op, newOpDefTokens)
            }
        }

    }

    data class OpToken(val op: String): Token()
    data class IntToken(val rawValue: Int): Token()

    companion object {
        val opChars = "A-z+/*\\-"

        fun fromString(string: String): List<Token> {
            return when {
                string.startsWith(':') -> listOf(OpDefToken.fromString(string))
                string.matches(Regex("[$opChars]+(?:-[$opChars]+)*")) -> listOf(OpToken(string.toLowerCase()))
                string.matches(Regex("\\d+")) -> listOf(IntToken(string.toInt()))
                else -> string.split(delimiters = " ").flatMap { Token.fromString(it) }
            }
        }
    }

}

class ForthEvaluator {

    companion object {
        private val builtInOps = mapOf<String, (Deque<Int>) -> Any>(
                Pair("+") { values ->
                    require(values.size >= 2) { "Addition requires that the stack contain at least 2 values" }
                    values.push(values.pop() + values.pop())
                },

                Pair("-") { values ->
                    require(values.size >= 2) { "Subtraction requires that the stack contain at least 2 values" }
                    val topValue = values.pop()
                    val secondValue = values.pop()
                    values.push(secondValue - topValue)
                },

                Pair("*") { values ->
                    require(values.size >= 2) { "Multiplication requires that the stack contain at least 2 values" }
                    values.push(values.pop() * values.pop())
                },

                Pair("/") { values ->
                    require(values.size >= 2) { "Division requires that the stack contain at least 2 values" }
                    val topValue = values.pop()
                    val secondValue = values.pop()
                    require(topValue != 0) { "Division by 0 is not allowed" }
                    values.push(secondValue / topValue)
                },

                Pair("dup") { values ->
                    require(values.isNotEmpty()) { "Duplicating requires that the stack contain at least 1 value" }
                    values.push(values.peek())
                },

                Pair("drop") { values ->
                    require(values.isNotEmpty()) { "Dropping requires that the stack contain at least 1 value" }
                    values.pop()
                },

                Pair("swap") { values ->
                    require(values.size >= 2) { "Swapping requires that the stack contain at least 2 values" }
                    val topValue = values.pop()
                    val secondValue = values.pop()
                    values.push(topValue)
                    values.push(secondValue)
                },

                Pair("over") { values ->
                    require(values.size >= 2) { "Overing requires that the stack contain at least 2 values" }
                    val topValue = values.pop()
                    val secondValue = values.peek()
                    values.push(topValue)
                    values.push(secondValue)
                }
        )
    }

    private val values = ArrayDeque<Int>()

    private val tokens = mutableListOf<Token>()

    private val userOps = mutableMapOf<String, List<Token>>()

    fun evaluateProgram(program: List<String>): List<Int> {
        parse(program)
        evaluate()
        return values.toList().asReversed()
    }

    private fun parse(program: List<String>) = tokens.addAll(program.flatMap(Token.Companion::fromString))

    private fun evaluate() {
        while (tokens.isNotEmpty()) {
            val token = tokens.removeAt(0)

            when (token) {
                is Token.OpDefToken -> userOps.put(token.newOp.toLowerCase(), token.newOpDefTokens)
                is Token.OpToken    -> evaluateOpToken(token)
                is Token.IntToken   -> values.push(token.rawValue)
            }
        }
    }

    private fun evaluateOpToken(opToken: Token.OpToken) {
        val op = opToken.op

        if (userOps.containsKey(op)) {
            userOps[op]!!.asReversed().forEach { token -> tokens.add(index = 0, element = token) }
        } else if (builtInOps.containsKey(op)) {
            builtInOps[op]!!.invoke(values)
        } else {
            throw IllegalArgumentException("No definition available for operator \"$op\"")
        }
    }

}
