# Introduction

There are two main ways to solve Word Count.
There are many variants of splitting the words on a more or less complex pattern, and that usually filter out blank/empty values.
Another approach is to use a [regular expression][regex] pattern to find words.

## Approach: `findAll` with `groupingBy` and `eachCount`

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

For more information, check the [`findAll` with `groupingBy` and `eachCount` approach][approach-findall-groupingby-eachcount].

[approach-findall-groupingby-eachcount]: https://exercism.org/tracks/kotlin/exercises/word-count/approaches/findall-groupingby-eachcount
[regex]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/
