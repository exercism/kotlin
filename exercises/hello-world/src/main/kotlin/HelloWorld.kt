/**
 * Simple HelloWorld singleton class as defined by the `Kotlin object keyword`.
 * See: https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
 *
 * As an alternative one could create a class such as:
 * ```
 * class HelloWorld(name: String? = "Default Value") {
 *     fun hello(): String {
 *
 *     }
 * }
 * ```
 * Resulting in a call such as: `HelloWorld("Bob").hello()`
 * See: https://kotlinlang.org/docs/reference/classes.html#constructors
 *
 * In Kotlin we make objects defined as nullable via the trailing `?`, if you try
 * to assign a null value to any value that isn't nullable a compilation error is thrown.
 * Kotlin makes sure you are accessing nullable values safely and provides null safe calls
 * and the use of the elvis operator. See: https://kotlinlang.org/docs/reference/null-safety.html
 *
 * You may provide default values on methods, so if an argument is omitted the default is used.
 * See: https://kotlinlang.org/docs/reference/functions.html#default-arguments
 *
 * Kotlin provides String interpolation to make String formatting simple.
 * See: https://kotlinlang.org/docs/reference/idioms.html#string-interpolation
 */
object HelloWorld {
    fun hello(name: String? = "Default Argument"): String {

    }
}
