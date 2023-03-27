# `fold` on a `List`

```kotlin
object Raindrops {
    fun convert(n: Int) =
            listOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
                    .fold("") { output, pair ->
                        output + if (n % pair.first == 0) pair.second else ""
                    }
                    .ifEmpty { n.toString() }
}
```

An [object declaration][object] is used to define `Raindrops` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `convert` method.

The `convert` function is implemented with a call to a chain of functions which returns a single value.
Although the `convert` function has multiple lines, it consists only of the one expression resulting from the function chain,
so it is defined using [single-expression function][single-expression-function] syntax,
with the curly braces omitted from the `convert` function call and the return type [inferred][type-inference].

The first function is the [`listOf`][listof] method to create a [`List`][list] of [`Pair`][pair] values,
using the [`to`][to] keyword to associate a number with its sound.

The [`fold`][fold] method is called on the `List`.
Its accumulating value is initialized with an empty `String`.
The [lambda][lambda] of `fold` takes the accumulating `String` value  as well as the `Pair` of each `List` element being iterated.

If the input number is evenly divisible by the number in the current `Pair` being iterated, then the sound from the `Pair` is concatenated
to the accumulating `String`, otherwise, an empty string is concatenated to it.
The accumulating `String` is returned to the next iteration of `fold`.

When `fold` has iterated through all of the `List` elements, the `StringBuilder` is the result.
The `convert` function returns the result of calling the [`ifEmpty`][ifempty] method on the `StringBuilder`.
If the `StringBuilder` content is empty, then it outputs the input number converterd to a `String`.
Otherwise, it returns the content of the `StringBuilder` as a `String`.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[listof]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html
[fold]: https://kotlinlang.org/docs/collection-aggregate.html#fold-and-reduce
[list]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/
[pair]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/
[to]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[ifempty]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/if-empty.html
