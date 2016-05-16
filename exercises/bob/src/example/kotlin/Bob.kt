/**
 * Bob is a lackadasical teenager.
 */
object Bob {
    fun hey(input: String): String {
        return when {
            isSilence(input) -> "Fine. Be that way!"
            isShout(input) -> "Whoa, chill out!"
            isQuestion(input) -> "Sure."
            else -> "Whatever."
        }
    }

    private fun isSilence(input: String) = input.isBlank()
    private fun isQuestion(input: String) = input.endsWith("?")
    private fun isShout(input: String): Boolean {
        val isOnlyUppercase = input == input.toUpperCase()
        val hasLetter = input.contains(Regex("[A-Z]"))

        return hasLetter && isOnlyUppercase
    }

}
