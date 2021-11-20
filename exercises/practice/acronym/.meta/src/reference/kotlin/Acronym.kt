object Acronym {
    fun generate(phrase: String) = Regex("[A-Z]+[a-z]*|[a-z]+")
            .findAll(phrase.replace("'", ""))
            .map { it.value.first().uppercaseChar() }
            .joinToString("")
}
