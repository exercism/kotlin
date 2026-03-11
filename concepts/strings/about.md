# About Strings

A [`string`][ref-string] in Kotlin is an immutable sequence of Unicode characters.

[`Immutable`][wiki-immutable] means that any operation on a string must return a new string: the original string can never change.

[`Unicode`][wiki-unicode] means that most of the world's writing systems can be represented, but (in contrast to older languages such as C) there is no 1:1 mapping between characters and bytes.
This will be discussed further in the [`Chars`][concept-chars] Concept.

A string is surrounded by double-quotes `" "`.

Some characters need escaping: `\\`, plus the usual non-printing characters such as `\t` (tab) and `\n` (newline).

```kotlin
val s = "Escape backslash \\."
// Escape backslash \.
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

[`Templates`][ref-templates] refers to what some other languages call "interpolation".

If a string contains a dollar sign `$`, followed by an identifier, or contains braces (`{expression}`) surrounding an expression, those are substituted by respectively the value or the result of the expression.

```kotlin
val x = 42
val st = "x is $x, x squared is {x * x}"
// x is 42, x squared is 1764
```

## String formatting

On the JVM platform (only), `String.format()` allows more precise formatting than string templates, with [syntax][web-formats] similar to the (_very old!_) [`printf`][wiki-printf] functions.

```kotlin
String.format("%s %.3f", "π ≈", 3.14159)
//π ≈ 3.142
```

~~~~exercism/advanced
Kotlin can be compiled to several different targets: the Java Virtual Machine, JavaScript, native binaries for Linux, Windows, Android and Apple, plus two variants of WebAssembly.

Essentially the same code can be used for each, but different capabilities in the target platforms mean some differences in which standard library functions are supported.

Exercism currently uses the JVM for testing.
~~~~

## String functions

Kotlin provides _many_ [`functions`][ref-string-functions] to manipulate strings.

Mostly, these are [`extensions functions`][ref-extensions] rather than members of the `String` class, though this has little effect on how we use them.

~~~~exercism/note
Kotlin's rather complex [documentation][ref-string-functions] pages hide extension functions in the default view.
At moment of writing this, the most valuable content is hidden in a tab named `Members & Extensions`.
Click it to expand this section and see all the members and extensions available on the `String` class.

[ref-string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
~~~~

The following example shows just a small selection of what is available:

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

## Building a string

Sometimes a long string needs to be built up in stages, for example within a loop.

Concatenating strings with `+` soon becomes neither elegant nor performant: immutability means that there is a _lot_ of copying required.

Kotlin has various more efficient ways to combine multiple string:

- String templates, described above.
- [`joinToString()][ref-jointostring], which will be covered in the [Lists][concept-lists] Concept.
- Java's [`StringBuilder`][ref-stringbuilder], which is not regarded as particularly idiomatic Kotlin.
- Kotlin's [`buildString()`][ref-buildstring], which wraps `StringBuilder` in a more concise and idiomatic syntax.
This takes string-building logic as a lambda argument, which will be discussed in a later Concept.

In essence, a `StringBuilder` is a list-like structure, with many convenient methods.
This is a small selection:

- [`append()`][ref-sb-append] to add to the end.
- [`insert()`][ref-sb-insert] to add at a specified position.
- [`deleteAt()`][ref-sb-deleteat] and [`deleteRange()`][ref-sb-deleterange] to remove from specified position(s).
- `toString()` to convert to a normal string at the end: concatenating everything in a single, performant operation.

```kotlin
// Available, not recommended
val sb = StringBuilder()
sb.append("Hello ")
sb.append("World!")
sb.toString()
//Hello World!
```

A `buildString()` example, using syntax from later Concepts:

```kotlin
val countDown = buildString {
    for (i in 5 downTo 1) {
        append(i)
        append("_")
    }
}
// countDown is "5_4_3_2_1_"
```


[ref-string]: https://kotlinlang.org/docs/strings.html
[wiki-immutable]: https://en.wikipedia.org/wiki/Immutable_object
[wiki-unicode]: https://en.wikipedia.org/wiki/Unicode
[web-formats]: https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#summary
[wiki-printf]: https://en.wikipedia.org/wiki/Printf
[ref-stringbuilder]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/
[ref-extensions]: https://kotlinlang.org/docs/extensions.html#extensions.md
[ref-string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
[concept-chars]: https://exercism.org/tracks/kotlin/concepts/chars
[concept-lists]: https://exercism.org/tracks/kotlin/concepts/lists
[ref-templates]: https://kotlinlang.org/docs/strings.html#string-templates
[ref-sb-append]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#9100522%2FFunctions%2F-705004581
[ref-sb-insert]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#-132863384%2FFunctions%2F-705004581
[ref-sb-deleteat]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#-386007892%2FFunctions%2F-956074838
[ref-sb-deleterange]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#-1622040372%2FFunctions%2F-956074838
[ref-buildstring]: https://kotlinlang.org/docs/java-to-kotlin-idioms-strings.html#build-a-string
[ref-jointostring]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/join-to-string.html
[trimIndent-doc]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/trim-indent.html
[trimMargin-doc]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/trim-margin.html
