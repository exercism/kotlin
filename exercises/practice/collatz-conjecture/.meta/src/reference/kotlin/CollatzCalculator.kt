object CollatzCalculator {

    fun computeStepCount(start: Int): Int {
        require(start > 0) { "Only natural numbers are allowed" }

        if (start == 1) return 0

        val next = if (start % 2 == 0) start / 2 else 3 * start + 1
        return 1 + computeStepCount(next)
    }

}
