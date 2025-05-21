# `HashSet` lookup

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

An [object declaration][object] is used to define `PigLatin` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `translate` method.

Three [`private`][visibility] [`val`][variables]s are defined for the [`HashSet`][hashset]s, using the [`hashSetOf`][hashsetof] method.

The `translate` function is implemented by splitting the input `String` by a space, and then using the [`joinToString`][jointostring] method
with a space as the separator.
The [lambda][lambda] of `joinToString` uses the [`it`][it] keyword to refer to the single `String` parameter for the lambda, and passes that to the
`piggyfy` function.
The `translate` function returns the rejoined input `String` as transformed by each word being processed by the `piggyfy` function.

The `piggyfy` function takes the input `String` and checks to see if its first character is in the `HashSet` of vowels (not including `y`) or
if the first two characters are in the `HashSet` of "specials" (e.g. `"xr"` or `"yt"`).
If the word starts with a vowel or a special two-letter combination, then the function returns the word concatenated with `ay` at the end.

Otherwise, a [range][range] is used to iterate an index for the characters of the word in a [`for`][for-loop] loop,
starting with the second character and up to but not including the length of the word.

A variable is set from the character in the word at the current index of the range.

If the character is in the `HashSet` of vowels (including `y`), then the index is adjusted if the current character is a `u`
and the previous character is a `q`.
A [`substring`][substring] is then taken from the character at the index until the end of the word.
Concatenated to the end of that is a `substring` from the beginning of the word up to but not including the index.
Finally, concatenated to the end of that is `ay`.
The concatenated `String` is returned from the function.

In the event that the word has no vowels and the `for` loop finishes without returning, the function returns the word as is.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[visibility]: https://kotlinlang.org/docs/visibility-modifiers.html
[variables]: https://kotlinlang.org/docs/basic-syntax.html#variables
[hashset]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-set/
[hashsetof]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/hash-set-of.html
[jointostring]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/join-to-string.html
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
[range]: https://kotlinlang.org/docs/ranges.html
[for-loop]: https://kotlinlang.org/docs/control-flow.html#for-loops
[substring]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/substring.html
