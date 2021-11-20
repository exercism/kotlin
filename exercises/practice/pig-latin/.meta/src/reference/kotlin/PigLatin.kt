object PigLatin {

    fun translate(phrase: String) = phrase.split(Regex("\\s+")).joinToString(" ") { translateWord(it) }

    private fun translateWord(word: String): String {
        if (startsWithVowelSound(word)) {
            return word + "ay"
        }

        val groups = splitInitialConsonantSound(word)
        if(groups != null) {
            return groups[1] + groups[0] + "ay"
        }

        return word
    }

    private val consonant = Regex("^([^aeiou]?qu|[^aeiouy]+|[^aeiou]+)([a-z]*)", RegexOption.IGNORE_CASE)
    private fun splitInitialConsonantSound(word: String) = consonant.matchEntire(word)?.groupValues?.drop(1)

    private val vowels = Regex("^([aeiou]|y[^aeiou]|xr)[a-z]*", RegexOption.IGNORE_CASE)
    private fun startsWithVowelSound(word: String) = vowels.matches(word)

}
