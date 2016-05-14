object Acronym {
    fun generate(phrase: String) = Regex("[A-Z]+[a-z]*|[a-z]+").findAll(phrase).map { it.value.first().toUpperCase() }.joinToString("")
}