# `groupBy` with `+`

```kotlin
class Dna(val sequence: String) {
    init {
        require(sequence.all { it in "ACGT" })
    }
    val nucleotideCounts
        get() = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) + sequence.groupingBy { it }.eachCount()
}
```

## Verification
We receive a sequence as input, which we have to verify.
Because the sequence is part of the primary constructor, which can't contain runnable code, we have to place the check in an [_initializer block_][stdlib-constructors].
In Kotlin it's idiomatic to use the [`require`][stdlib-require] keyword for verification.
`require` will throw an `IllegalArgumentException` if the given value is `false`.
```kotlin
init {
    require(sequence.all { it in "ACGT" })
}
```

## Base Map
We define a base map with a zero value for every nucleotide.
We do this to ensure that every nucleotide will be present in the output, even if there is no count.
Afterward we can overwrite some of the values by using the `+` operator.
Note that the [`+` operator on maps][map-plus] does not add the values but overwrites them.
```kotlin
val nucleotideCounts
    get() = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
```

## Counting Nucleotides
We use the `.groupingBy` function to create a [`Grouping`][stdlib-grouping] of the nucleotides.
By using the `.eachCount()` function we turn the [`Grouping`][stdlib-grouping] in a Map.
For example: `"ACA".groupingBy { it }.eachCount()` results in `{A=2, C=1}`.
After [adding][map-plus] the maps together we receive our final answer.
```kotlin
val nucleotideCounts
    get() = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) + sequence.groupingBy { it }.eachCount()
```

[stdlib-require]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html
[stdlib-constructors]: https://kotlinlang.org/docs/classes.html#constructors
[stdlib-grouping]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-grouping/
[stdlib-eachcount]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/each-count.html
[map-plus]: https://kotlinlang.org/docs/map-operations.html#plus-and-minus-operators
