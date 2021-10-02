object Transpose {

    fun transpose(input: List<String>): List<String> =
            (0 until (input.map { it.length }.maxOrNull() ?: 0)).map { x: Int ->
                input.indices.joinToString("") { y: Int ->
                    if (x < input[y].length) {
                        input[y][x].toString()
                    } else {
                        "°"
                    }
                }.trimEnd('°').replace('°', ' ')
            }
}
