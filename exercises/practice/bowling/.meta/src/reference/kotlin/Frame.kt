class Frame(val first: Int, val second: Int) {
    companion object {
        val EMPTY = Frame(0, 0)
    }

    val frameScore: Int
        get() = first + second

    val isStrike: Boolean
        get() = (first == 10)

    val isSpare: Boolean
        get() = (frameScore == 10)

    fun score(next: Frame, nextNext: Frame) = frameScore + when {
        isStrike -> nextNextRoll(next, nextNext) + next.first
        isSpare -> next.first
        else -> 0
    }

    private fun nextNextRoll(next: Frame, nextNext: Frame) =
        if(next.isStrike) { nextNext.first } else { next.second }

    class Builder {
        private val rolls = mutableListOf<Int>()

        val count: Int
            get() = rolls.sum()

        val isStrike: Boolean
            get() = rolls.size == 1 && rolls[0] == 10

        val isComplete: Boolean
            get() = rolls.size == 2 || isStrike

        fun withRoll(pins: Int): Builder {
            if(isComplete) { throw IllegalStateException("Frame complete") }
            if(pins < 0) { throw IllegalStateException("Negative roll is invalid") }
            if(count + pins > 10) { throw IllegalStateException("Pin count exceeds pins on the lane") }
            rolls.add(pins)
            return this
        }

        public fun build(): Frame = when (rolls.size) {
            2 -> Frame(rolls[0], rolls[1])
            1 -> Frame(rolls[0], 0)
            else -> throw AssertionError("Frame has invalid number of rolls: " + rolls.size)
        }
    }
}
