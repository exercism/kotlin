# Answer `List`

```kotlin
object Bob {
    private val answers =
            listOf("Whatever.", "Sure.", "Whoa, chill out!", "Calm down, I know what I'm doing!")

    fun hey(input: String): String {
        val msg = input.trim()
        if (msg.isEmpty()) return "Fine. Be that way!"
        val isQuestion = if (msg.endsWith('?')) 1 else 0
        val isYelling = if (('A'..'Z').any { msg.contains(it) } && msg == msg.uppercase()) 2 else 0
        return answers[isQuestion + isYelling]
    }
}
```

In this approach you define a `List` that contains Bob’s answers, and each condition is given a score.
The correct answer is selected from the `List` by using the score as the `List` index.

An [object declaration][object] is used to define `Bob` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `hey` method.

The [`listOf`][listof] method is used to create a list of Bob's answers.

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

The conditions of being a question and being a yell are assigned scores through the use of the [ternary expression][ternary-expression].
For example, giving a question a score of `1` would use an index of `1` to get the element from the answers `List`, which is `"Sure."`.

| isYelling | isQuestion | Index     | Answer                                |
| --------- | ---------- | --------- | ------------------------------------- |
| `false`   | `false`    | 0 + 0 = 0 | `"Whatever."`                         |
| `false`   | `true`     | 0 + 1 = 1 | `"Sure."`                             |
| `true`    | `false`    | 2 + 0 = 2 | `"Whoa, chill out!"`                  |
| `true`    | `true`     | 2 + 1 = 3 | `"Calm down, I know what I'm doing!"` |

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[listof]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html
[trim]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim.html
[endswith]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/ends-with.html
[range]: https://kotlinlang.org/docs/ranges.html#range
[any]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html
[contains]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains.html
[ternary-expression]: https://kotlinlang.org/docs/control-flow.html#if-expression
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
