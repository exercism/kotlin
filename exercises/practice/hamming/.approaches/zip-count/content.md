# `zip` with `count`

```kotlin
object Hamming {

    fun compute(leftStrand: String, rightStrand: String) =
        if (leftStrand.length != rightStrand.length)
            throw IllegalArgumentException("left and right strands must be of equal length")
        else
            (leftStrand zip rightStrand).count { it.first != it.second }
}
```

An [object declaration][object] is used to define `Hamming` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `compute` method.

The `compute` method is implemented by an `if/else` expression.
Although the function has multiple lines, it consists only of the one `if/else` expression,
so it is defined using [single-expression function][single-expression-function] syntax,
with the curly braces omitted from the function call and the return type [inferred][type-inference].

An `IllegalArgumentException` is thrown if the two input `String`s are not the same length.

Otherwise, the [`zip`][zip] function is used to make a sequence of [`Pair`][pair] values of the characters at the same index in both input `String`s.
Since `zip` is marked as an [`infix`][infix] function, it can be called between the two strands (i.e. between the left receiver and the right parameter),
as well as called `leftStrand.zip(rightStrand)`.
Which to use is a matter of stylistic preference.

The [`count`][count] function iterates the `Pair` values and uses the [`it`][it] keyword to count the `Pair` values that meet the Boolean condition
of the first value in the current `Pair` not being equal to the second value in the `Pair`.

Finally, the `compute` function returns the result of calling `count` on the zipped `Pair` values.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[zip]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/zip.html
[count]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/count.html
[pair]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/
[infix]: https://kotlinlang.org/docs/functions.html#infix-notation
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
