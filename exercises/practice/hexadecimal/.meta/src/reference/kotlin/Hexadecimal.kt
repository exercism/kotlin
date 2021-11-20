object Hexadecimal {
    private val hexChars = ('0'..'9') + ('a'..'f')

    fun toDecimal(s: String): Int {
        return s.lowercase().fold(0) { accum, char ->
            when (char) {
                in hexChars -> hexChars.indexOf(char) + (accum * 16)
                else -> return 0
            }
        }
    }
}
