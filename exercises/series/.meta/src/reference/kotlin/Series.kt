object Series {
    fun Char.toDigitValue() = this.toInt() - '0'.toInt()

    fun slices(n: Int, s: String): List<List<Int>> = s.dropLast(n - 1).mapIndexed { index, c -> s.subSequence(index, index + n).map { it.toDigitValue() } }
}
