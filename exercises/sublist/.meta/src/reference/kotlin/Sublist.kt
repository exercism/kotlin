fun <T> List<T>.relationshipTo(list: List<T>): Relationship {
    if (this == list)         return Relationship.EQUAL
    if (this.isSublist(list)) return Relationship.SUBLIST
    if (list.isSublist(this)) return Relationship.SUPERLIST

    return Relationship.UNEQUAL
}

private fun <T> List<T>.isSublist(list: List<T>): Boolean {
    val listSize = list.size

    if (size > listSize) return false

    val numberOfSublistCandidates = listSize - size + 1

    return (0 until numberOfSublistCandidates).any { startIndex ->
        list.subList(startIndex, startIndex + size) == this
    }
}
