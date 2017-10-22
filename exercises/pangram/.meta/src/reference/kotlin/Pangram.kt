object Pangram {
    val alphaLength = 26
    fun isPangram(input: String) = input.toLowerCase().replace(Regex("[^a-z]"), "").toSet().size == alphaLength
}
