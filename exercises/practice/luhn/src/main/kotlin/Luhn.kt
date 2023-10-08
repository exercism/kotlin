
object Luhn {

    fun isValid(candidate: String): Boolean {
        val stripped = candidate.replace(" ", "")
        if (!stripped.all { it.isDigit() }) return false
        if (stripped.length <= 1) return false

        val sumOdd = (stripped.length - 2 downTo 0 step 2)
            .map { stripped[it].digitToInt() }
            .sumOf {
                val sum = it + it
                if (sum > 9) sum - 9
                else sum
            }
        val sumEven = (stripped.length - 1 downTo 0 step 2)
            .sumOf { stripped[it].digitToInt() }

        return (sumOdd + sumEven) % 10 == 0
    }
}