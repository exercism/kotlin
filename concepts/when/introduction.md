# Introduction

Kotlin's `when` is a conditional expression for choosing among several options.
It is similar to `switch` in Java, but more flexible than a chain of `if` ... `else if` ... `else`.

Like `if`, `when` can also be used as an expression that produces a value.

## Matching a value

Give `when` a value to match in parentheses.
Each branch compares that value until one matches:

```kotlin
val animal = "chicken"
val type = when (animal) {
    "chicken" -> "bird"
    "poodle" -> "dog"
    else -> "unknown"
}
// type => "bird"
```

- Each branch is written as `pattern -> result`.
- Branches are tried from to bottom until a match is found. Only the first branch runs.
- Use `else` for any value not listed above (similar to the final `else` in an `if` chain).

## Guard conditions

When matching a value, additional conditions can be placed in an `if` after the pattern.
These conditions are called guard conditions.

```kotlin
val x = 5
val y = 10
val description = when (x) {
    5 if y % 2 == 0 -> "x is 5, y is even"
    else -> "other"
}
// description => "x is 5, y is even"
```

Even `else if` can be used.

```kotlin
val x = 7
val y = 10
val description = when (x) {
    5 if y % 2 == 0 -> "x is 5, y is even"
    else if y % 2 == 0 -> "y is an even number"
    else -> "other"
}
// description => "y is an even number"
```


## Matching conditions

Alternatively, the value can be omitted and boolean conditions can be placed on each branch:

```kotlin
val x = 5
val y = 8
val description = when {
    x % 2 != 0 -> "x is odd"
    y % 2 == 0 -> "y is even"
    else -> "neither condition matched first"
}
// description => "x is odd"
```

Again, branches are checked from top to bottom and only the first branch whose condition is `true` runs.

## Using `when` as an expression

When `when` is used for its result (assigned to a variable, returned from a function, and so on), every possible case must be covered.

- When matching with a value, add `else` unless every possible value is already handled (for example, all values of a `Boolean` or an `enum`).
- When matching conditions, an `else` branch is required, because the compiler cannot know that your conditions cover every case.

```kotlin
fun label(n: Int): String = when (n) {
    0 -> "zero"
    1 -> "one"
    else -> "other"
}
```
