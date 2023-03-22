# `Map`

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

An [object declaration][object] is used to define `ScrabbleScore` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `scoreWord` method.

A [`private`][visibility] [`val`][variables] is defined to hold a `Map`.
The `Map` is constructed with the [`mapOf`][mapOf] method, which is passed key/value [pairs][pair] made by the [`to`][to] keyword
to associate the score key with its list of `Char` values.
This is less tedious then typing the `Map` with a letter key and its score value for all of the letters.

However, for an efficient lookup, we _want_ a letter key with its score value, so the [`mutableMapOf`][mutableMapOf] method is used
to initialize the lookup map.

Inside an [initializer block][constructors], two `forEach` loops are used for loading the lookup `Map` with the transformed key/values from the first `Map`.
(If you have solved the `Etl` exercise, then this will be familiar to you.)
Each key/value entry is passed into the [lambda][lambda] for the outer `forEach`.
The inner `forEach` is called on the list of `Char` values for the entry.
Each `Char` letter is passed into the lambda for the inner `forEach`, where the `put` method is used to create a new entry in the lookup `Map`,
with the letter as the key and the score as the value.

The `scoreWord` function is also a single-expression function, implemented with the `sumOf` [aggregate operation][aggregate-operation] on the input word.
The [lambda][lambda] of `sumOf` uses the [`it`][it] keyword to refer to the single `Char` parameter for the lambda, and passes that to the
[`getValue`][getvalue] method of the `Map` to look up the score for the letter.
The function returns the result of calling `sumOf`, which is the sum of the scores for each of the characters in the word.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[visibility]: https://kotlinlang.org/docs/visibility-modifiers.html
[variables]: https://kotlinlang.org/docs/basic-syntax.html#variables
[mapOf]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-of.html
[pair]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/
[to]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html
[mutableMapOf]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-map-of.html
[constructors]: https://kotlinlang.org/docs/classes.html#constructors
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[aggregate-operation]: https://kotlinlang.org/docs/collection-aggregate.html
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
[getvalue]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-value.html
