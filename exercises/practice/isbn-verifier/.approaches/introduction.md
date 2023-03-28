# Introduction

There are several ways to solve Isbn Verifier.
One approach is to use [`fold`][fold] and [`when`][when] with [`let`][let].

## Approach: `fold` and `when` with `let`

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

For more information, check the [`fold` and `when` with `let` approach][approach-fold-when-let].

[approach-fold-when-let]: https://exercism.org/tracks/kotlin/exercises/isbn-verifier/approaches/fold-when-let
[fold]: https://kotlinlang.org/docs/collection-aggregate.html#fold-and-reduce
[when]: https://kotlinlang.org/docs/control-flow.html#when-expression
[let]: https://kotlinlang.org/docs/scope-functions.html#let
