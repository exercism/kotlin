# `fold` and `when` with `let`

```kotlin
class IsbnVerifier {

    fun isValid(number: String) =
            number
                    .fold(Pair(10, 0)) { (pos, sum), ch ->
                        when {
                            ch.isDigit() -> pos - 1 to sum + (ch.digitToInt() * pos)
                            ch == 'X' && pos == 1 -> pos - 1 to sum + 10
                            ch == '-' -> pos to sum
                            else -> -1 to sum
                        }
                    }
                    .let { it.first == 0 && it.second % 11 == 0 }
}
```

Since there is no object state that needs to change with each call of the `isValid` method, the `IsbnVerifier` class _could_ be defined as an [object][object],
making it essentially a [singleton][singleton] object instantiation of the class.
However, as of this writing, the tests call `isValid` using an empty constructor for `IsbnVerifier` (e.g. `IsbnVerifier().isValid(isbn)`)
instead of calling `isValid` like a method on an object (e.g. `IsbnVerifier.isValid(isbn)`), which is why `IsbnVerifier` can't be defined as an `object`.

The `isValid` function is implemented as a call of [`fold`][fold] chained to [`let`][let].
Although the `isValid` function has multiple lines, it consists only of the one expression resulting from the function chain,
so it is defined using [single-expression function][single-expression-function] syntax,
with the curly braces omitted from the `isValid` function call and the return type [inferred][type-inference].

The [`fold`][fold] method is called on the input `String`.
Its accumulating value is initialized as a [`Pair`][pair] of values that represent the updating position and the calculating sum,
with the position starting at `10`, and the `sum` starting with `0`.
The [lambda][lambda] of `fold` takes the accumulating `Pair` as well as the character being iterated.

Inside the lambda is a [`when`][when] expression to check the value of the current character being iterated.
If the character is a digit, then the `when` returns the current position subtracted by `1`,
and also returns the `sum` plus the character's numeric value multiplied by the current position.
It returns the values as the accumulating `Pair` by using the [`to`][to] keyword.

If the character is an `X` and the position is `1`, then the current position subtracted by `1` and the `sum` plus `10` are returned.

If the character is a `-`, then the position and sum are returned as is.

If none of those cases for the `when` are matched, then the character is illegal, so `-1` and the sum are returned.
The `-1` is meant to make the final check for a valid position fail.

After the fold has iterated all of the characters in the input string, the [`let`][let] function is used to check the values of the
accumulating `Pair`.
If the position is at `0` and the `sum` is evenly divided by `11`, then `true` is returned from `let`, otherwise, `false` is returned.

The `isValid` function returns the result of calling `let`.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[fold]: https://kotlinlang.org/docs/collection-aggregate.html#fold-and-reduce
[when]: https://kotlinlang.org/docs/control-flow.html#when-expression
[let]: https://kotlinlang.org/docs/scope-functions.html#let
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[pair]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/
[to]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
