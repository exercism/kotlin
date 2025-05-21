# `when`

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

An [object declaration][object] is used to define `ScrabbleScore` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `scoreWord` method.

The [`private`][visibility] method for scoring the letter is implemented by a [`when`][when] expression.
Although the function has multiple lines, it consists only of the one `when` expression, so it is defined using
[single-expression function][single-expression-function] syntax, with the curly braces omitted and the return type [inferred][type-inference].

The `scoreWord` function is also a single-expression function, implemented with the `sumOf` [aggregate operation][aggregate-operation] on the input word.
The [lambda][lambda] of `sumOf` uses the [`it`][it] keyword to refer to the single `Char` parameter for the lambda, and passes that to the function
for scoring a letter.
The function returns the result of calling `sumOf`, which is the sum of the scores for each of the characters in the word.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[visibility]: https://kotlinlang.org/docs/visibility-modifiers.html
[when]: https://kotlinlang.org/docs/control-flow.html#when-expression
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[aggregate-operation]: https://kotlinlang.org/docs/collection-aggregate.html
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
