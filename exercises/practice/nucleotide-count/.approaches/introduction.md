# Introduction

Each solution has to contain the following three elements:
- Check the input for any invalid characters.
- Count the presence of every nucleotide.
- Ensure that the missing nucleotides are also present in the output.

## Approach: `groupBy` with `+`
One approach is to use `groupBy` and the `+` operator:
```kotlin
class Dna(val sequence: String) {
    init {
        require(sequence.all { it in "ACGT" })
    }

    val nucleotideCounts
        get() = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) + sequence.groupingBy { it }.eachCount()
}
```

For more information, check the [`groupBy` with `+` approach][approach-groupby-plus].

[approach-groupby-plus]: https://exercism.org/tracks/kotlin/exercises/nucleotide-count/approaches/groupby-plus
