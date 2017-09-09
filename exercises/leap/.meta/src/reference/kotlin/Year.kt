data class Year(private val year: Int) {
    val isLeap: Boolean by lazy { divisibleBy(4) && (divisibleBy(400) || !divisibleBy(100)) }

    private fun divisibleBy(i: Int) = year % i == 0
}
