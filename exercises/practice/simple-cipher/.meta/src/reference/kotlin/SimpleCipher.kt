import java.util.Random

data class Cipher(val key: String) {

    constructor() : this(generateRandomKey())

    init {
        require(key.matches(Regex("^[a-z]+$"))) { "Invalid key: $key" }
    }

    companion object {
        val random = Random()
        val alphabet = ('a'..'z').toList()

        private fun generateRandomKey() = generateSequence { alphabet[random.nextInt(alphabet.size)] }.take(100).joinToString("")
    }

    fun encode(s: String): String = s.mapIndexed { index, char ->  encodeChar(char, index)}.joinToString("")
    fun decode(s: String): String = s.mapIndexed { index, char ->  decodeChar(char, index)}.joinToString("")

    private fun encodeChar(character: Char, index: Int): Char {
        var alphaIdx = alphabet.indexOf(character) + alphabet.indexOf(key[index % key.length])
        if(alphaIdx >= alphabet.size) alphaIdx -= alphabet.size

        return alphabet[alphaIdx]
    }

    private fun decodeChar(character: Char, index: Int): Char {
        var alphaIdx = alphabet.indexOf(character) - alphabet.indexOf(key[index % key.length])
        if(alphaIdx < 0) alphaIdx += alphabet.size

        return alphabet[alphaIdx]
    }
}
