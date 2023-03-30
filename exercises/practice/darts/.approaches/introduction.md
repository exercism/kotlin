# Introduction

There are several ways to solve Darts.
One approach is to use the [`hypot`][hypot] function to get the [radius][radius] of the throw.

## Approach: `hypot` for radius

```kotlin
import kotlin.math.hypot

object Darts {
    private const val innerRing = 1.0
    private const val middleRing = 5.0
    private const val outerRing = 10.0

    fun score(x: Number, y: Number): Int {
        val toss = hypot(x.toDouble(), y.toDouble())
        fun throwWithin(ring: Double) = toss <= ring

        if (throwWithin(innerRing)) return 10
        if (throwWithin(middleRing)) return 5
        if (throwWithin(outerRing)) return 1
        return 0
    }
}
```

For more information, check the [`hypot` for radius approach][approach-hypot-for-radius].

[approach-hypot-for-radius]: https://exercism.org/tracks/kotlin/exercises/darts/approaches/hypot-for-radius
[hypot]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/hypot.html
[radius]: https://www.mathopenref.com/coordbasiccircle.html
