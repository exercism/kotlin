class Dna(strand: String) {

    init {
        require(strand.matches(Regex("^[$nucleotides]*$")), { "DNA sequence contains invalid nucleotides sequence." })
    }

    companion object Dna {
        val nucleotides = "ATCG"
        val emptyNucleotideCounts = nucleotides.map { it to 0 }.toMap()
    }

    val nucleotideCounts: Map<Char, Int> by lazy {
        emptyNucleotideCounts + strand.groupBy { it }.mapValues { it.value.size }
    }

}
