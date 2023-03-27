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

The `convert` function is implemented with a call to a chain of functions which return a single value.
Although the `convert` function has multiple lines, it consists only of the one expression resulting from the function chain,
so it is defined using [single-expression function][single-expression-function] syntax,
with the curly braces omitted from the `convert` function call and the return type [inferred][type-inference].

TODO

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
