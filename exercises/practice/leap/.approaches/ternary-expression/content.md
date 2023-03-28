Ternary expression

```kotlin
data class Year(val year: Int) {
    val isLeap = if (year % 100 == 0) year % 400 == 0 else year % 4 == 0
}
```

A [ternary expression][ternary-expression] uses a maximum of two checks to determine if a year is a leap year.

It starts by testing the outlier condition of the year being evenly divisible by `100`.
It does this by using the [modulus operator][modulus-operator].
If the year is evenly divisible by `100`, then the expression is `true`, and the ternary expression returns if the year is evenly divisible by `400`.
If the year is _not_ evenly divisible by `100`, then the expression is `false`, and the ternary expression returns if the year is evenly divisible by `4`.

| year | year % 100 == 0 | year % 400 == 0 | year % 4 == 0  | is leap year |
| ---- | --------------- | --------------- | -------------- | ------------ |
| 2020 |           false |   not evaluated |           true |        true  |
| 2019 |           false |   not evaluated |          false |       false  |
| 2000 |           true  |            true |  not evaluated |        true  |
| 1900 |           true  |           false |  not evaluated |        false |

Although it uses a maximum of only two checks, the ternary expression tests an outlier condition first,
making it less efficient than another approach that would first test if the year is evenly divisible by `4`,
which is more likely than the year being evenly divisible by `100`.

[modulus-operator]: https://www.programiz.com/kotlin-programming/operators
[ternary-expression]: https://kotlinlang.org/docs/control-flow.html#if-expression
