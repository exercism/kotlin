# About chars

This is potentially a _big_ subject!
It is possible to write a long book about it, and several people have done so (search Amazon for "unicode book" to see some examples).

## A very brief history

Handling characters in computers was much simpler in earlier decades, when programmers assumed that English was the only important language.
So: 26 letters, upper and lower case, 10 digits, several punctuation marks, plus a code (0x07) to ring a bell, and it all fitted into 7 bits: the [ASCII][wiki-ascii] character set.

Naturally, people started asking what about à, ä and Ł, then other people started asking about ऄ, ஹ and ญ, and young people wanted emojis 😱.
What to do?

To cut a long story short, many smart and patient people had to serve on committees for years, working out the details of the [Unicode][web-unicode] character set, and of encodings such as [UTF-8][wiki-utf-8], and lots of software needed a _very_ complicated rewrite.
Also, lots of new bugs were introduced.

To prevent _everything_ breaking, the Unicode/UTF-8 design ensures that the first 127 codes are identical to ASCII _(even the bell)_.

## Characters in Kotlin

Languages designed after about 2005 have the huge advantage that a reasonably stable Unicode standard already existed.

Kotlin (first released in 2011) was able to assume that users would use a variety of (human) languages, and would need Unicode to express them.

[Characters][ref-char] in Kotlin are 16-bit by default: enough to express most written alphabets, but not the entire range of emojis.
Note that this is not the full Unicode/UTF-8 standard, which uses up to six bytes (48 bits) per character.

Character literals are written in single-quotes, and are distinct from strings written in double quotes.
This is probably obvious to people from the C/C++ world, but potentially confusing to Python and JavaScript programmers.

```kotlin
val a = 'a'
a::class.qualifiedName  // => kotlin.Char
a.code  // => 97

val jha = 'झ'  // Devanagari alphabet
jha.code  // => 2333

val heart = '❤'  // heart emoji
heart.code  // => 10084

Char.MAX_VALUE.code  // => 65535 (64k, the largest code point allowed)
```

Converting between `Char` and `Int` is simple:

```kotlin
a.code  // => 97  (a.toInt() is deprecated)
Char(97) // => 'a'
```

The compiler allows _some_ forms of integer arithmetic on `Char`s:

```kotlin
'a' + 5       // => 'f'
'c' - 'a'   // => 2
'c' + 'a'   // => error!

'f' + ('A' - 'a')  // => 'F' (same as 'f'.uppercase()

'f'.dec() // => 'e' (decrement)
'f'.inc() // => 'g' (increment)
```

## Some functions for `Char`

As always, there are far too [many functions][ref-char-lib] to discuss here, so this is just a selection.

- For appropriate alphabets, change case with [`uppercase()`][ref-uppercase] and [`lowercase()`][ref-lowercase].
- Test case with [`isUpperCase()`][ref-isuppercase] and [`isLowerCase()`][ref-islowercase].
- Test character type with:
    - [`isLetter()`][ref-isletter], covers many alphabets
    - [`isDigit()`][ref-isdigit], in range 0..9
    - `isLetterOrDigit()`, combines the previous two
    - [`isWhitespace()`][ref-iswhitespace], any whitespace character

```kotlin
'झ'.isLetter()      // => true
'A'.isLowerCase()   // => false
'4'.isDigit()       // => true
'\t'.isWhitespace() // => true  (tab character)
```
To check if a character is present in a `String`, or a `Char` list or array, we have `in`, equivalent to the [`contains()`][ref-contains] function.

```kotlin
val clist = "kotlin".toList()  // => [k, o, t, l, i, n]
't' in clist     // => true
't' in "kotlin"  // => true
```

Also, [regular expressions][ref-regex] (which will be the subject of a later Concept) allow powerful search and manipulation.

## Char List and String interconversions

For String to Char List, we can use `toList()`.

For Char List to String, there is the [`joinToString()`][ref-jointostring] function, which takes a separator (often the empty string) as argument.

```kotlin
val kt = "kotlin".toList()  // => [k, o, t, l, i, n]
kt.joinToString("")   // => "kotlin"
kt.joinToString("_")  // => "k_o_t_l_i_n"
```

Note that `joinToString()` operates on a List or Array.
To _cast_ a single `Char` to a 1-character string, use `toString()`.

```kotlin
'a'.toString() // => "a"
```


[ref-char]: https://kotlinlang.org/docs/characters.html
[ref-char-lib]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char/
[wiki-ascii]: https://en.wikipedia.org/wiki/ASCII
[web-unicode]: https://home.unicode.org/
[wiki-utf-8]: https://en.wikipedia.org/wiki/UTF-8
[ref-uppercase]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/uppercase.html
[ref-lowercase]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/lowercase.html
[ref-isuppercase]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/is-upper-case.html
[ref-islowercase]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/is-lower-case.html
[ref-isletter]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/is-letter.html
[ref-isdigit]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/is-digit.html
[ref-iswhitespace]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/is-whitespace.html
[ref-jointostring]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/join-to-string.html
[ref-contains]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/contains.html
[ref-regex]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-regex/
