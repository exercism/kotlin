# Introduction

Kotlin is a **statically typed** programming language developed by JetBrains. This means that the type of variables is defined at compile-time.

## Variables

Similarly to other statically-typed programming languages, the type of each variable should be defined at compile time. You can avoid explicit type declarations where they can be inferred by the compiler from their context.

Kotlin has immutable (`val`) and mutable (`var`) variables. The value of an immutable variable can't be changed after it's initial value is assigned. Most of the time you will use this type of variable.

```kotlin
val robotName = "HAL-9000"
userId = "T-1000"  // This will not compile
```

A mutable variable's value can be changed one or more times:

```kotlin
var index = 12
print(index)  // 12

index = 100
print(index)  // 100
```

Semicolons in Kotlin are optional, except for a few special cases that will be covered later.

## Functions

Functions in Kotlin are defined with the `fun` keyword and are _first-class citizens_ (not related to OOP). It means that you can declare (so-called `top-level functions`) them right in files (e.g. in Java you can define methods only in classes, not in files):

```kotlin
// This is content of the Hello.kt file

fun hello() {}
```

Functions can receive arguments. Each argument has a name and a type. Unlike variables, the type of arguments can't be inferred. Functions can have zero or more arguments:

```kotlin
fun hello() {}

fun hello(name: String) {}

fun hello(name: String, age: Int) {}
```

Kotlin functions might or might not return a value:

```kotlin
fun min(a: Int, b: Int): Int

fun countBonuses(user: User): Bonuses

fun run() {}
```

To return a value from a function, the `return` keyword is used:

```kotlin
fun getName(): String {
    return "Alice"
}
```

Functions can have parameters with default values. These values will be used if they are omitted where function is invoked:

```kotlin
fun ping(host: String = "localhost") {
    println("PING --> $host")
}

ping("exercism.io")  // PING --> exercism.io
ping()               // PING --> localhost
```

## Comments

Use `//` to define single-line comment:

```kotlin
foo() // Everything after `//` will be ignored by compiler

// I will be ignored too
```

or `/*` and `*/` to define multi-line comments:

```kotlin
/*
   This this an example
   for a multiline comment
*/
```
