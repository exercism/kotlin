import YachtCategory.*

object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int = when (category) {
        YACHT -> if (dices.distinct().size == 1) 50 else 0
        ONES -> dices.filter { it == 1 }.sum()
        TWOS -> dices.filter { it == 2 }.sum()
        THREES -> dices.filter { it == 3 }.sum()
        FOURS -> dices.filter { it == 4 }.sum()
        FIVES -> dices.filter { it == 5 }.sum()
        SIXES -> dices.filter { it == 6 }.sum()
        FULL_HOUSE -> {
            val counts = dices.groupBy { it }.map { it.key to it.value.count() }.sortedByDescending { it.second }
            if (counts.size >= 2 && counts[0].second >= 3 && counts[1].second >= 2) {
                counts[0].first * counts[0].second + counts[1].first * counts[1].second
            } else 0
        }
        FOUR_OF_A_KIND -> dices.groupBy { it }.filter { it.value.size >= 4 }.keys.sumOf { it * 4 }
        LITTLE_STRAIGHT -> if ((1..5).all { dices.contains(it) }) 30 else 0
        BIG_STRAIGHT -> if ((2..6).all { dices.contains(it) }) 30 else 0
        CHOICE -> dices.sum()
    }
}
