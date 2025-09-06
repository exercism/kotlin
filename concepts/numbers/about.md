# About Numbers

## Numerical types

[Numbers][ref-numbers] can be integer, unsigned integer, or floating point types.
Each comes in various "sizes", meaning how many bits it needs in memory.

Unlike some scripting languages (Ruby, recent versions of Python), each numeric type in Kotlin has a maximum ([`MAX_VALUE`][ref-max_value]) and minimum ([`MIN_VALUE`][ref-min_value]) value it can store.
Assigning larger values will cause ["overflow"][wiki-overflow], resulting in either an exception (_bad_) or corrupted data (_worse_).

```kotlin
Int.MAX_VALUE  // => 2147483647 (maximum for a 32-bit signed integer)
Int.MAX_VALUE + 1  // -2147483648 (overflow gives a negative result!)
```

- Integers can be `Byte`, `Short`, `Int` or `Long`, respectively 8, 16, 32 and 64 bits (1, 2 4, 8 bytes), and can be positive or negative.
- Unsigned integers have a `U` prefix: `UByte`, `UShort`, `UInt` or `ULong`, and can only represent numbers ≥ 0.
- Floating point types are `Float` (32-bit) or `Double` (64-bit).

Integer variables relying on type inference default to `Int`, even on 64-bit machines, but floating point variables default to `Double`.

Other types can, of course, be specified, but there are a few syntactic shortcuts, and big integer literals become `Long` if they would overflow `Int`.

```Kotlin
val one = 1 // defaults to Int
val threeBillion = 3_000_000_000 // Long, with optional underscores for clarity
val oneLong = 1L // Long
val oneByte: Byte = 1
val oneDouble = 1.0 // defaults to Double
val oneFloat = 1.0f // Float
val lightSpeed = 3.0e8 // scientific notation (units of m/s)
```

Hexadecimal literals start with `0x`, e.g. `0x7F`, and binary literals start with `0b`, e.g. `0b100101`.
Octal literals are not supported in Kotlin.

## Arithmetic

The basic arithmetic operators are the same as in many languages.
When the numbers in the calculation are the same type, the result will also be the same type:

```kotlin
4 + 3       // => 7     Int + Int = Int
4 - 3       // => 1     Int - Int = Int
4L * 3L     // => 12    Long * Long = Long
6.0 / 2.0   // => 3.0   Double / Double = Double
```

If the numbers are different types, Kotlin will infer the result's type to mitigate data loss:

```kotlin
4 + 3.0         // => 7.0                   Int + Double = Double
10.5 - 3.125f   // => 7.375                 Double - Float = Double
7L * 1.125      // => 7.875                 Long * Double = Double
10L / 3.0       // => 3.3333333333333335    Long / Double = Double
```

This is particularly significant for division, as dividing an integer (for example an Int) by another integer (for example an Int) will give an integer (in this case an Int):

```kotlin
4 / 3   // => 1     Int / Int always gives an Int
-8 / 3  // => -2    Truncated towards zero
```

To keep the decimal part, convert one of the numbers to a Float or Double:

```kotlin
-8.0 / 3    // => -2.6666666666666665
-8 / 3.0    // => -2.6666666666666665
-8.0 / 3.0  // => -2.6666666666666665
```


Division by zero is more interesting.

```Kotlin
1 / 0     // => java.lang.ArithmeticException: / by zero
3.0 / 0.0 // => Infinity
0.0 / 0.0 // => NaN (Not a Number)
```

That's because floating point operations follow the [IEEE-standard for Floating Point math](https://en.wikipedia.org/wiki/IEEE_754).

Integer division by zero is an error, but [IEEE floating point standards][wiki-IEEE] can apply in other cases.

The modulo operator `%` gives the remainder from integer division:

```Kotlin
8 % 3 // => 2
```

Kotlin, like other JVM languages, has no exponentiation operator (_this annoys scientists and engineers_).
We need to use the [`pow()`][ref-pow] function from the [`math`][ref-math] library, and the number being raised to some power must be `Float` or `Double`.

```kotlin
2.0.pow(3)  // => 8.0
2.pow(3)  // Unresolved reference (2 is Int, so not allowed)
```

## Rounding

The [`math`][ref-math] library contains several functions to round floating point numbers to a nearby integer.

_Did the last line sound slightly odd?_
When we say "a nearby integer", there are two questions:

- Is the return value still Float/Double, or is it converted to Int/Long?
- How are ties rounded? Does `4.5` round to `4` or `5`?

It is not Kotlin's fault if this seems complicated.
Mathematicians have been arguing about it for centuries.

### `round()`, `floor()`, `ceil()`, `truncate()`

These four functions all return the same floating-point type as the input, but differ in how they round.

- [`round()`][ref-round] gives the _nearest_ integer if this is unambiguous, or the _nearest even_ integer when tied.
- [`floor()`][ref-floor] rounds towards negative infinity.
- [`ceil()`][ref-ceil] rounds towards positive infinity
- [`truncate()`][ref-truncate] rounds towards zero

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

See the [manual][ref-conversions] for the full list of `toX()` methods.

[ref-numbers]: https://kotlinlang.org/docs/numbers.html
[wiki-IEEE]: https://en.wikipedia.org/wiki/IEEE_754
[ref-conversions]: https://kotlinlang.org/docs/numbers.html#explicit-number-conversions
[ref-pow]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/pow.html
[ref-math]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/
[ref-round]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/round.html
[ref-floor]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/floor.html
[ref-ceil]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/ceil.html
[ref-truncate]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/truncate.html
[wiki-overflow]: https://en.wikipedia.org/wiki/Integer_overflow
[ref-max_value]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/-companion/#-244053257%2FProperties%2F-956074838
[ref-min_value]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/-companion/#-1907397559%2FProperties%2F-956074838
