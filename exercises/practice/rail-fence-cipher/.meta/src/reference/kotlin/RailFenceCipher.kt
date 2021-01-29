class RailFenceCipher(private val key: Int) {
    private val size: Int = key * 2 - 2

    fun getEncryptedData(input: String): String = input
            .mapIndexed { i, c -> Pair(track(i), c) }
            .groupBy { it.first }
            .flatMap { it -> it.value.map { it.second } }
            .joinToString("")

    fun getDecryptedData(input: String): String = (0 until input.length)
            .groupBy { track(it) }
            .flatMap { it.value }
            .zip(input.asIterable())
            .sortedBy { it.first }
            .map { it.second }
            .joinToString("")

    private fun track(index: Int) = when {
        isCorrect(index) -> 0
        isCorrect(index - key + 1) -> key -1
        else -> (1 until key).first { isCorrect(index - it) || isCorrect(index - size + it)}
    }

    private fun isCorrect(index: Int): Boolean = index % size == 0
}
