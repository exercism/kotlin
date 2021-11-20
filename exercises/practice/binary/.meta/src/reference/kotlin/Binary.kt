object Binary {
    fun toDecimal(s: String): Int {
        return s.fold(0) { accum, char ->
            when (char) {
                '0' -> accum * 2
                '1' -> (accum * 2) + 1
                else -> return 0
            }
        }
    }
}
