# Introduction

There are several idiomatic ways to solve Raindrops.
One way is to use the [`buildString`][buildstring] function.
Another way is to use the [`fold`][fold] method on a [`List`][list].

## General guidance

The key to solving Raindrops is to know if the input is evenly divisible by `3`, `5` and/or `7`.
For determining that, you will use the [modulus operator][modulus-operator].

## Approach: `buildString`

```kotlin
object Raindrops {
    fun convert(num: Int) = buildString {
        if (num % 3 == 0) append("Pling")
        if (num % 5 == 0) append("Plang")
        if (num % 7 == 0) append("Plong")
        if (isEmpty()) append(num)
    }
}
```

For more information, check the [`buildString` approach][approach-buildstring].


## Approach: `fold` on a `List`

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

For more information, check the [`fold` on a `List` approach][approach-fold-on-list].

## Which approach to use?

Benchmarking is currently outside the scope of this document,
so which to use is a matter of stylistic choice.
An advantage for `List` is that, if another type of raindrop were to be added, only another entry would be added to the `List`,
and no other code would need to be added.

[approach-buildstring]: https://exercism.org/tracks/kotlin/exercises/raindrops/approaches/buildstring
[approach-fold-on-list]: https://exercism.org/tracks/kotlin/exercises/raindrops/approaches/fold-on-list
[modulus-operator]: https://www.programiz.com/kotlin-programming/operators
[buildstring]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/build-string.html#buildstring
[fold]: https://kotlinlang.org/docs/collection-aggregate.html#fold-and-reduce
[list]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/
