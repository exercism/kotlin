# What's next?

## Submitting your solution

_Hint_: Use `Code --> Reformat` in [IntelliJ IDEA][intellij-idea-ic] to automatically format your code.

## Entry point

To run your Kotlin program you need to define so-called entry point: function with name `main` with or without arguments. However, in Exercism course we are using automatic tests that are using other functions defined in exercises.

Entry point with arguments (you can use them for building CLI applications):

```kotlin
fun main(args: Array<String>) {
    println("Hello, Exercism!")
    println("Program args are: $args")
}
```

Or ignore arguments completely:

```kotlin
fun main() {
    println("Hello, Exercism!")
}
```

## `Unit` return type

You've seen that some functions (like `main()` above) are not returning value. However, they are implicitly returning value that is called `Unit` (quite similar to `void` in Java/C/C++):

```kotlin
fun run() {}

// is the same as
fun run(): Unit { return Unit }
```

Returning `Unit` (and using it in function declaration) is completely optional and is omitted in most of the cases.

[intellij-idea-ic]: https://www.jetbrains.com/idea/download/
