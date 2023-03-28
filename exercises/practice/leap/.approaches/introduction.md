# Introduction

There are various idiomatic approaches to solve Leap.
You can use a chain of boolean expressions to test the conditions.
Or you can use a [ternary expressions][ternary-expressions].

## General guidance

The key to solving Leap is to know if the year is evenly divisible by `4`, `100` and `400`.
For determining that, you will use the [modulus operator][modulus-operator].

## Approach: Chain of Boolean expressions

```kotlin
data class Year(val year: Int) {
    val isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}
```

For more information, check the [Boolean chain approach][approach-boolean-chain].

## Approach: Ternary expression

```kotlin
data class Year(val year: Int) {
    val isLeap = if (year % 100 == 0) year % 400 == 0 else year % 4 == 0
}
```

For more information, check the [Ternary expression approach][approach-ternary-expression].

## Other approaches

Besides the aforementioned, idiomatic approaches, you could also approach the exercise as follows:

## `plusDays()` approach:

Add a day to February 28th for the year and see if the new day is the 29th. For more information, see the [`plusDays()` approach][approach-plusdays].

## Built-in method approach:

Use the built-in method for the [Year][year]. For more information, see the [`isLeap()` approach][approach-isleap].

## Which approach to use?

- The chain of boolean expressions is most efficient, as it proceeds from the most likely to least likely conditions.
  It has a maximum of three checks.
- The ternary expression has a maximum of only two checks, but it starts from a less likely condition.
- Using `plusDays()` or using the built-in `isLeap()` method may be considered "cheats" for the exercise,
  but `isLeap()` would be the idiomatic way to check if a year is a leap year in Kotlin.

[modulus-operator]: https://www.programiz.com/kotlin-programming/operators
[ternary-expression]: https://kotlinlang.org/docs/control-flow.html#if-expression
[approach-boolean-chain]: https://exercism.org/tracks/kotlin/exercises/leap/approaches/boolean-chain
[approach-ternary-expression]: https://exercism.org/tracks/kotlin/exercises/leap/approaches/ternary-expression
[approach-plusdays]: https://exercism.org/tracks/kotlin/exercises/leap/approaches/plusdays
[year]: https://docs.oracle.com/javase/8/docs/api/java/time/Year.html
[approach-isleap]: https://exercism.org/tracks/kotlin/exercises/leap/approaches/built-in-method
