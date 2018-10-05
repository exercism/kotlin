class RunLengthEncoding {

    fun encode(input: String): String {
        var result = ""
        var s = input
        while (s.isNotEmpty()) {
            val chunk = s.takeWhile { it == s.first() }
            result += if (chunk.length == 1) chunk.first() else chunk.length.toString() + chunk.first()
            s = s.substring(chunk.length)
        }
        return result
    }

    fun encode2(input: String): String {
        var result = ""
        var last = input.first();
        var lastIdx = 0
        for (i in 0 until input.length) {
            val c = input[i]
            if (last != c || i==input.length-1) {
                val chunkLen = i - lastIdx
                result += if (chunkLen == 1) last else chunkLen.toString()+last
                last = c
                lastIdx = i
            }
        }
        return result
    }

    fun decode(s: String): String =
            Regex("(\\d+)?(\\D)")
                    .findAll(s)
                    .map { it.groupValues[2].repeat(it.groupValues[1].toIntOrNull() ?: 1) }
                    .joinToString("")

}
