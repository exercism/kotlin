fun transcribeToRna(dna: String): String = dna.map { nucleotide ->
    when (nucleotide) {
        'A' -> 'U'
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        else -> nucleotide
    }
}.joinToString("")
