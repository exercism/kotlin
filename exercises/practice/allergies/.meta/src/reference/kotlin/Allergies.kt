class Allergies(val score: Int) {

    fun getList(): List<Allergen> = Allergen.values().filter { isAllergicTo(it) }

    fun isAllergicTo(allergen: Allergen) = (score and allergen.score) == allergen.score
}
