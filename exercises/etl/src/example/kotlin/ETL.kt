object ETL {
    fun transform(old: Map<Int, Collection<String>>): Map<String, Int> {
        return old.flatMap { mapEntry -> mapEntry.value.map { word -> Pair(word.toLowerCase(), mapEntry.key) } }.toMap()
    }
}
