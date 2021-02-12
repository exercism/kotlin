# About

Booleans in Kotlin are represented by the `Boolean` type, which values can be either `true` or `false`.

Kotlin supports three built-in [boolean operators][reference]: `!` (negation aka NOT), `&&` (lazy conjunction aka AND), and `||` (lazy disjunction aka OR). The `&&` and `||` operators use _short-circuit evaluation_, which means that the right-hand side of the operator is only evaluated when needed.

```kotlin
true || false // => true
true && false // => false
```

The three boolean operators each have a different [_operator precedence_][precedence]. As a consequence, they are evaluated in this order: `!` first, `&&` second, and finally `||`. If you want to 'escape' these rules, you can enclose a boolean expression in parentheses (`()`), as the parentheses have an even higher operator precedence.

```kotlin
!true && false   // => false
!(true && false) // => true
```

[reference]: https://kotlinlang.org/docs/reference/basic-types.html#booleans
[precedence]: https://kotlinlang.org/docs/reference/grammar.html#expressions
