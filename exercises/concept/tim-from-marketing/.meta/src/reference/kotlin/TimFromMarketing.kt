import java.util.Locale

fun printBadge(id: Int?, name: String?, department: String?): String {
    val worksAt: String = department?.uppercase(Locale.ENGLISH) ?: "OWNER"

    return if (id != null) {"[$id] - $name - $worksAt"} else {"$name - $worksAt"}
}