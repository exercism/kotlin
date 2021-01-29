object RomanNumerals {

    private val numeralValues = listOf(
            Pair(1000, "M"),
            Pair(900, "CM"),
            Pair(500, "D"),
            Pair(400, "CD"),
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(50, "L"),
            Pair(40, "XL"),
            Pair(10, "X"),
            Pair(9, "IX"),
            Pair(5, "V"),
            Pair(4, "IV"),
            Pair(1, "I")
    )


    private tailrec fun fromNumber(n: Int, numerals: String): String {
        val numeralPair = numeralValues.find { it.first <= n }
        if (numeralPair != null) {
            return fromNumber(n - numeralPair.first, numerals + numeralPair.second)
        }

        return numerals
    }

    fun value(n: Int) = fromNumber(n, "")
}
