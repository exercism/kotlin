# Secondary constructor with `atStartOfDay`

```kotlin
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(baseDatetime: LocalDateTime) {
    private val gigaseconds: Long = 1_000_000_000
    val date: LocalDateTime = baseDatetime.plusSeconds(gigaseconds)

    constructor(baseDate: LocalDate) : this(baseDate.atStartOfDay())
}
```

This approach starts by importng from libraries for what is needed.

The `Gigasecond` class is defined with a [primary constructor][constructors] that takes a `LocalDateTime`.

A [`private`][visibility] [`val`][variables] is defined to hold the value for one billion seconds.
A `val` with a meaningful name is used instead of using the `1000000000` value as a [magic number][magic-number].
Note that [digit separators][digit-separators] (`_`) can make long numbers more readable.

Another `val` is defined that uses the [`plusSeconds`][plusseconds] method to add a billion seconds to the value passed into the primary constructor.

The `constructor` keyword is used to define a secondary constructor that takes a `LocalDate`.
It uses the `this` keyword to call another constructor (in this case, the primary constructor.)
The [`atStartOfDay`][atstartofday] method is used to convert the `LocalDate` to the `LocalDateTime` type accepted by the primary constructor.
Calling one constructor from another is referrred to as "constructor chaining".

[constructors]: https://www.geeksforgeeks.org/kotlin-constructor/
[visibility]: https://kotlinlang.org/docs/visibility-modifiers.html
[variables]: https://kotlinlang.org/docs/basic-syntax.html#variables
[magic-number]: https://en.wikipedia.org/wiki/Magic_number_(programming)
[digit-separators]: https://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html
[plusseconds]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html#plusSeconds-long-
[atstartofday]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#atStartOfDay--
[localdate]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
