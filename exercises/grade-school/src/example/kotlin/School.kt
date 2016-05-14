import java.util.HashMap

class School {

    private val database = mutableMapOf<Int, List<String>>()
    internal fun db() = HashMap(database)

    fun add(student: String, grade: Int) {
        database[grade] = grade(grade) + student
    }

    fun grade(grade: Int) = database[grade] ?: listOf()

    fun sort() = database.toSortedMap().mapValues { it.value.sorted() }

}
