object Accumulate {
    fun <T, R> accumulate(collection: List<T>, function: (T) -> R): List<R> {
        val retVal = mutableListOf<R>()
        for(item in collection) {
            retVal.add(function.invoke(item))
        }
        return retVal
    }
}
