object AffineCipher {

    /** Number of characters in the alphabet (a-z). */
    private const val ALPHABET_SIZE = 26

    /** Number of space separated groups in the encoded text. */
    private const val GROUP_SIZE = 5

    fun encode(cipheredMessage: String, a: Int, b: Int): String {
        return translate(cipheredMessage, a, b, encode = true)
                .windowed(GROUP_SIZE, GROUP_SIZE, true)
                .joinToString(" ")
    }

    fun decode(cipheredMessage: String, a: Int, b: Int): String {
        return translate(cipheredMessage, a, b, encode = false)
    }

    private fun modularMultiplicativeInverse(a: Int): Int =
            (1..ALPHABET_SIZE)
                    .firstOrNull { ((a * it) % ALPHABET_SIZE) == 1 }
                    ?: 1

    private fun translate(text: String, a: Int, b: Int, encode: Boolean): String {
        val inv = modularMultiplicativeInverse(a)
        require(inv != 1) { "Key A and alphabet size must be coprime!" }

        return text
            .lowercase()
                .mapNotNull { c ->
                    when {
                        c.isDigit() -> c
                        c.isLetter() ->
                            (c - 'a') // the characters alphabetical position, not its ASCII value
                                .let { if (encode) (a * it + b) else (inv * (it - b)) } // the main algorithm
                                .let { 'a' + (it % ALPHABET_SIZE) } // map number to character
                                .let { if (it < 'a') (it + ALPHABET_SIZE) else it } // adjust for negative values
                        else -> null // spaces and the like are ignored
                    }
                }
                .joinToString("")
    }
}
