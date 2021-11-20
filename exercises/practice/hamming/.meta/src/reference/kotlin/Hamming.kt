object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        require(leftStrand.length == rightStrand.length) { "left and right strands must be of equal length" }

        val commonPairs = leftStrand.zip(rightStrand)
        return commonPairs.count { it.first != it.second }
    }
}
