object Pangram {
    const val alphaLength = 26
    fun isPangram(input: String) = input.lowercase().replace(Regex("[^a-z]"), "").toSet().size == alphaLength
}
