class CustomSet(vararg elements: Int) {

    private val set: MutableSet<Int> = elements.toMutableSet()

    fun isEmpty(): Boolean = set.isEmpty()

    fun isSubset(other: CustomSet): Boolean = other.set.containsAll(set)

    fun isDisjoint(other: CustomSet): Boolean = set.intersect(other.set).isEmpty()

    fun contains(other: Int): Boolean = set.contains(other)

    fun intersection(other: CustomSet): CustomSet = apply { set.retainAll(other.set) }

    fun add(other: Int) = set.add(other)

    override fun equals(other: Any?): Boolean = (other != null && other is CustomSet && set == other.set)

    operator fun plus(other: CustomSet): CustomSet = apply { set.addAll(other.set) }

    operator fun minus(other: CustomSet): CustomSet = apply { set.removeAll(other.set) }

}
