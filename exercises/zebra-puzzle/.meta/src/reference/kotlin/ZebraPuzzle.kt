class ZebraPuzzle {

    private var red = 0
    private var green = 0
    private var ivory = 0
    private var yellow = 0
    private var blue = 0

    private var english = 0
    private var spaniard = 0
    private var ukrainian = 0
    private var japanese = 0
    private var norwegian = 0

    private var coffee = 0
    private var tea = 0
    private var milk = 0
    private var orangejuice = 0
    private var water = 0

    private var oldgold = 0
    private var kools = 0
    private var chesterfields = 0
    private var luckystrike = 0
    private var parliaments = 0

    private var dog = 0
    private var snails = 0
    private var fox = 0
    private var horse = 0
    private var zebra = 0

    private lateinit var nationalityNames: Map<Int, String>
    private lateinit var waterDrinker: String
    private lateinit var zebraOwner: String

    companion object {
        private const val FIRST = 1
        private const val MIDDLE = 3

        private fun isJustRightOf(neighbourA: Int, neighbourB: Int): Boolean {
            return neighbourA - 1 == neighbourB
        }

        private fun nextTo(neighbourA: Int, neighbourB: Int): Boolean {
            return isJustRightOf(neighbourA, neighbourB) || isJustRightOf(neighbourB, neighbourA)
        }

        private fun allHouseAssignmentPermutations() = HeapsPermutation.permute(1, 2, 3, 4, 5)
    }

    init {
        solve()
    }

    fun drinksWater() = waterDrinker

    fun ownsZebra() = zebraOwner

    private fun solve() {
        allHouseAssignmentPermutations().forEach { solveHouseColors(it) }
    }

    private fun solveHouseColors(permutation: IntArray) {
        red = permutation[0]
        green = permutation[1]
        ivory = permutation[2]
        yellow = permutation[3]
        blue = permutation[4]

        if (isJustRightOf(green, ivory)) {
            allHouseAssignmentPermutations().forEach { solveNationalities(it) }
        }
    }

    private fun solveNationalities(permutation: IntArray) {
        english = permutation[0]
        spaniard = permutation[1]
        ukrainian = permutation[2]
        japanese = permutation[3]
        norwegian = permutation[4]

        if (red == english && norwegian == FIRST && nextTo(norwegian, blue)) {
            // record names for later use
            nationalityNames = mapOf(
                    english to "Englishman",
                    spaniard to "Spaniard",
                    ukrainian to "Ukrainian",
                    japanese to "Japanese",
                    norwegian to "Norwegian")
            allHouseAssignmentPermutations().forEach { solveBeverages(it) }
        }
    }

    private fun solveBeverages(permutation: IntArray) {
        coffee = permutation[0]
        tea = permutation[1]
        milk = permutation[2]
        orangejuice = permutation[3]
        water = permutation[4]

        if (coffee == green && ukrainian == tea && milk == MIDDLE) {
            allHouseAssignmentPermutations().forEach { solveCigars(it) }
        }
    }

    private fun solveCigars(permutation: IntArray) {
        oldgold = permutation[0]
        kools = permutation[1]
        chesterfields = permutation[2]
        luckystrike = permutation[3]
        parliaments = permutation[4]

        if (kools == yellow && luckystrike == orangejuice && japanese == parliaments) {
            allHouseAssignmentPermutations().forEach { solvePets(it) }
        }
    }

    private fun solvePets(permutation: IntArray) {
        dog = permutation[0]
        snails = permutation[1]
        fox = permutation[2]
        horse = permutation[3]
        zebra = permutation[4]

        if (spaniard == dog && oldgold == snails && nextTo(chesterfields, fox) && nextTo(kools, horse)) {
            waterDrinker = nationalityNames[water] ?: error("Water drinker not found!")
            zebraOwner = nationalityNames[zebra] ?: error("Zebra owner not found!")
        }
    }

}
