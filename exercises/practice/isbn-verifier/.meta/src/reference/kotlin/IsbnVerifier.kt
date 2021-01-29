class IsbnVerifier {
    fun isValid(number: String): Boolean {
        val value: String = number.replace("-", "")

        if(!Regex("""^(\d{9}[\dX])${'$'}""").matches(value)) {
            return false
        }

        return value.mapIndexed { i, c -> (10 - i) * when {
                c == 'X' && i == 9 -> 10
                else -> Character.getNumericValue(c)
            }
        }.sum() % 11 == 0
    }
}