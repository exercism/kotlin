object EliudsEggs {

    fun eggCount(number: Int): Int{
        val binary = number.toString()
        binary.chunked(1)
        .mapIndexedNotNull { index, value -> index.takeIf { value == "1" } }
        .map { 2.0.pow(it.toDouble()).toInt()}
        .fold(0){acc,i -> acc + i}
    }
}
