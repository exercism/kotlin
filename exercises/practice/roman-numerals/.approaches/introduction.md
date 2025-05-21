# Introduction

There are many ways to solve Roman Numerals.
One approach can use the [`fold`][fold] method on a list of [`Pair`][pair]s that associate the Arabic numeral with the Roman numeral.

## Approach: `fold` with `repeat`

```kotlin
object RomanNumerals {

    fun value(n: Int) =
            listOf(
                            1000 to "M",
                            900 to "CM",
                            500 to "D",
                            400 to "CD",
                            100 to "C",
                            90 to "XC",
                            50 to "L",
                            40 to "XL",
                            10 to "X",
                            9 to "IX",
                            5 to "V",
                            4 to "IV",
                            1 to "I"
                    )
                    .fold(Pair(StringBuilder(), n)) { (output, runnyNum), (value, numeral) ->
                        when {
                            runnyNum >= value ->
                                    output.append(numeral.repeat(runnyNum / value)) to
                                            runnyNum % value
                            else -> output to runnyNum
                        }
                    }
                    .first
                    .toString()
}
```

For more information, check the [`fold` with `repeat` approach][approach-fold-repeat].

[approach-fold-repeat]: https://exercism.org/tracks/kotlin/exercises/roman-numerals/approaches/fold-repeat

[fold]: https://kotlinlang.org/docs/collection-aggregate.html#fold-and-reduce
[pair]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/
