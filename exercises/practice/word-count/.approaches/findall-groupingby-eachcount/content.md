# `findAll` with `groupingBy` and `eachCount`

```kotlin
object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return Regex("[a-z0-9]+(?:'[a-z]+)?")
                .findAll(phrase.lowercase())
                .groupingBy { it.value }
                .eachCount()
    }
}
```

An [object declaration][object] is used to define `WordCount` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `phrase` method.

A [regular expression][regex] pattern is defined to match the characters expected to be found in the words.
At the time of writing, the valid characters are alphanumeric and the apostrophe.
The pattern looks for one or more alphanumeric characters (`[a-z0-9]+`), either followed by an apostrophe and one or more alphabetic characters,
or not (`(?:'[a-z]+)?`). 

The [`findAll`][findall] method is called on the `Regex` to match the words in the lowercased input to the pattern.

The found words are passed to the [`groupingBy`][groupingby] method.
The [lambda][lambda] of `groupingBy` uses the [`it`][it] keyword to refer to the single [`MatchResult`][matchresult] parameter for the lambda,
and uses its [`value`][value] property for the value to be grouped by.

Each group is then transformed into a `Map<String, int>` by the [`eachCount`][eachcount] method, which creates a key/value pair for each word and its frequency
as an entry for the `Map`.

Finally, the `Map` is returned by the function.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[regex]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/
[findall]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/find-all.html
[groupingby]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/grouping-by.html
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
[matchresult]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-match-result/
[value]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-match-result/value.html
[eachcount]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/each-count.html
