class Anagram(val word: String) {
    fun match(anagrams: Collection<String>) =
            anagrams.filter({ doesMatch(it) }).filterNot({ it.equals(word, ignoreCase = true) })

    private fun doesMatch(anagram: String) =
            anagram.toLowerCase().toCharArray().sorted() == word.toLowerCase().toCharArray().sorted()

}
