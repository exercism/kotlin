object ScrabbleScore {
    private val scoreToLetters = mapOf(1 to "AEIOULNRST", 2 to "DG", 3 to "BCMP", 4 to "FHVWY", 5 to "K", 8 to "JX", 10 to "QZ").mapValues { it.value.toCharArray() }
    private val letterToScore = scoreToLetters.flatMap { entry -> entry.value.map { char -> Pair(char, entry.key) } }.toMap()

    fun scoreLetter(c: Char) = letterToScore[c.uppercaseChar()] ?: 0
    fun scoreWord(word: String) = word.fold(0) { score, char -> score + scoreLetter(char) }
}
