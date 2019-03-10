object Series {
    fun Char.toDigitValue() = this.toInt() - '0'.toInt()

    fun slices(n: Int, s: String): List<List<Int>> =
        when {
            (n > s.length) -> throw IllegalArgumentException("slice length cannot be greater than series length")
            (n == 0) -> throw IllegalArgumentException("slice length cannot be zero")
            (n < 0) -> throw IllegalArgumentException("slice length cannot be negative")
            (s == "") -> throw IllegalArgumentException("series cannot be empty")
            else -> s.dropLast(n - 1)
                .mapIndexed { index, c ->
                    s.subSequence(index, index + n).map { it.toDigitValue() }
                }
        }
}
