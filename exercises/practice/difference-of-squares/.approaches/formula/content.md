# Use formula

```kotlin
class Squares(private val input: Int) {

    fun squareOfSum() = (input * (input + 1) / 2).let { it * it }

    fun sumOfSquares() = (input * (input + 1) * ((input * 2) + 1)) / 6

    fun difference() = squareOfSum() - sumOfSquares()
}
```

A [`private`][visibility] [`val`][variables] is defined as the parameter for the primary [constructor][constructors].

In this solution a [formula][formula] is used to solve the `squareOfSum` and `sumOfSquares` methods.

At the time of this writing the instructions state:

>You are not expected to discover an efficient solution to this yourself from first principles; 
>research is allowed, indeed, encouraged. Finding the best algorithm for the problem is a key skill in software engineering.

It is fine to search for an algorithm on the internet.
This is also sometimes referred to as ["Google is your friend"][google-friend], although you don't have to search with Google.

It is okay if you don't understand how the algorithm works.
What is important is that it obviously is not introducing malware and that it passes the tests.

Note that this avoids using [`pow`][pow] in `squareOfSum`,
since multiplying a value by itself is usually more efficient than type-casting from `int `to `double` back to `int`.
Instead, it uses the [`it`][it] keyword to refer to the value multiplied by itself in the [`let`][let] function.

[constructors]: https://www.geeksforgeeks.org/kotlin-constructor/
[visibility]: https://kotlinlang.org/docs/visibility-modifiers.html
[variables]: https://kotlinlang.org/docs/basic-syntax.html#variables
[formula]: https://learnersbucket.com/examples/algorithms/difference-between-square-of-sum-of-numbers-and-sum-of-square-of-numbers/
[google-friend]: https://en.wiktionary.org/wiki/Google_is_your_friend
[pow]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/pow.html
[let]: https://kotlinlang.org/docs/scope-functions.html#let
[it]: https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
