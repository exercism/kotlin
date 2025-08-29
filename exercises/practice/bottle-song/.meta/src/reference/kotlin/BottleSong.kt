object BottleSong {
    fun recite(startBottles : Int, takeDown : Int) : String {
        return (0..(takeDown - 1))
            .joinToString(separator = "\n\n") {
                verse(startBottles - it)
            }
    }

    private fun verse(bottles : Int) : String {
        val start = verseStart(bottles)
        return """
            $start
            $start
            And if one green bottle should accidentally fall,
            ${verseEnd(bottles - 1)}
        """.trimIndent()
    }

    private fun verseStart(bottles : Int) : String {
        return if (bottles > 1) {
            "${toWord(bottles)} green bottles hanging on the wall,"
        } else {
            "One green bottle hanging on the wall,"
        }
    }

    private fun verseEnd(bottles : Int) : String {
        return when(bottles) {
            0 -> "There'll be no green bottles hanging on the wall."
            1 -> "There'll be ${toWord(bottles).lowercase()} green bottle hanging on the wall."
            else -> "There'll be ${toWord(bottles).lowercase()} green bottles hanging on the wall."
        }
    }

    private fun toWord(num : Int) : String {
        return when(num) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            4 -> "Four"
            5 -> "Five"
            6 -> "Six"
            7 -> "Seven"
            8 -> "Eight"
            9 -> "Nine"
            10 -> "Ten"
            else -> throw IllegalArgumentException("Number $num not supported")
        }
    }
}
