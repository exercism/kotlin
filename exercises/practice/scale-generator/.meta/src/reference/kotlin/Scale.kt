class Scale(private val tonic: String) {

    companion object {
        private val sharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
        private val flats = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")
        private val useFlats = listOf("F", "Bb", "Eb", "Ab", "Db", "Gb", "d", "g", "c", "f", "bb", "eb")
        private val intervalOffsets = mapOf('m' to 1, 'M' to 2, 'A' to 3)
    }

    private val orderedChromatic: List<String>

    init {
        val notes = if (useFlats.contains(tonic)) flats else sharps
        val start = notes.indexOfFirst { it.lowercase() == tonic.lowercase() }
        orderedChromatic = notes.subList(start, notes.size) + notes.subList(0, start)
    }

    fun chromatic(): List<String> = orderedChromatic

    fun interval(intervals: String): List<String> {
        var idx = 0
        return intervals.map {
            val note = orderedChromatic[idx]
            idx += intervalOffsets[it] ?: error("Unkown interval $it!")
            note
        }
    }
}
