class KindergartenGarden(private val diagram: String) {

    val students = listOf(
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry")

    val plants: Map<Char, String> = mapOf(
            'V' to "violets",
            'R' to "radishes",
            'C' to "clover",
            'G' to "grass")

    fun getPlantsOfStudent(student: String): List<String> {
        val idx = students.indexOf(student)
        return diagram
                .split("\n") // split into two lines
                .map { it.substring(idx * 2, idx * 2 + 2) } // the two letters of that student in each line
                .joinToString("") // merge the two letters of each diagram line into one string
                .map { plants[it]!! } // lookup the plant names by the given letters
    }
}
