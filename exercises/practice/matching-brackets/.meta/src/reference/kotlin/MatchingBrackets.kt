import java.util.*
import java.util.Collections.asLifoQueue

object MatchingBrackets {

    private val CLOSING_TO_OPENING_MAP = mapOf(
             '}' to '{',
             ')' to '(',
             ']' to '['
    )

    private val OPENING_BRACKETS = CLOSING_TO_OPENING_MAP.values
    private val CLOSING_BRACKETS = CLOSING_TO_OPENING_MAP.keys

    private val ALL_BRACKET = OPENING_BRACKETS + CLOSING_BRACKETS

    fun isValid(input: String): Boolean {
        val onlyBracketChars = input.filter { it.isBracket() }.toList()

        return isValidRec(onlyBracketChars, asLifoQueue(ArrayDeque<Char>()))
    }

    private tailrec fun isValidRec(bracketChars: List<Char>, stack: Queue<Char>): Boolean {
        if(bracketChars.isEmpty()) {
            return stack.isEmpty()
        }

        val firstChar = bracketChars.first()
        if(firstChar.isOpeningBracket()) {
            return isValidRec(bracketChars.tail(), stack.push(firstChar))
        }
        else {
            val stackHead = stack.poll() ?: return false

            val isMatch = firstChar.matchingOpeningBracket() == stackHead

            return if(isMatch) isValidRec(bracketChars.tail(), stack) else false
        }
    }

    fun Char.isBracket() = this in ALL_BRACKET

    fun Char.isOpeningBracket() = this in OPENING_BRACKETS

    fun Char.matchingOpeningBracket() = CLOSING_TO_OPENING_MAP[this] ?: throw IllegalArgumentException("Char ${this} is not a closing bracket")

}

fun <T> List<T>.tail() = this.subList(1, this.size)

fun <T> Queue<T>.push(element: T): Queue<T> {
    this.add(element)
    return this
}
