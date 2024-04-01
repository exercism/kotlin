# `when` expressions

```kotlin
object Bob {
    fun hey(statement: String): String =
        when {
            statement.isQuestion() && statement.isYelling() -> "Calm down, I know what I'm doing!"
            statement.isQuestion() -> "Sure."
            statement.isYelling() -> "Whoa, chill out!"
            statement.isSilence() -> "Fine. Be that way!"
            else -> "Whatever."
        }

    private fun String.isSilence(): Boolean = this.isBlank()
    private fun String.isQuestion(): Boolean = this.trim().endsWith('?')
    private fun String.isYelling(): Boolean {
        val letters = this.filter { it.isLetter() }
        return if (letters.isEmpty())
            false
        else
            letters.all { it.isUpperCase() }
    }
}
```

In this approach you have a `when` expression containing different so-called branches that can be matched using the corresponding patterns. 
As soon as one of these patterns on the left side of the arrow (`->`) is matched ...

1. the value on the right side
2. the block on the right side is executed and the value retuned from the block 

... is returned from the `when` expression.

Only one branch is matched in one execution of the `when` expression. The branches are matched from top to bottom and the first branch in which the condition evaluates to `true` is selected. 
If none of the given conditions matches the `else` branch is selected and returned.

~~~~exercism/caution
Depending on what patterns are on the left side of your branches the order of branches is important to the correct execution of the `when` expression since the first matching branch is selected.
~~~~

An [object declaration][object] is used to define `Bob` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `hey` method.

Inside this object there are some `private` [extension methods as members][extension-members] of the `object`. This adds these methods to the `String` data type for `private` usage of these methods in this `object`. This allows calling the methods directly on the `String` instead of passing the `String` to the method.
(More about extension methods in general [here][extension-general])

These extension methods check for:

1. `isSilence()`: a blank string
2. `isQuestion()`: a string with the last non-whitespace-character being a question mark
3. `isYelling()`: a string with all letters in uppercase

When combining these methods as in the `when` expression above you can map all the cases required by the exercise.


[when]: https://kotlinlang.org/docs/control-flow.html#when-expression
[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[extension-members]: https://kotlinlang.org/docs/extensions.html#declaring-extensions-as-members
[extension-general]: https://kotlinlang.org/docs/extensions.html