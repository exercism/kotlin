# Introduction

There are various ways to solve Difference of Squares.
One approach is to use a [formula][formula] to calculate the solution.

## Approach: Use formula

```kotlin
class Squares(private val input: Int) {

    fun squareOfSum() = (input * (input + 1) / 2).let { it * it }

    fun sumOfSquares() = (input * (input + 1) * ((input * 2) + 1)) / 6

    fun difference() = squareOfSum() - sumOfSquares()
}
```

For more information, check the [formula approach][approach-formula].

[formula]: https://learnersbucket.com/examples/algorithms/difference-between-square-of-sum-of-numbers-and-sum-of-square-of-numbers/
[approach-formula]: https://exercism.org/tracks/kotlin/exercises/difference-of-squares/approaches/formula
