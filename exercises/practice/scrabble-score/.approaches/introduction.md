# Introduction

There are several ways to solve Scrabble Score.
One approach is to use a [`when`][when] expression for looking up the letter scores.
Another approach is to use a [`Map`][map] for looking up the letter scores.

## Approach: `when`

```kotlin
object ScrabbleScore {

    private fun scoreLetter(c: Char) =
            when (c.uppercaseChar()) {
                'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
                'D', 'G' -> 2
                'B', 'C', 'M', 'P' -> 3
                'F', 'H', 'V', 'W', 'Y' -> 4
                'K' -> 5
                'J', 'X' -> 8
                'Q', 'Z' -> 10
                else -> 0
            }

    fun scoreWord(word: String) = word.sumOf { scoreLetter(it) }
}
```

For more information, check the [`when` approach][approach-when].

## Approach: `Map`

```kotlin
object ScrabbleScore {
    private val compressedMap =
            mapOf(
                    1 to listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
                    2 to listOf('D', 'G'),
                    3 to listOf('B', 'C', 'M', 'P'),
                    4 to listOf('F', 'H', 'V', 'W', 'Y'),
                    5 to listOf('K'),
                    8 to listOf('J', 'X'),
                    10 to listOf('Q', 'Z')
            )
    private val lookup = mutableMapOf<Char, Int>()

    init {
        compressedMap.forEach { entry ->
            entry.value.forEach { letter -> lookup.put(letter, entry.key) }
        }
    }

    fun scoreWord(word: String) = word.sumOf { lookup.getValue(it.uppercaseChar()) }
}
```

For more information, check the [`Map` approach][approach-map].

## Which approach to use?

The `when` approach is succinct and reasonably performant.
A `Map` lookup is fast, but it takes time to set up a `Map`, so for only a few lookups a `when` may be finished before the `Map` is built.
Once the `Map` is built, if there are a lot of lookups, then the `Map` may finish all of them sooner than a `when`.

[approach-when]: https://exercism.org/tracks/kotlin/exercises/scrabble-score/approaches/when
[approach-map]: https://exercism.org/tracks/kotlin/exercises/scrabble-score/approaches/map
[when]: https://kotlinlang.org/docs/control-flow.html#when-expression
[map]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/
