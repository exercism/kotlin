enum class Plant(private val code : Char) {
    VIOLETS('V'),
    RADISHES('R'),
    CLOVER('C'),
    GRASS('G');

    companion object {

        fun getPlant(plantCode: Char): Plant = values().first { it.code == plantCode }

    }
}