class DNA(strand: String) {
    init {
        require(strand.matches(Regex("^[$nucleotides]*$")), { "DNA sequence contains invalid nucleotides sequence." })
    }

    companion object DNA {
        val nucleotides = "ATCG"
        val emptyNucleotideCounts = nucleotides.map { it to 0 }.toMap()
    }

    val nucleotideCounts: Map<Char, Int> by lazy {
        emptyNucleotideCounts + strand.groupBy { it }.mapValues { it.value.size }
    }

    fun count(nucleotide: Char): Int {
        require(nucleotide in nucleotides, { "$nucleotide is not a nucleotide" })

        return nucleotideCounts[nucleotide] ?: 0
    }
}

