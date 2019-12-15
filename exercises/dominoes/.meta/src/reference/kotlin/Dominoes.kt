import java.util.*

class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int)

object Dominoes {

    fun formChain(vararg inputDominoes: Domino): List<Domino> = formChain(inputDominoes.toList())

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        if (inputDominoes.isEmpty()) {
            return emptyList()
        }
        return formPartialChain(ArrayList(), inputDominoes)
    }

    private fun isValidChain(chain: ArrayList<Domino>): Boolean {
        return isValidPartialChain(chain) && chain.first().left == chain.last().right
    }

    private fun isValidPartialChain(chain: ArrayList<Domino>): Boolean {
        for (i in 0 until chain.size - 1) {
            if (chain[i].right != chain[i + 1].left) {
                return false
            }
        }
        return true
    }

    private fun formPartialChain(current: ArrayList<Domino>, remaining: List<Domino>): ArrayList<Domino> {
        if (remaining.isEmpty()) {
            if (isValidChain(current)) {
                return current
            } else {
                throw ChainNotFoundException("No domino chain found.")
            }
        }
        remaining.indices.forEach { i ->
            val newRemaining = ArrayList(remaining)
            newRemaining.removeAt(i)

            val newChainA = ArrayList(current)
            newChainA.add(remaining[i])

            val newChainB = ArrayList(current)
            newChainB.add(Domino(remaining[i].right, remaining[i].left))

            if (isValidPartialChain(newChainA)) {
                try {
                    return formPartialChain(newChainA, newRemaining)
                } catch (e: ChainNotFoundException) {
                    //This path does not have a valid chain
                }
            }
            if (isValidPartialChain(newChainB)) {
                try {
                    return formPartialChain(newChainB, newRemaining)
                } catch (e: ChainNotFoundException) {
                    //This path doesn't have a valid chain
                }
            }
        }

        throw ChainNotFoundException("No domino chain found.")
    }
}
