object ETL {

    fun transform(old: Map<Int, Collection<Char>>): Map<Char, Int> {
        return old.flatMap { mapEntry ->
            mapEntry.value.map { word ->
                Pair(word.lowercaseChar(), mapEntry.key)
            }
        }.toMap()
    }

}
