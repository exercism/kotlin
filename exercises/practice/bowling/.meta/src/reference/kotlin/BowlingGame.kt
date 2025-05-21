class BowlingGame {
    private var builder = Frame.Builder()
    private val frames = mutableListOf<Frame>()

    private val isLastFrame: Boolean
        get() = frames.size == 11 || (frames.size == 10 && !frames[9].isStrike)

    private val isGameOver: Boolean
        get() = when {
            frames.size < 10 -> false
            frames.size == 10 -> !frames[9].isSpare
            frames.size == 11 -> !frames[9].isStrike || !frames[10].isStrike
            else -> true
        }

    fun roll(pins: Int) {
        if(isGameOver) {
            throw IllegalStateException("Cannot roll after game is over")
        }
        builder.withRoll(pins);
        if (builder.isComplete) {
            frames.add(builder.build());
            builder = Frame.Builder();
        } else if (isLastFrame) {
            frames.add(builder.build());
        }
    }

    fun score(): Int {
        if(!isGameOver) {
            throw IllegalStateException("Score cannot be taken until the end of the game")
        }
        return (0 until 10).sumOf { index ->
            val current = frames[index]
            val next = frames.getOrElse(index + 1) { Frame.EMPTY }
            val nextNext = frames.getOrElse(index + 2) { Frame.EMPTY }
            current.score(next, nextNext)
        }
    }
}
