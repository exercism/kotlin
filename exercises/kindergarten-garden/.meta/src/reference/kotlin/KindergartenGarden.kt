class KindergartenGarden(private val garden: String) {

    val students = listOf(
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry")

    fun getPlantsOfStudent(student: String): List<Plant> {
        val idx = students.indexOf(student)
        return garden
                .split("\n")
                .map { it.substring(idx*2 .. idx*2+2) }
                .joinToString("")
                .map { Plant.getPlant(it) }
    }
}
