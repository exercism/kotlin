# Introduction

## Comparison operators

Comparison operators are similar to many other languages.

For equality, the operators are `==` (equal) and `!=` (not equal).

```Kotlin
val txt = "abc"
txt == "abc" // => true
txt != "abc" // => false
```

The greater/less than operators are also conventional.

```Kotlin
1 < 3 // => true
3 > 3 // => false
3 <= 3 // => true
4 >= 3 // => true
```

## Branching with `if`

This is the full form of an `if` expression:

```Kotlin
if (conditional1) {
//    something...
} else if (conditional2) {
//    something...
} else {
//    something...
}
```

- Parentheses `()` around each conditional are required.
- A conditional must evaluate to a Boolean `true` or `false`.
  Kotlin has no concept of "truthy" and "falsy" as found in some languages.
- Braces `{}` are optional, if there is only a single expression.
- Both `else if` and `else` are optional, and there can be multiple `else if` blocks.


## Alternatives?

By deliberate choice, Kotlin does _not_ have the ternary operator `? :` found in Java.
A concise form of `if ... else` is preferred:

```Kotlin
return if (isOK) goodValue else badValue
```
