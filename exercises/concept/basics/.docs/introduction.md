Kotlin is **statically typed** programming language developed by JetBrains. This means that type of variables is defined on compile-time.

## Variables

Similarly to other statically-typed programming languages type of each variable should be defined in compile time. Similarly to other **modern** programming languages you can avoid explicit type declarations where they can be interfered by compiler from context. Use this ability to make your code more readable. But remember that there are cases where it's better to specify type explicitly - e.g. in public APIs.

Kotlin has immutable (`val`) and mutable (`var`) variable. Immutable variable means that once it has it's value assigned - it can't be changed. Most of the time you will use this type of variable.

```kotlin
val robotName = "HAL-9000"
userId = "T-1000"  // This will not compile
```

Mutable variable means that it's value can be changed one or more times:

```kotlin
var index = 12
print(index)  // 12

index = 100
print(index)  // 100
```

BTW probably you have already noticed that semicolons in Kotlin are not used (they are optional but not needed except few special cases we will explore later in other exercises).

## Functions

Functions in Kotlin are defined with keyword **`fun`** and are [first-class citizens][wiki-fcc] (not related to OOP). It means that you can declare (so-called `top-level functions`) them right in files (e.g. in Java you can define methods only in classes, not in files):

```kotlin
// This is content of the Hello.kt file

fun hello() {}
```

Functions can receive arguments. Each argument have a name and a type. Probably you remember that compiler is smart enough to understand type of variable In many cases, but you always need to write types for function arguments by yourself as you are declaring certain contract. Functions can have zero or more arguments:

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

As you can see, to return value from function you need to use keyword **`return`**:

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

[wiki-fcc]: https://en.wikipedia.org/wiki/First-class_citizen
