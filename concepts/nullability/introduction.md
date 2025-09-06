# Introduction

In an ideal world, we could rely on everything being nicely defined, with concrete values and no gaps.

This conflicts with our everyday experience, and thus many programming languages have a way to represent the absence of a value: null or NULL, nil, None, nothing...

This was easy to introduce (back in 1965), but soon led to regrets.
The inventor later called it his "Billion Dollar Mistake".

In recent decades, language designers have explored many ways to make nulls available but (mostly) safe.

Kotlin has a few [general principles][ref-null-safety], which differ significantly from Java.


- Kotlin has a special `null` value.
- All types _default_ to being non-nullable.
- Most types can be _made_ nullable, but the programmer must explicitly order this.
- Functions which might fail with an exception are likely to have a variant with a nullable return value.
- Special, highly terse syntax tries to make testing for and responding to nulls as easy as possible.

## Creating nullable variables

Standard types generally have a nullable equivalent, with a `?` suffix: for example `String?` instead of `String`.

```kotlin
var a = "Kotlin"  // inferred type is String
a = null          // => Error: Null can not be a value of a non-null type String

var b: String? = "Kotlin"  // nullable type
b = null                   // => b is now null
b == null                  // => true
```

## Useful operators and functions

### The safe call operator `?.`

For a non-nullable `String`, we can get the `.length` property.

A nullable `String?` fails with the same syntax, but using `?.length` allows for the possibility of a `null`.
The return type is `Int?`.

```kotlin
var a = "Kotlin"
a.length  // => 6

// b is still null
b.length  // => Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
b?.length // => null
a?.length // => 6
```

As we saw in the last line above, `?.` also works with non-nullable types.

### The Elvis operator `?:`

Extending the idea of the safe-call operator, the [Elvis operator][wiki-elvis] lets us supply a default value to replace `null`.

```kotlin
// b is still null
b?.length ?: -1  // => -1, in place of null
a?.length ?: -1  // => 6, as before
```

### Not-null assertion operator `!!`

With this operator, a nullable type is forced to be treated as non-null, when the programmer is confident about this.
Perhaps we sometimes understand the program logic better than an over-cautious compiler?

```kotlin
// b is still a String?
b = "Kotlin?"
b!!.length  // => 7
```

The responsibility is now on us: if `b` is still `null` we get a `NullPointerException`.

### Let function `?.let`

If passing a nullable item to a block of code, we could do specific null checks `if (item != null) { do something }`.

It is simpler and more idiomatic to use `item?.let { do something }`,
The `do something` will only execute when `item` is not null.

### Functions of type `somethingOrNone()`

Some functions may fail, for example when asking for an invalid index in a string or list.

Rather than throwing an exception, we could use the `...OrNull` variant of the function, to get (in this case) an `Int?` return value.

```kotlin
val str = "Kotlin"
str.elementAtOrNull(10)  // => null
str.elementAt(10)  // => StringIndexOutOfBoundsException: String index out of range: 10
```


[web-mistake]: https://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare/
[ref-null-safety]: https://kotlinlang.org/docs/null-safety.html
[wiki-elvis]: https://en.wikipedia.org/wiki/Elvis_operator
