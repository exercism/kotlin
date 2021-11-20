object Bob {
    fun hey(input: String): String {
        val trimmedInput = input.trim()

        return when {
            isSilence(trimmedInput)         -> "Fine. Be that way!"
            isShoutedQuestion(trimmedInput) -> "Calm down, I know what I'm doing!"
            isShout(trimmedInput)           -> "Whoa, chill out!"
            isQuestion(trimmedInput)        -> "Sure."
            else                            -> "Whatever."
        }
    }

    private fun isSilence(input: String) = input.isBlank()

    private fun isQuestion(input: String) = input.endsWith("?")

    private fun isShout(input: String): Boolean {
        val isOnlyUppercase = input == input.uppercase()
        val hasLetter = input.contains(Regex("[A-Z]"))

        return hasLetter && isOnlyUppercase
    }

    private fun isShoutedQuestion(input: String) = isShout(input) && isQuestion(input)
}
