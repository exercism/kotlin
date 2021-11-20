class Anagram(private val word: String) {

    fun match(anagrams: Collection<String>) =
            anagrams.filter { containSameChars(it.lowercase()) }
                    .filterNot { it.equals(word, ignoreCase = true) }
                    .toSet()

    private fun containSameChars(candidate: String) =
            candidate.lowercase().toCharArray().sorted() == word.lowercase().toCharArray().sorted()

}
