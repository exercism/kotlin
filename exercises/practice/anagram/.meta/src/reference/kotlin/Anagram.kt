class Anagram(private val word: String) {

    fun match(anagrams: Collection<String>) =
            anagrams.filter { containSameChars(it.toLowerCase()) }
                    .filterNot { it.equals(word, ignoreCase = true) }
                    .toSet()

    private fun containSameChars(candidate: String) =
            candidate.toLowerCase().toCharArray().sorted() == word.toLowerCase().toCharArray().sorted()

}
