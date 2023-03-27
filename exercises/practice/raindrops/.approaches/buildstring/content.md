# `buildString`

```kotlin
object Raindrops {
    fun convert(num: Int) = buildString {
        if (num % 3 == 0) append("Pling")
        if (num % 5 == 0) append("Plang")
        if (num % 7 == 0) append("Plong")
        if (isEmpty()) append(num)
    }
}
```

An [object declaration][object] is used to define `Raindrops` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `convert` method.

The `convert` function is implemented with a call to the [`buildString`][buildstring] function.
Although the `convert` function has multiple lines, it consists only of the one `buildString` expression, so it is defined using
[single-expression function][single-expression-function] syntax, with the curly braces omitted from the `convert` function call
and the return type [inferred][type-inference].

The `builderAction` argument is a block of statements, each of which calls one or more methods on an implicit [`StringBuilder`][stringbuilder] object.
The [modulus operator][modulus-operator] (`%`) is used to check if the input number is evenly divisible by `3`, `5`, or `7`.
If so, then the [`append`][append] method is called on the`StringBuilder` to add the associated sound.

After all of the numbers have been checked, the [`isEmpty`][isempty] method of `StringBuilder` is used to see if no sound was added.
If no sound was added, then the input number number is automatically converted to a `String` when appended to the `StringBuilder`.

The `convert` function returns the result of calling `buildString`, which is the result of the implicit call to the [`toString`][tostring]
method of the `StringBuilder` after the block of statements in the `buildAction` argument.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[modulus-operator]: https://www.programiz.com/kotlin-programming/operators
[buildstring]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/build-string.html#buildstring
[stringbuilder]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/
[append]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/append.html
[isempty]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/is-empty.html
[tostring]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/to-string.html
