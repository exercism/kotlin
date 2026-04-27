# Introduction

Classes can be used in Kotlin to encapsulate data and behavior.
A class is declared using the `class` keyword.
For example:

```kotlin
class Car
```

Make an instance of the class by calling it.

```kotlin
val instance = Car()
```

## Properties

In the above examples, the `Car` class was declared without any properties.
Class properties can be declared in the body, between `{}`, using `var` for mutable properties and `val` for immutable ones.
For example:

```kotlin
class Car {
    // color is mutable
    var color = "red"

    // year is immutable
    val year = 2025
}
```

Alternatively, the properties can be defined in a constructor that takes the properties.

## Constructors

Kotlin has two types of constructors - primary and secondary constructors.
The primary constructor is declared on the same line as the class declaration.
For example:

```kotlin
class Car constructor(var color : String = "red", val year : Int = 2025) {
    // ...
}
```

The `constructor` keyword can be omitted if there are no annotations and no visibility modifiers:

```kotlin
class Car(var color : String = "red", val year : Int = 2025) {
    // ...
}
```

~~~~exercism/note
Kotlin allows the class to be defined with a body if it contains only properties - no need for curly braces  `{}`:

```kotlin
class Car (var color : String = "red", val year : Int = 2025)
```
~~~~

A class can have only one primary constructor.
Secondary constructors are further constructors. that can be added by declaring them in the class body with the `constructor` keyword.
For example:

```kotlin
class Car constructor(var color : String = "red", val year : Int = 2025) {

    // This constructor allows the year to be provided as a String
    constructor(color : String = "red", yearText : String) : this(color, yearText.toIntOrNull() ?: 0)
}
```

Secondary constructors must invoke the primary constructor by calling `this`.

## Initializer blocks

The primary constructor sets the class' properties.
If more needs to be done during object creation, `init` blocks can be used to perform additional actions.

```kotlin
class Car constructor(var color: String = "red", val year : Int = 2025) {
    init {
        println("Car is ${color}, made in ${year}")
    }
}
```

## Functions

Functions can also be defined in the class body.
For example:

```kotlin
class Car (var color : String = "red", val year : Int = 2025) {
    fun repaint(newColor : String) {
        color = newColor
    }
}
```

## Visibility

Properties and functions can be either `private`, `public`, `internal` or `protected`.

- `private` can be accessed only within the class
- `protected` can be accessed by things within the class, as well as any subclasses
- `internal` can be accessed by things within the same module
- `public` can be accessed by other components using the class

For example:

```kotlin
class Car {
    private val color: String
    public val year: Int
    internal val model: String
    protected val brand: String

    private fun drive() {
        // ...
    }

    internal fun start() {
        // ...
    }

    protected fun stop() {
        // ...
    }

    public fun make() {
        // ...
    }
}
```
