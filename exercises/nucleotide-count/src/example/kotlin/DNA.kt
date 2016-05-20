class DNA(strand: String) {
    init {
        if (!strand.matches(Regex("^[$nucleotides]*$"))) {
            throw IllegalArgumentException("DNA sequence contains invalid nucleotides sequence.")
        }
    }

    companion object DNA {
        val nucleotides = "ATCG"
        val emptyNucleotideCounts = nucleotides.map { Pair(it, 0) }.toMap()
    }

    val nucleotideCounts: Map<Char, Int> by lazy {
        emptyNucleotideCounts + strand.toCharArray().groupBy { it }.mapValues { it.value.size }
    }

    fun count(nucleotide: Char): Int {
        if (!nucleotides.contains(nucleotide)) {
            throw IllegalArgumentException("$nucleotide is not a nucleotide");
        }

        return nucleotideCounts[nucleotide] ?: 0
    }
}

