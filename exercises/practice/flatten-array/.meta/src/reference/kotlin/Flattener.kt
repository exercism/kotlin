object Flattener {

    fun flatten(unflattened: Collection<Any?>): List<Any> {
        return unflattened.filterNotNull().fold(mutableListOf()) { accum, element -> accum.addFlattened(element); accum }
    }

    fun MutableCollection<Any>.addFlattened(item: Any) = if (item is Collection<*>) this.addAll(flatten(item)) else this.add(item)

}
