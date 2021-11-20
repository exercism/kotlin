import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val sanitized = plaintext.filter { it.isLetterOrDigit() }.lowercase()
        if (sanitized.isEmpty()) {
            return ""
        }

        val (cols, rows) = calcSquare(sanitized.length)

        return (0 until cols * rows)
                .map { i -> (i % rows) * cols + (i / rows) }
                .map { cursor -> if (cursor < sanitized.length) sanitized[cursor] else ' ' }
                .joinToString("")
                .chunked(rows)
                .joinToString(" ")
    }

    private fun calcSquare(size: Int): Pair<Int, Int> {
        val sq = sqrt(size.toDouble()).toInt()
        return when {
            sq * sq >= size -> Pair(sq, sq) // 9 => 3 * 3
            (sq + 1) * sq >= size -> Pair(sq + 1, sq) // 54 => 8 * 7
            else -> Pair(sq + 1, sq + 1) // 8 => 3 * 3
        }
    }
}
