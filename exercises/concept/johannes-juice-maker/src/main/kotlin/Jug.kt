/**
 * Represents a jug to hold the juice from the maker.
 *
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
class Jug {
    private var extended : Boolean = false

    fun extend() {
        extended = true
    }

    fun isExtended(): Boolean {
        return extended
    }
}
