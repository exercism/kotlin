fun transcribeToRna(dna: String) = dna.map {
    when (it) {
        'A' -> 'U'
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        else -> it
    }
}.joinToString("")
