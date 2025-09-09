# Introduction

A [`string`][ref-string] in Kotlin is an immutable sequence of Unicode characters.

[`Immutable`][wiki-immutable] means that any operation on a string must return a new string: the original string can never change.

[`Unicode`][wiki-unicode] means that most of the world's writing systems can be represented, but (in contrast to older languages such as C) there is no 1:1 mapping between characters and bytes.

A string is usually surrounded by double-quotes `" "`.

Some characters need escaping: `\'`, `\\`, plus the usual non-printing characters such as `\t` (tab) and `\n` (newline).

```kotlin
val s = "Escape apostrophe \' and backslash \\."
// Escape apostrophe ' and backslash \.
```

Multi-line strings are surrounded by 3 double-quotes, and can contain arbitrary text (no need for escaping).

```kotlin
val multi = """I'm a
    multi-line
    string with special characters \ \t """
//I'm a
//    multi-line
//    string with special characters  \ \t 
```

Use [trimIndent][trimIndent-doc] to remove the common indenting from the lines.
This is useful for formatting the string:

```kotlin
val multi = """
    I'm a
      multi-line
    string""".trimIndent()

//I'm a
//  multi-line
//string
```

Alternatively, [trimMargin][trimMargin-doc] lets you specify a delimiter.
Each line in the `String` then begins after the delimiter.
The delimiter defaults to `|`, but you can specify a different delimiter as a parameter.
For example:

```kotlin
val multi = """
    |I'm a
    |  multi-line
    |string""".trimMargin()

//I'm a
//  multi-line
//string

val multi2 = """
    start>I'm a
    start>  multi-line
    start>string""".trimMargin("start>")

//I'm a
//  multi-line
//string
```

Strings can be concatenated with `+`, but this is best limited to short and simple cases.
There are other and often better options.

## String templates

This refers to what some other languages call "interpolation".

If a string contains a dollar sign `$`, followed by an identifier, or contains braces (`{expression}`) surrounding an expression, those are substituted by respectively the value or the result of the expression.

```kotlin
val x = 42
val st = "x is $x, x squared is {x * x}"
// x is 42, x squared is 1764
```

The braces `{ }` are needed around expressions when parsing would otherwise be ambiguous.

In general, use of string templates is a more efficient and idiomatic way to combine strings than using `+`.

## String functions

Kotlin provides _many_ [`functions`][ref-string-functions] to manipulate strings.

Mostly, these are [`extensions functions`][ref-extensions] rather than members of the `String` class, though this has little effect on how we use them.

~~~~exercism/note
Kotlin's rather complex [documentation][ref-string-functions] pages hide extension functions in the default view.
Be sure to click `Members & Extensions` to expand this section.

[ref-string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
~~~~

The following examples show just a small selection of what is available:

```kotlin
val str = "Hello World!"

str.length              // => 12 (a property, not a function)
str.elementAt(6)        // => W
str.elementAtOrNull(20) // => null (index out of range)
str.substring(6, 11)    // => "World"
str.substringAfter(" ") // => "World!"

str.lowercase()         // => "hello world!"
str.uppercase()         // => "HELLO WORLD!"

str.startsWith("Hel")   // => true
str.endsWith("xyz")     // => false
str.indexOf("0")        // => 4

str.toCharArray()       // => [H, e, l, l, o,  , W, o, r, l, d, !]
"42".toInt() + 1        // => 43  (parsing; see also toFloat)

"Howdy!  ".trim()       // => "Howdy"
```


[ref-string]: https://kotlinlang.org/docs/strings.html
[wiki-immutable]: https://en.wikipedia.org/wiki/Immutable_object
[wiki-unicode]: https://en.wikipedia.org/wiki/Unicode
[ref-stringbuilder]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/
[ref-extensions]: https://kotlinlang.org/docs/extensions.html#extensions.md
[ref-string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
[trimIndent-doc]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/trim-indent.html
[trimMargin-doc]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/trim-margin.html
