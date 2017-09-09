object BeerSong {
    val lyrics: String by lazy { verses(99, 0) }

    fun verse(number: Int) = when (number) {
        0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
        1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
        2 -> "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
        in 3..99 -> "$number bottles of beer on the wall, $number bottles of beer.\nTake one down and pass it around, ${number - 1} bottles of beer on the wall.\n"
        else -> throw IllegalArgumentException("Invalid verse number: $number, must be within 0 and 99")
    }

    fun verses(upperBound: Int, lowerBound: Int) = (upperBound downTo lowerBound).map { verse(it) }.joinToString("\n")
}
