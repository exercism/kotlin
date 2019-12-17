import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.test.Test
import kotlin.test.assertEquals

class DominoesTest {

    @Test
    fun `empty input = empty output`() = Dominoes.formChain().should { haveSize(0) }

    @Test
    fun `singleton input = singleton output`() {
        val input = listOf(Domino(1, 1))
        Dominoes.formChain(input).should { beValidDominoes(input) }
    }

    @Test(ChainNotFoundException::class)
    fun `singleton can't be chained`() {
        Dominoes.formChain(Domino(1, 2))
    }

    @Test
    fun `three elements`() {
        val input = listOf(Domino(1, 2), Domino(3, 1), Domino(2, 3))
        Dominoes.formChain(input).should { beValidDominoes(input) }
    }

    @Test
    fun `can reverse dominoes`() {
        val input = listOf(Domino(1, 2), Domino(1, 3), Domino(2, 3))
        Dominoes.formChain(input).should { beValidDominoes(input) }
    }

    @Test(expected = ChainNotFoundException::class)
    fun `can't be chained`() {
        Dominoes.formChain(Domino(1, 2), Domino(4, 1), Domino(2, 3))
    }

    @Test(expected = ChainNotFoundException::class)
    fun `disconnected - simple`() {
        Dominoes.formChain(Domino(1, 1), Domino(2, 2))
    }

    @Test(expected = ChainNotFoundException::class)
    fun `disconnected - double loop`() {
        Dominoes.formChain(Domino(1, 2), Domino(2, 1), Domino(3, 4), Domino(4, 3))
    }

    @Test(expected = ChainNotFoundException::class)
    fun `disconnected - single isolated`() {
        Dominoes.formChain(Domino(1, 2), Domino(2, 3), Domino(3, 1), Domino(4, 4))
    }

    @Test
    fun `need backtrack`() {
        val input = listOf(
                Domino(1, 2),
                Domino(2, 3),
                Domino(3, 1),
                Domino(2, 4),
                Domino(4, 2))
        Dominoes.formChain(input).should { beValidDominoes(input) }
    }

    @Test
    fun `separate loops`() {
        val input = listOf(
                Domino(1, 2),
                Domino(2, 3),
                Domino(3, 1),
                Domino(1, 1),
                Domino(2, 2),
                Domino(3, 3))
        Dominoes.formChain(input).should { beValidDominoes(input) }
    }

    @Test
    fun `nine elements`() {
        val input = listOf(
                Domino(1, 2),
                Domino(5, 3),
                Domino(3, 1),
                Domino(1, 2),
                Domino(2, 4),
                Domino(1, 6),
                Domino(2, 3),
                Domino(3, 4),
                Domino(5, 6))
        Dominoes.formChain(input).should { beValidDominoes(input) }
    }

    private fun List<Domino>.should(what: DominoListAsserter.() -> Unit) = what(DominoListAsserter(this))

    private class DominoListAsserter(private val outputDominoes: List<Domino>) {

        fun haveSize(n: Int) = assertEquals(n, outputDominoes.size)

        fun beValidDominoes(inputDominoes: List<Domino>) {
            haveSameDominoesAs(inputDominoes)
            haveMatchingEnds()
            haveConsecutiveDominoes()
        }

        private fun haveSameDominoesAs(inputDominoes: List<Domino>) {
            val errorMessage = "The number of dominoes in the input list (${inputDominoes.size}) needs to match the number of dominoes in the output chain (${outputDominoes.size})"
            assertEquals(inputDominoes.size, outputDominoes.size, errorMessage)
            inputDominoes.forEach { domino ->
                val inputFrequency: Int = dominoFrequency(inputDominoes, domino)
                val outputFrequency: Int = dominoFrequency(outputDominoes, domino)
                val frequencyErrorMessage = "The frequency of domino (${domino.left}, ${domino.right}) in the input is ($inputFrequency), but ($outputFrequency) in the output."
                assertEquals(inputFrequency, outputFrequency, frequencyErrorMessage)
            }
        }

        private fun haveMatchingEnds() {
            val leftValueOfFirstDomino = outputDominoes.first().left
            val rightValueOfLastDomino = outputDominoes.last().right
            val errorMessage = "The left value of the first domino ($leftValueOfFirstDomino) needs to match the right value of the last domino ($rightValueOfLastDomino)."
            assertEquals(leftValueOfFirstDomino, rightValueOfLastDomino, errorMessage)
        }

        private fun haveConsecutiveDominoes() {
            (0 until outputDominoes.size - 1).forEach { i ->
                val rightValueOfIthDomino = outputDominoes[i].right
                val leftValueOfNextDomino = outputDominoes[i + 1].left
                val errorMessage = "The right value of domino number $i ($rightValueOfIthDomino) needs to match the left value of domino number ${i + 1} ($leftValueOfNextDomino)."
                assertEquals(outputDominoes[i].right, outputDominoes[i + 1].left, errorMessage)
            }
        }

        private fun dominoFrequency(list: List<Domino>, d: Domino) =
                list.count {
                    (it.left == d.left && it.right == d.right) || (it.left == d.right && it.right == d.left)
                }

    }

}
