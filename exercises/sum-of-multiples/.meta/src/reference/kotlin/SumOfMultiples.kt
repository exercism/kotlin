object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int =
            (1 until limit).filter { x -> factors.any { y -> x.isMultipleOf(y) } }.sum()
}

fun Int.isMultipleOf(y: Int) = this % y == 0
