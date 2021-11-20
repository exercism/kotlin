object Strain {
    fun <T> keep(collection: List<T>, predicate: (T) -> Boolean): List<T> {
        val filteredCollection = mutableListOf<T>()
        collection.forEach { if (predicate(it)) filteredCollection.add(it) }

        return filteredCollection
    }

    fun <T> discard(collection: List<T>, predicate: (T) -> Boolean) = keep(collection) { value -> !predicate(value) }
}
