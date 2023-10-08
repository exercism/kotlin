object HandshakeCalculator {

    fun calculateHandshake(number: Int): List<Signal> {
        val signals = Signal.values()
            .filter { number shr it.ordinal and 1 == 1 }

        return if (number shr 4 and 1 == 1) signals.asReversed()
        else signals
    }
}