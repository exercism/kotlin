# About Numbers

## Numerical types

[Numbers][numbers] can be integer, unsigned integer, or floating point types.
Each comes in various "sizes", meaning how many bits it needs in memory.

- Integers can be `Byte`, `Short`, `Int` or `Long`, respectively 8, 16, 32 and 64 bits.
- Unsigned integers have a `U` prefix: `UByte`, `UShort`, `UInt` or `ULong`.
- Floating point types are `Float` (32-bit) or `Double` (64-bit).

Integer variables relying on type inference default to `Int`, even on 64-bit machines, but floating point variables default to `Double`.

Other types can, of course, be specified, but there are a few syntactic shortcuts, and big integer literals become `Long` if they would overflow `Int`.

```Kotlin
val one = 1 // defaults to Int
val threeBillion = 3_000_000_000 // Long, with optional underscores for clarity
val oneLong = 1L // Long
val oneByte: Byte = 1
val oneDouble = 1.0 // defaults to Double
val oneFloat = 1.0f //Float
val lightSpeed = 3.0e8 // scientific notation (units of m/s)
```

Hexadecimal and binary literals are conventional: `0x7F` and `0b100101` respectively.
Octal literals are not supported in Kotlin.

## Arithmetic

The basic arithmetic operators are the same as in many languages:

```Kotlin
4 + 3 // => 7
4 - 3 // => 1
4 * 3 // => 12
4 / 3 // => 1  Int / Int always gives an Int
-8 / 3 // => -2  Truncated towards zero
-8.0 / 3 // => -2.6666666666666665
```

To get a floating point result from division, at least one of the numerator / denominator must be floating point.

Division by zero is more interesting.

```Kotlin
1 / 0 // => java.lang.ArithmeticException: / by zero
3.0 / 0.0 // => Infinity
0.0 / 0.0 // => NaN (Not a Number)
```

Integer division by zero is an error, but [IEEE floating point standards][IEEE] can apply in other cases.

The modulo operator `%` gives the remainder from integer division:

```Kotlin
8 % 3 // => 2
```

Kotlin, like other JVM languages, has no exponentiation operator (_this annoys scientists and engineers_).
We need to use the [`pow()`][pow] function from the [`math`][math] library, and the number being raised to some power must be `Float` or `Double`.

```kotlin
2.0.pow(3)  // => 8.0
2.pow(3)  // Unresolved reference (2 is Int, so not allowed)
```

## Rounding

The [`math`][math] library contains several functions to round floating point numbers to a nearby integer.

_Did the last line sound slightly odd?_
When we say "a nearby integer", there are two questions:

- Is the return value still Float/Double, or is it converted to Int/Long?
- How are ties rounded? Does `4.5` round to `4` or `5`?

It is not Kotlin's fault if this seems complicated.
Mathematicians have been arguing about this for centuries.

### `round()`, `floor()`, `ceil()`, `truncate()`

These four functions all return the same floating-point type as the input, but differ in how they round.

- [`round()`][round] gives the _nearest_ integer if this is unambiguous, or the _nearest even_ integer when tied.
- [`floor()`][floor] rounds towards negative infinity.
- [`ceil()`][ceil] rounds towards positive infinity
- [`truncate()`][truncate] rounds towards zero

```kotlin
round(4.7)  // => 5.0 (nearest integer)
round(4.5)  // => 4.0 (nearest even integer)

floor(4.7)  // => 4.0  (towards -Inf)
floor(-4.7)  // => 5.0

ceil(4.7)   // => 5.0  (towards +Inf)
ceil(-4.7)  // => -4.0

truncate(4.7)  // => 4.0  (towards zero)
truncate(-4.7) // => -4.0
```

### `roundToInt()`, `roundToLong()`

These two functions do a type conversion after rounding, so the return type is `Int` or `Long` respectively.

Ties are always rounded towards positive infinity.

```kotlin
4.3.roundToInt()  // => 4 (nearest integer)
4.5.roundToInt()  // => 5  (nearest integer towards +Inf)
(-4.5).roundToInt()  // => -4
```

Note also the different syntax: `x.roundToInt()` versus `round(x)`.

## Type conversions

Kotlin will quietly do implicit conversions in a few cases, for example `Int` to `Double` in a mixed arithmetic expression:

```Kotlin
3 + 4.0 // => 7.0
```

Internally, the `+` operator is overloaded to handle this.

More generally, explicit conversions are required:

```Kotlin
val x = 7.3
x.toInt() // => 7

val n = 42
n.toDouble() // => 42.0
```

See the [manual][conversions] for the full list of `toX()` methods.

[numbers]: https://kotlinlang.org/docs/numbers.html
[IEEE]: https://en.wikipedia.org/wiki/IEEE_754
[conversions]: https://kotlinlang.org/docs/numbers.html#explicit-number-conversions
[pow]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/pow.html
[math]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/
[round]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/round.html
[floor]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/floor.html
[ceil]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/ceil.html
[truncate]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/truncate.html
