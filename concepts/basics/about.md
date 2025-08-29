# About Basics

Kotlin is a statically typed language, designed to be fully interoperable with Java.

Distinguishing it from Java, Kotlin:

- has a cleaner, more concise syntax;
- incorporates many features of functional languages;
- has extensive support for nullable values.

## Variables

Because Kotlin is statically typed, it is necessary to _know_ the type of each value at compile time.

However, Kotlin's [type inference][inference] is very powerful, so _specifying_ the type is often optional.

There are two ways to declare a variable.

1. `val` creates an immutable variable, and trying to change it is a compile-time error.

```kotlin
val x = 42  // => 42
x = 43      // => 'val' cannot be reasssigned
```

2. `var` creates a mutable variable.

```Kotlin
var x = 42  // => 42
x = 43      // => 43
```

Because immutable variables eliminate a common class of bugs, use of `val` is encouraged whenever possible.

To reduce visual distraction, explicit types will mostly be omitted from this syllabus.
Nevertheless, it is recommended to specify types in all serious code (for safety, and for documentation).

```kotlin
val x: Int = 42  // => 42
```

In general, the names of variables and functions should be in camelCase, not snake_case

## Functions

Declare a function with the `fun` keyword.
Unlike Java, functions are not required to be part of a class.

```Kotlin
fun hello(): String {
    return "Hello, World!"
}

fun add(x: Int, y: Int): Int {
    return x + y
}
```

Some points to note:

- Parentheses `()` are needed after the function name, even if the function takes no arguments.
- Function arguments need to specify the type: there is no type inference (in contract to variables).
- The body of the function is enclosed in braces `{ }` (though see below).
- The `return` keyword is required, if returning a value.
- Semicolons `;` at the end of lines are optional, and usually omitted.
- Arithmetic operators `+`, `-`, `*`, `/` are similar to most mainstream languages.

However, for these very simple, "single-expression" functions, there is an abbreviated syntax:

```Kotlin
// return type is usually omitted for single-expression functions
fun add(x: Int, y: Int) = x + y  
```
Functions can have parameters with default values. 
These values will be used if they are omitted where the function is invoked:

```kotlin
fun ping(host: String = "localhost") {
    println("PING --> $host")
}

ping("exercism.io")  // PING --> exercism.io
ping()               // PING --> localhost
```

Functions within Exercism will usually return a value (because of the way the test runner is structured).
To use Kotlin more widely, it may be useful to know that a function which returns no value can omit the return type and the return keyword.

It is then said to have a `Unit` return type: equivalent to `void` in Java and several other languages.

## Comments

Single-line comments start with `//`, and the rest of the line is then ignored.

Multi-line comments start with `/*` and end with `*/`

```Kotlin
fun hello(): String {
    /*
     * Failing to run this program on a new installation 
     * is considered bad luck
    */
    return "Hello, World!" // the compiler pixies are now happy
}
```

This is the same as Java.

~~~~exercism-note
Because of the importance of Java interop, many Kotlin learners are at least somewhat familiar with Java.

We will try to point out similarities and differences between the languages throughout the syllabus.

_Please ignore this if you are a Kotlin-first learner!_
~~~~


[inference]: https://en.wikipedia.org/wiki/Type_inference
