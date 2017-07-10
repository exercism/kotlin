class RotationalCipher(val shiftKey: Int) {

    companion object {
        private val LOWERS = ('a'..'z').toList()
        private val UPPERS = ('A'..'Z').toList()
    }

    fun encode(text: String): String {
        return text.map { char ->
            when (char) {
                in LOWERS -> LOWERS[(LOWERS.indexOf(char) + shiftKey) % LOWERS.size]
                in UPPERS -> UPPERS[(UPPERS.indexOf(char) + shiftKey) % UPPERS.size]
                else      -> char
            }
        }.joinToString("")
    }

}
