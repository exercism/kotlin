class Robot {
    companion object {
        val existingNames = mutableSetOf<String>()
    }

    private var _name: String = generateName()
    val name: String
        get() = _name

    fun reset() {
        _name = generateName()
    }

    private tailrec fun generateName(): String {
        val randomLetters = ('A'..'Z').randomSample(2)
        val numbers = (0..9).randomSample(3)
        val newName = (randomLetters + numbers).joinToString("")

        return when {
            existingNames.add(newName) -> newName
            else -> generateName()
        }
    }

    private fun <T> Iterable<T>.randomSample(number: Int): Iterable<T> =
        (0 until number).map { this.shuffled()[0] }
}
