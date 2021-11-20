import java.util.*

class Forth {

    companion object {
        private val NUMBER_PATTERN = Regex("""^-?\d+$""")
    }

    private val stack: Deque<Int> = ArrayDeque()
    private val customOps: MutableMap<String, String> = mutableMapOf()
    private val ops = mutableMapOf(
            "+" to {
                require(stack.isNotEmpty()) { "empty stack" }
                require(stack.size >= 2) { "only one value on the stack" }
                stack.push(stack.pop() + stack.pop())
            },
            "-" to {
                require(stack.isNotEmpty()) { "empty stack" }
                require(stack.size >= 2) { "only one value on the stack" }
                val tmp = stack.pop()
                stack.push(stack.pop() - tmp)
            },
            "*" to {
                require(stack.isNotEmpty()) { "empty stack" }
                require(stack.size >= 2) { "only one value on the stack" }
                stack.push(stack.pop() * stack.pop())
            },
            "/" to {
                require(stack.isNotEmpty()) { "empty stack" }
                require(stack.size >= 2) { "only one value on the stack" }
                val tmp = stack.pop()
                require(tmp != 0) { "divide by zero" }
                stack.push(stack.pop() / tmp)
            },
            "DUP" to {
                require(stack.isNotEmpty()) { "empty stack" }
                stack.push(stack.first)
            },
            "DROP" to {
                require(stack.isNotEmpty()) { "empty stack" }
                stack.pop()
            },
            "SWAP" to {
                require(stack.isNotEmpty()) { "empty stack" }
                require(stack.size >= 2) { "only one value on the stack" }
                val a = stack.pop()
                val b = stack.pop()
                stack.push(a)
                stack.push(b)
            },
            "OVER" to {
                require(stack.isNotEmpty()) { "empty stack" }
                require(stack.size >= 2) { "only one value on the stack" }
                stack.push(stack.elementAt(1))
            }
    );

    fun evaluate(vararg lines: String): List<Int> {
        lines.forEach { line ->
            evaluateLine(line.uppercase())
        }
        return stack.reversed()
    }

    private fun evaluateLine(line: String) {
        val tokens = line.split(" ")

        if (tokens.first() == ":") {
            val op = tokens[1]
            val expression = tokens.subList(2, tokens.lastIndex)
            require(!op.matches(NUMBER_PATTERN)) { "illegal operation" }
            customOps[op] = expression.joinToString(" ") { customOps.getOrDefault(it, it) }
            return
        }

        tokens.forEach { token ->
            when {
                token.matches(NUMBER_PATTERN) -> stack.push(token.toInt())
                token in customOps.keys -> evaluateLine(customOps[token]!!)
                token in ops.keys -> ops[token]!!()
                else -> throw IllegalArgumentException("undefined operation")
            }
        }
    }
}
