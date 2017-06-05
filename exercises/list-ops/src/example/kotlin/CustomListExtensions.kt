fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val result = mutableListOf<T>()
    result.addAll(this)
    result.addAll(list)
    return result
}

fun <T> List<List<T>>.customConcat(): List<T> {
    val result = mutableListOf<T>()
    forEach { result.addAll(it) }
    return result
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    forEach { if (predicate(it)) { result.add(it) } }
    return result
}

val <T> List<T>.customSize: Int
    get() = size

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    val result = mutableListOf<U>()
    forEach { result.add(transform(it)) }
    return result
}

fun <T> List<T>.customFoldLeft(initial: T, accumulator: (T, T) -> T): T {
    if (isEmpty()) return initial
    return accumulator(dropLast(1).customFoldLeft(initial, accumulator), last())
}

fun <T> List<T>.customFoldRight(initial: T, accumulator: (T, T) -> T): T {
    if (isEmpty()) return initial
    return accumulator(drop(1).customFoldRight(initial, accumulator), first())
}

fun <T> List<T>.customReverse(): List<T> {
    val result = mutableListOf<T>()
    forEach { result.add(0, it) }
    return result
}
