# `hypot` for radius

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

An [object declaration][object] is used to define `Darts` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `score` method.

The object defines [private][visibility] [`const`][const] [val][variables]s for the rings.
The `const` values are given meaningful names instead of using the float literals as [magic numbers][magic-numbers].
A `val` is immutable, as is a `const`.
A `const` `val` means that the value of the `val` is known at compile time.

The [`hypot`][hypot] function is used to calculate the [radius][radius] of the dart throw from the `x` and `y` coordinates.

The `throwWithin` function returns if the radius is within the ring passed in.

Due to the naming of the function and varables, the `if` statements read much like natural language.

The `throwWithin` function is passed the ring.
If it returns `true`, then the function returns with the score for throwing within that ring.

If the throw is not within a defined ring, then the function returns `0`.

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[visibility]: https://kotlinlang.org/docs/visibility-modifiers.html
[const]: https://www.geeksforgeeks.org/whats-the-difference-between-const-and-val-in-kotlin/
[variables]: https://kotlinlang.org/docs/basic-syntax.html#variables
[magic-numbers]: https://en.wikipedia.org/wiki/Magic_number_(programming)
[hypot]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/hypot.html
[radius]: https://www.mathopenref.com/coordbasiccircle.html

