# Introduction

There are many ways to solve Pig Latin.
One approach is to look up values from [HashSet][hashset]s.

## General guidance

At the time of writing only four rules need to be handled, but if they have similar output, they don't need to be handled completely separately.

## Approach: `HashSet` lookup

```kotlin
object PigLatin {
    private val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
    private val specials = hashSetOf("xr", "yt")
    private val vowels_y = hashSetOf('a', 'e', 'i', 'o', 'u', 'y')

    fun translate(phrase: String): String {
        return phrase.split(" ").joinToString(separator = " ") { piggyfy(it) }
    }

    private fun piggyfy(word: String): String {
        if (vowels.contains(word[0]) || specials.contains(word.substring(0, 2))) return word + "ay"
        for (pos in 1..word.length) {
            val letter = word[pos]
            if (vowels_y.contains(letter)) {
                val posCalc = if (letter == 'u' && word[pos - 1] == 'q') pos + 1 else pos
                return word.substring(posCalc) + word.substring(0, posCalc) + "ay"
            }
        }
        return word
    }
}
```

For more information, check the [`HashSet` lookup approach][approach-hashset-lookup].

[approach-hashset-lookup]: https://exercism.org/tracks/kotlin/exercises/pig-latin/approaches/hashset-lookup
[hashset]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-set/
