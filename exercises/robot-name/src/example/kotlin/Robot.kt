import java.util.*

class Robot {

    companion object {
        private val alphabet = ('A'..'Z').toList()
        private val numbers = (0..9).toList()

        private val random = Random()
        private fun <T : Any> random(list: List<T>): Sequence<T> = generateSequence { list[random.nextInt(list.size)] }
    }

    var name: String = makeName()
        private set

    fun reset() {
        name = makeName()
    }

    private fun makeName() = prefix() + suffix()
    private fun prefix() = random(alphabet).take(2).joinToString("")
    private fun suffix() = random(numbers).take(3).joinToString("")
}
