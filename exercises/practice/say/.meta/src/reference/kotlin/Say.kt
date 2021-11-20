class NumberSpeller {

    companion object {
        val wordMap = mapOf<Long, String>(
                Pair( 0, "zero"     ),
                Pair( 1, "one"      ),
                Pair( 2, "two"      ),
                Pair( 3, "three"    ),
                Pair( 4, "four"     ),
                Pair( 5, "five"     ),
                Pair( 6, "six"      ),
                Pair( 7, "seven"    ),
                Pair( 8, "eight"    ),
                Pair( 9, "nine"     ),
                Pair(10, "ten"      ),
                Pair(11, "eleven"   ),
                Pair(12, "twelve"   ),
                Pair(13, "thirteen" ),
                Pair(14, "fourteen" ),
                Pair(15, "fifteen"  ),
                Pair(16, "sixteen"  ),
                Pair(17, "seventeen"),
                Pair(18, "eighteen" ),
                Pair(19, "nineteen" ),
                Pair(20, "twenty"   ),
                Pair(30, "thirty"   ),
                Pair(40, "forty"    ),
                Pair(50, "fifty"    ),
                Pair(60, "sixty"    ),
                Pair(70, "seventy"  ),
                Pair(80, "eighty"   ),
                Pair(90, "ninety"   )
        )

        const val te = 10
        const val hu = 100
        const val th = 1000
        const val mi = 1000000
        const val bi = 1000000000
        const val tr = 1000000000000
    }

    fun say(input: Long): String {
        require(input >= 0) { "Input must be non-negative" }
        require(input < tr)  { "Input must be less than $tr" }

        if (input < 20) return wordMap[input]!!

        if (input < hu) {
            return if (input % te == 0L) {
                wordMap[input]!!
            } else {
                "${wordMap[input / te * te]}-${wordMap[input % te]!!}"
            }
        }

        if (input < th) {
            return if (input % hu == 0L) {
                "${wordMap[input / hu]!!} hundred"
            } else {
                "${wordMap[input / hu]!!} hundred ${say(input % hu)}"
            }
        }

        if (input < mi) {
            return if (input % th == 0L) {
                "${say(input / th)} thousand"
            } else {
                "${say(input / th)} thousand ${say(input % th)}"
            }
        }

        if (input < bi) {
            return if (input % mi == 0L) {
                "${say(input / mi)} million"
            } else {
                "${say(input / mi)} million ${say(input % mi)}"
            }
        }

        return if (input % bi == 0L) {
            "${say(input / bi)} billion"
        } else {
            "${say(input / bi)} billion ${say(input % bi)}"
        }
    }

}
