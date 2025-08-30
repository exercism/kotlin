# About Strings

A [`string`][string] in Kotlin is an immutable sequence of Unicode characters.

[`Immutable`][immutable] means that any operation on a string must return a new string: the original string can never change.

[`Unicode`][unicode] means that most of the world's writing systems can be represented, but (in contrast to older languages such as C) there is no 1:1 mapping between characters and bytes.
This will be discussed further in the [`Chars`][chars] Concept.

A string is surrounded by double-quotes `" "`.

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

[`Templates`][templates] refers to what some other languages call "interpolation".

if a dollar sign `$` is followed by an identifier or expression within a string, the _value_ is substituted.

```kotlin
val x = 42
val st = "x is $x, x squared is ${x * x}"
// x is 42, x squared is 1764
```

The braces `{ }` are needed around expressions when parsing would otherwise be ambiguous.

## String formatting

On the JVM platform (only), `String.format()` allows more precise formatting than string templates, with [syntax][formats] similar to the (_very old!_) [`printf`][printf] functions.

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

## Building a string

Sometimes a long string needs to be built up in stages, for example within a loop.

Concatenating strings with `+` soon becomes neither elegant nor performant: immutability means that there is a _lot_ of copying required.

Kotlin has various more efficient ways to combine multiple string:

- String templates, described above.
- [`joinToString()][jointostring], which will be covered in the [Lists][lists] Concept.
- Java's [`StringBuilder`][stringbuilder], which is not regarded as particularly idiomatic Kotlin.
- Kotlin's [`buildString()`][buildstring], which wraps `StringBuilder` in a more concise and idiomatic syntax.
This takes string-building logic as a lambda argument, which will be discussed in a later Concept.

In essence, a `StringBuilder` is a list-like structure, with many convenient methods.
This is a small selection:

- [`append()`][sb-append] to add to the end.
- [`insert()`][sb-insert] to add at a specified position.
- [`deleteAt()`][sb-deleteat] and [`deleteRange()`][sb-deleterange] to remove from specified position(s).
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


[string]: https://kotlinlang.org/docs/strings.html
[immutable]: https://en.wikipedia.org/wiki/Immutable_object
[unicode]: https://en.wikipedia.org/wiki/Unicode
[formats]: https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#summary
[printf]: https://en.wikipedia.org/wiki/Printf
[stringbuilder]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/
[extensions]: https://kotlinlang.org/docs/extensions.html#extensions.md
[string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
[chars]: https://exercism.org/tracks/kotlin/concepts/chars
[lists]: https://exercism.org/tracks/kotlin/concepts/lists
[templates]: https://kotlinlang.org/docs/strings.html#string-templates
[sb-append]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#9100522%2FFunctions%2F-705004581
[sb-insert]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#-132863384%2FFunctions%2F-705004581
[sb-deleteat]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#-386007892%2FFunctions%2F-956074838
[sb-deleterange]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/#-1622040372%2FFunctions%2F-956074838
[buildstring]: https://kotlinlang.org/docs/java-to-kotlin-idioms-strings.html#build-a-string
[jointostring]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/join-to-string.html
