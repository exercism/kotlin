object ResistorColorDuo {
    fun value(vararg colors: Color): Int = 10 * colors[0].ordinal + colors[1].ordinal
}
