class School {

    private val database = mutableMapOf<Int, List<String>>()

    fun add(student: String, grade: Int) {
        database[grade] = (grade(grade) + student).sorted()
    }

    fun grade(grade: Int) = database[grade] ?: listOf()

    fun roster() = database.toSortedMap().map { it.value }.flatten()

}
