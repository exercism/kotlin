# Introduction

Booleans in Kotlin are represented by the `Boolean` type, which values can be either `true` or `false`.

Kotlin supports three built-in [boolean operators][reference]: `!` (negation aka NOT), `&&` (lazy conjunction aka AND), and `||` (lazy disjunction aka OR). The `&&` and `||` operators use _short-circuit evaluation_, which means that the right-hand side of the operator is only evaluated when needed.
