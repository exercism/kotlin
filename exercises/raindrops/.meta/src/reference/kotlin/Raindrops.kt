object Raindrops {
    private val sounds = listOf(Pair(3, "Pling"), Pair(5, "Plang"), Pair(7, "Plong"))

    fun convert(n: Int): String {
        val result = sounds.filter { n % it.first == 0 }.map { it.second }.joinToString("")

        return if (result.isEmpty()) n.toString() else result
    }
}
