data class Binary(val s: String) {
    val toDecimal: Int = s.fold(0, { accum, char ->
        when (char) {
            '0' -> accum * 2
            '1' -> (accum * 2) + 1
            else -> null
        } ?: 0
    })
}
