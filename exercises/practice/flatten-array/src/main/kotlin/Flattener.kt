object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> = source
        .filterNotNull()
        .flatMap {
            if (it is Collection<*>) {
                return@flatMap flatten(it)
            } else {
                listOf(it)
            }
        }
}
