object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int) =
            with(factors.filter { it != 0 }) {
                (1 until limit).filter { x -> any { y -> x.isMultipleOf(y) } }.sum()
            }
}

fun Int.isMultipleOf(y: Int) = this % y == 0
