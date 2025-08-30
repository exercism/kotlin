# Introduction

A [`string`][string] in Kotlin is an immutable sequence of Unicode characters.

[`Immutable`][immutable] means that any operation on a string must return a new string: the original string can never change.

[`Unicode`][unicode] means that most of the world's writing systems can be represented, but (in contrast to older languages such as C) there is no 1:1 mapping between characters and bytes.

A string is usually surrounded by double-quotes `" "`.

Some characters need escaping: `\'`, `\\`, plus the usual non-printing characters such as `\t` (tab) and `\n` (newline).

```kotlin
val s = "Escape apostrophe \' and backslash \\."
// Escape apostrophe ' and backslash \.
```

Raw strings use 3 double-quotes, and can contain arbitrary text (no need for escaping).
Multiline strings are also supported, including flexible handling of indents.

```kotlin
val multi = """I'm a
    |multi-line
    |string with special characters \ \t """

multi.trimMargin()  // delimiter defaults to | but can be specified
//I'm a
//multi-line
//string with special characters  \ \t 
```

Strings can be concatenated with `+`, but this is best limited to short and simple cases.
There are other and often better options.

## String templates

This refers to what some other languages call "interpolation".

if a dollar sign `$` is followed by an identifier or expression within a string, the _value_ is substituted.

```kotlin
val x = 42
val st = "x is $x, x squared is ${x * x}"
// x is 42, x squared is 1764
```

The braces `{ }` are needed around expressions when parsing would otherwise be ambiguous.

In general, use of string templates is a more efficient and idiomatic way to combine strings than using `+`.

## String formatting

On the JVM platform, `String.format()` allows more precise formatting than string templates, with [syntax][formats] similar to the (_very old!_) [`printf`][printf] functions.

```kotlin
String.format("%s %.3f", "π ≈", 3.14159)
//π ≈ 3.142
```

## String functions

Kotlin provides _many_ [`functions`][string-functions] to manipulate strings.

Mostly, these are [`extensions functions`][extensions] rather than members of the `String` class, though this has little effect on how we use them.

***Note:*** _Kotlin's rather complex [documentation][string-functions] pages hide extension functions in the default view.
Be sure to click `Members and Extensions` to expand this section._

The following example shows just a small selection of what is available:

```kotlin
val str = "Hello World!"

str.length              // => 12 (a property, not a function)
str.elementAt(6)        // => W
str.elementAtOrNull(20) // => null (index out of range)
str.substring(6, 11)    // => "World"

str.lowercase()        // => "hello world!"
str.uppercase()        // => "HELLO WORLD!"

str.startsWith("Hel")  // => true
str.endsWith("xyz")    // => false

str.toCharArray()      // => [H, e, l, l, o,  , W, o, r, l, d, !]
"42".toInt() + 1       // => 43  (parsing; see also toFloat)
```


[string]: https://kotlinlang.org/docs/strings.html
[immutable]: https://en.wikipedia.org/wiki/Immutable_object
[unicode]: https://en.wikipedia.org/wiki/Unicode
[formats]: https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#summary
[printf]: https://en.wikipedia.org/wiki/Printf
[stringbuilder]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/
[extensions]: https://kotlinlang.org/docs/extensions.html#extensions.md
[string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
