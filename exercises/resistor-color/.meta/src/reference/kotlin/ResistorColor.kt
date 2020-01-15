object ResistorColor {

    private val colors = listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")

    fun colorCode(input: String): Int = colors.indexOf(input)

    fun colors() = colors
}
