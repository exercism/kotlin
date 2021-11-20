object Isogram {

    fun isIsogram(input: String): Boolean {
        val sanitizedInput = input.lowercase().replace("[.!?\\-\\s]".toRegex(), "")
        val charCounts = sanitizedInput.toList().countBy()
        return !charCounts.any { it.value > 1 }
    }

}


fun <T> Iterable<T>.countBy() : Map<T, Int>  = this.countBy { it }

fun <T, M> Iterable<T>.countBy(transformer: (T) -> M) : Map<M, Int> {
    val emptyMap = mapOf<M, Int>()
    return this.fold(emptyMap) {accumulator, item ->
        val transformedItem = transformer(item)

        accumulator + Pair(transformedItem, accumulator.getOrElse(transformedItem) { 0 } + 1)
    }
}
