import java.math.BigInteger

private const val SQUARE_COUNT = 64
private const val INVALID_SQUARE_NUMBER_MESSAGE = "Only integers between 1 and $SQUARE_COUNT (inclusive) are allowed"

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number > 0)             { INVALID_SQUARE_NUMBER_MESSAGE }
        require(number <= SQUARE_COUNT) { INVALID_SQUARE_NUMBER_MESSAGE }

        return BigInteger.valueOf(2).pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..SQUARE_COUNT)
            .map { getGrainCountForSquare(it) }
            .reduce { i1, i2 -> i1.add(i2) }
    }

}
