object RnaTranscription {

    fun ofDna(strand: String) = strand.map {
        when (it) {
            'A' -> 'U'
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            else -> it
        }
    }.joinToString("")
}
