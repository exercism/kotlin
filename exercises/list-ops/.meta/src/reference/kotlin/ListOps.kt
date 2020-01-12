fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val result = mutableListOf<T>()
    result.addAll(this)
    result.addAll(list)
    return result
}

fun List<Any>.customConcat(): List<Any> {
    val result = mutableListOf<Any>()
    forEach { result.add(it) }
    fun flatten(list: List<Any?>): List<Any> = list.flatMap {
        if (it is List<Any?>) flatten(it)
        else listOf(it)
    }.filterNotNull()
    return flatten(result)
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    forEach { if (predicate(it)) { result.add(it) } }
    return result
}

val List<Any>.customSize: Int
    get() = size

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    val result = mutableListOf<U>()
    forEach { result.add(transform(it)) }
    return result
}

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    if (isEmpty()) return initial
    return drop(1).customFoldLeft(f(initial, first()), f)
}

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    if (isEmpty()) return initial
    return f(first(), drop(1).customFoldRight(initial, f))
}

fun <T> List<T>.customReverse(): List<T> {
    val result = mutableListOf<T>()
    forEach { result.add(0, it) }
    return result
}
