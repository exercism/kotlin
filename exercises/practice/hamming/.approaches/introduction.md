# Introduction

There are several ways to solve Hamming.
One approach is to use [`zip`][zip] with [`count`][count].

## Approach: `zip` with `count`

```kotlin
object Hamming {

    fun compute(leftStrand: String, rightStrand: String) =
        if (leftStrand.length != rightStrand.length)
            throw IllegalArgumentException("left and right strands must be of equal length")
        else
            (leftStrand zip rightStrand).count { it.first != it.second }
}
```

For more information, check the [`zip` with `count` approach][approach-zip-count].

[approach-zip-count]: https://exercism.org/tracks/kotlin/exercises/hamming/approaches/zip-count
[zip]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/zip.html
[count]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/count.html
