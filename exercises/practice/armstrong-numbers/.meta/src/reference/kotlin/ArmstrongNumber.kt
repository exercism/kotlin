import java.math.BigInteger

object ArmstrongNumber {

    fun check(input: Long): Boolean {
        val str = input.toString()
        val inputLength = str.length
        val calculated = str
            .map { Character.getNumericValue(it) } // digit character to its numeric (not ASCII!) value
            .sumOf { BigInteger.valueOf(it.toLong()).pow(inputLength).toLong() } // calculate digit^inputLength

        return input == calculated
    }

}
