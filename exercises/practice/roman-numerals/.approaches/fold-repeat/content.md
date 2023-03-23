# `fold` with `repeat`

```kotlin
object RomanNumerals {

    fun value(n: Int) =
            listOf(
                            1000 to "M",
                            900 to "CM",
                            500 to "D",
                            400 to "CD",
                            100 to "C",
                            90 to "XC",
                            50 to "L",
                            40 to "XL",
                            10 to "X",
                            9 to "IX",
                            5 to "V",
                            4 to "IV",
                            1 to "I"
                    )
                    .fold(Pair(StringBuilder(), n)) { (output, runnyNum), (value, numeral) ->
                        when {
                            runnyNum >= value ->
                                    output.append(numeral.repeat(runnyNum / value)) to
                                            runnyNum % value
                            else -> output to runnyNum
                        }
                    }
                    .first
                    .toString()
}
```

An [object declaration][object] is used to define `RomanNumerals` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `value` method.

The [`listOf`][listof] method is used to create a list of [`Pair`][pair]s that associate an Arabic numeral with its Roman numeral.

The [`fold`][fold] method is called on the `List`.
Its accumulating value is initialized with a `Pair`, with a [`StringBuilder`][stringbuilder] for the output and an `Int` to hold the value of the input number
as it is calculated down.

The [lambda][lambda] of `fold` takes the accumulating value `Pair` as well as the `Pair` of each `List` element being iterated.

The running number is tested in a [`when`][when] expression.
If it is greater than or equal to the Arabic value in the currently iterated `Pair`,
then the [`repeat`][repeat] method is used to [`append`][append] the Roman numeral to the `StringBuilder`
for as many times as the running number can be divided by the Arabic value with a result greater than 0.
That arm of the `when` uses the [`to`][to] keyword to return the `StringBuilder` and the remainder of dividing the running number by the Arabic value.

If the running number is less than the Arabic value, then the `when` expression returns the `StringBuilder` and the running number as is.

When `fold` has iterated through all of the `List` elements, the first item in the accumulating value `Pair` is the `StringBuilder`.
The `value` function returns the result of calling the [`toString`][tostring] method on the `StringBuilder`.

Although the `value` function has multiple lines, it consists only of the one expression of chained methods, so it is defined using
[single-expression function][single-expression-function] syntax, with the curly braces omitted and the return type [inferred][type-inference].

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[listof]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html
[list]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/
[pair]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/
[fold]: https://kotlinlang.org/docs/collection-aggregate.html#fold-and-reduce
[stringbuilder]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/
[when]: https://kotlinlang.org/docs/control-flow.html#when-expression
[lambda]: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
[append]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/append.html
[repeat]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/repeat.html
[to]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html
[tostring]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/to-string.html
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
