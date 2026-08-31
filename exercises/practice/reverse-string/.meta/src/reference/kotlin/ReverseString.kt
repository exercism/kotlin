import java.text.BreakIterator

fun reverse(input: String): String {
    val iterator = BreakIterator.getCharacterInstance()
    iterator.setText(input)

    val graphemes = mutableListOf<String>()
    var start = iterator.first()
    var end = iterator.next()

    while (end != BreakIterator.DONE) {
        graphemes.add(input.substring(start, end))
        start = end
        end = iterator.next()
    }

    return graphemes.asReversed().joinToString("")
}
