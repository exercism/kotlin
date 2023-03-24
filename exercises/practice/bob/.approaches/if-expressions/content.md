# `if` expressions

```kotlin
object Bob {

    fun hey(input: String): String {
        val msg = input.trim()
        if (msg.isEmpty()) return "Fine. Be that way!"
        val isQuestion = msg.endsWith('?')
        val isYelling = ('A'..'Z').any { msg.contains(it) } && msg == msg.uppercase()
        if (isYelling)
                return if (isQuestion) "Calm down, I know what I'm doing!" else "Whoa, chill out!"
        else return if (isQuestion) "Sure." else "Whatever."
    }
}
```

In this approach you have a series of `if` expressions to evaluate the conditions.
As soon as the right condition is found, the correct response is returned.

An [object declaration][object] is used to define `Bob` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `hey` method.

The `String` [`trim()`][trim] method is applied to the input to eliminate any whitespace at either end of the input.
If the string has no characters left, it returns the response for saying nothing.

```exercism/caution
Note that a `null` `string` would be different from a `String` of all whitespace.
A `null` `String` would throw a `NullPointerException` if `trim()` were applied to it.
```

A question is determined by use of the [`endsWith()`][endswith] method to see if the input ends with a question mark.

A [range][range] of `A..Z` is defined to look for uppercase English alphabetic characters.

The first half of the `isYelling` implementation

```java
if (('A'..'Z').any { msg.contains(it) }
```

is constructed from the range and the [`any`][any] method
to ensure there is at least one uppercase letter character in the `String`.
The [lambda][lambda] of `any` uses the [`it`][it] keyword to refer to the single `Char` parameter for the lambda,
and passes it to the [`contains`][contains] method to check if the character is in the input `String`.
The check that there is any alphabetic character is needed, because the second half of the condition tests that the uppercased input is the same as the input.
If the input were only `"123"` it would equal itself uppercased, but without letters it would not be a yell.

If `isYelling` is `true`, then a [ternary expresson][ternary-expression] is used to return either the response for a yelled question or just a yell.

If `isYelling` is `false`, then a ternary expression is used to return either the response for a question or a plain statement.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[trim]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim.html
[endswith]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/ends-with.html
[range]: https://kotlinlang.org/docs/ranges.html#range
[any]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html
[contains]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains.html
[ternary-expression]: https://kotlinlang.org/docs/control-flow.html#if-expression
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
