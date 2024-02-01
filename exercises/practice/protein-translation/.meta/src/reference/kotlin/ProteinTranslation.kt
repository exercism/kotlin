fun translate(rna: String?): List<String> {
    if (rna.isNullOrBlank()) return emptyList()

    val codons = rna.chunked(3)
    val stopIndex = codons.indexOfFirst { listOf("UAA", "UAG", "UGA").contains(it) }

    return codons.subList(0, if (stopIndex > -1) stopIndex else codons.size).map { codon ->
        when (codon) {
            "AUG" -> "Methionine"
            "UUU", "UUC" -> "Phenylalanine"
            "UUA", "UUG" -> "Leucine"
            "UCU", "UCC", "UCA", "UCG" -> "Serine"
            "UAU", "UAC" -> "Tyrosine"
            "UGU", "UGC" -> "Cysteine"
            "UGG" -> "Tryptophan"
            else -> throw IllegalArgumentException("Invalid codon")
        }
    }
}
