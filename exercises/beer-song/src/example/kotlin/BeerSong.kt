object BeerSong {
    val lyrics: String by lazy { verses(99, 0) }

    fun verse(number: Int) = when (number) {
        0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
        1 -> "$number bottle of beer on the wall, $number bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
        2 -> "$number bottles of beer on the wall, $number bottles of beer.\nTake one down and pass it around, ${number - 1} bottle of beer on the wall.\n"
        else -> "$number bottles of beer on the wall, $number bottles of beer.\nTake one down and pass it around, ${number - 1} bottles of beer on the wall.\n"
    }

    fun verses(upperBound: Int, lowerBound: Int) = (upperBound downTo lowerBound).map { verse(it) }.joinToString("\n")
}
