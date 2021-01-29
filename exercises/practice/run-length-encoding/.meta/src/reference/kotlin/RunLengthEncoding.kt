import java.util.regex.Pattern

object RunLengthEncoding {

    private val encodePattern = Pattern.compile("""([ a-zA-Z])\1*""")
    private val decodePattern = Pattern.compile("""(|\d+)([ a-zA-Z])""")

    fun encode(input: String): String {
        val matcher = encodePattern.matcher(input)
        val matcherSeq = generateSequence { if (matcher.find()) matcher else null }
        return matcherSeq.joinToString("") {
            val characters = it.group(0)
            val count = if (characters.length == 1) "" else characters.length.toString()
            count + characters.first()
        }
    }

    fun decode(input: String): String {
        val matcher = decodePattern.matcher(input)
        val matcherSeq = generateSequence { if (matcher.find()) matcher else null }
        return matcherSeq.joinToString("") {
            val count = if (it.group(1) == "") 1 else it.group(1).toInt()
            val character = it.group(2)
            character.repeat(count)
        }
    }
}
