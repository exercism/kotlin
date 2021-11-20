object Raindrops {
    private val sounds = listOf(Pair(3, "Pling"), Pair(5, "Plang"), Pair(7, "Plong"))

    fun convert(n: Int): String {
        val result = sounds.filter { n % it.first == 0 }.joinToString("") { it.second }

        return result.ifEmpty { n.toString() }
    }
}
