import java.util.*

class DiamondPrinter {

    companion object {
        private const val A_INT = 'A'.code

        private fun blank(length: Int): String {
            return Collections.nCopies(length, " ").joinToString("")
        }
    }

    fun printToList(chr: Char): List<String> {
        val nRows = 2 * (chr.code - A_INT) + 1

        val result = mutableListOf<String>()

        // Populate the top rows.
        for (nRow in 0 until (nRows + 1) / 2) {
            val rowChr = (A_INT + nRow).toChar()

            val leftHalfOfRow = blank((nRows - 1) / 2 - nRow) + rowChr + blank(nRow)
            val rightHalfOfRow = leftHalfOfRow.reversed().drop(1)
            val fullRow = "$leftHalfOfRow$rightHalfOfRow"

            result.add(fullRow)
        }

        // Populate the bottom rows by 'reflecting' all rows above the middle row.
        result.addAll(result.reversed().drop(1))

        return result
    }

}
