class Dna(dna: String) {

    private val map = mutableMapOf(
        'A' to 0,
        'C' to 0,
        'T' to 0,
        'G' to 0,
    )

    init {
        if (dna.isNotEmpty()) {
            require(dna.all { map.keys.contains(it) })
        }
        dna.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
    }

    val nucleotideCounts = map
}