# Introduction

There are various idiomatic approaches to solve Bob.
A basic approach can use a series of `if` expressions to test the conditions.
A `List` can contain answers from which the right response is selected by an index calculated from scores given to the conditions.

## General guidance

Regardless of the approach used, some things you could look out for include

- If the input is trimmed, [`trim()`][trim] only once.

- Use the [`endsWith()`][endswith] method instead of checking the last character by index for `?`.

- Don't copy/paste the logic for determining a shout and for determining a question into determining a shouted question.
  Combine the two determinations instead of copying them.
  Not duplicating the code will keep the code [DRY][dry].

- Perhaps consider making `questioning` and `shouting` values set once instead of functions that are possibly called more than once.

## Approach: `if` expressions

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

For more information, check the [`if` expressions approach][approach-if].

## Approach: Answer `List`

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

For more information, check the [Answer `List` approach][approach-answer-list].

## Which approach to use?

The choice between `if` expressions and answers `List` can be made by perceived readability.

[trim]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim.html
[endswith]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/ends-with.html
[dry]: https://en.wikipedia.org/wiki/Don%27t_repeat_yourself
[approach-if]: https://exercism.org/tracks/kotlin/exercises/bob/approaches/if-expressions
[approach-answer-list]: https://exercism.org/tracks/kotlin/exercises/bob/approaches/answer-list
