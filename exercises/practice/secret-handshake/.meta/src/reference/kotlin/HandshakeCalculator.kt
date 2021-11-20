object HandshakeCalculator {

    private const val REVERSE_SIGNALS_BIT_POSITION = 4

    fun calculateHandshake(number: Int): List<Signal> {
        val result = Signal.values().filter {
            signal -> isBitSet(signal.ordinal, number)
        }

        if (isBitSet(REVERSE_SIGNALS_BIT_POSITION, number)) {
            return result.asReversed()
        } else {
            return result
        }
    }

    private fun isBitSet(position: Int, number: Int): Boolean {
        return number shr position and 1 == 1
    }

}
