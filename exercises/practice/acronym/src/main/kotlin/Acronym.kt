object Acronym {
    fun generate(phrase: String) = phrase.trim()
        .split(" ", "-")
        .map { str -> str.filter { it.isLetter() } }
        .takeIf { it.isNotEmpty() }
        ?.mapNotNull { it.firstOrNull() }
        ?.map { it.uppercaseChar() }
        ?.joinToString("")
        ?: ""
}
