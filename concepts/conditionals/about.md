# About conditionals

## Comparison operators

[Comparison operators][operators] are similar to many other languages, with a few extensions.

For equality, the operators are `==` (equal) and `!=` (not equal).

```Kotlin
val txt = "abc"
txt == "abc" // => true
txt != "abc" // => false
```

Additionally, the `===` and `!==` operators test for ["referential equality"][referential-equality]:
`a === b` if and only if `a` and `b` point to the same object.
This should make more sense later in the syllabus.

The greater/less than operators are also conventional.

```Kotlin
1 < 3 // => true
3 > 3 // => false
3 <= 3 // => true
4 >= 3 // => true
```

## Branching with `if`

This is the full form of an [`if` expression][if-else]:

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

Note that in Kotlin, `if` is an [_expression_][expression] returning a value.
It is not a [_statement_][statement] as in Java.

We will see in a later Concept that Kotlin has a powerful [`when`][when] construct, intended to replace long chains of `else if` clauses with pattern matching.


[operators]: https://kotlinlang.org/docs/keyword-reference.html#operators-and-special-symbols
[referential-equality]: https://kotlinlang.org/docs/equality.html#floating-point-numbers-equality
[if-else]: https://kotlinlang.org/docs/control-flow.html#if-expression
[when]: https://kotlinlang.org/docs/control-flow.html#when-expressions-and-statements
[expression]: https://en.wikipedia.org/wiki/Expression_(computer_science)
[statement]: https://en.wikipedia.org/wiki/Statement_(computer_science)
