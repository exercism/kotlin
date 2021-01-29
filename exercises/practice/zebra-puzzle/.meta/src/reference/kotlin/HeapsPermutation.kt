/** Heap's Algorithm as seen on https://en.wikipedia.org/wiki/Heap%27s_algorithm. */
object HeapsPermutation {

    fun permute(vararg input: Int): Set<IntArray> = permute(input.size, input)

    private fun permute(k: Int, input: IntArray): Set<IntArray> =
            (0 until k).flatMap { i ->
                if (k == 1) {
                    // Return a new object, as the received one is a mutable object which will be modified in swap()
                    setOf(input.copyOf())
                } else {
                    val roundResults = permute(k - 1, input)
                    if (isEven(k)) {
                        swap(input, i, k - 1)
                    } else {
                        swap(input, 0, k - 1)
                    }
                    roundResults
                }
            }.toSet()

    private fun isEven(i: Int) = ((i % 2) == 0)

    private fun swap(input: IntArray, a: Int, b: Int) {
        val tmp = input[a]
        input[a] = input[b]
        input[b] = tmp
    }
}
