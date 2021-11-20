object Atbash {
    private const val GROUP_SIZE = 5

    fun encode(s: String): String = cipherSubstitution(s).mapIndexed { index, char -> char + groupFinalizer(index) }.joinToString("").trimEnd()

    fun decode(s: String): String = cipherSubstitution(s)

    private fun cipherSubstitution(s: String): String = s.fold("") { accum, char -> accum + substitute(char) }

    private fun substitute(c: Char): String {
        return when {
            c.isDigit() -> c.toString()
            c.isLetter() -> ('a' + ('z' - c.lowercaseChar())).toString()
            else -> ""
        }
    }

    private fun groupFinalizer(index: Int): String = if ((index + 1) % GROUP_SIZE == 0) " " else ""



}
