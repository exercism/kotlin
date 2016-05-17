object Strain {
    fun <T> keep(collection: List<T>, predicate: (T) -> Boolean) = collection.filter(predicate)
    fun <T> discard(collection: List<T>, predicate: (T) -> Boolean) = collection.filterNot(predicate)
}
