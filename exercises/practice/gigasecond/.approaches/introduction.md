# Introduction

There are several ways to solve Gigasecond.
One approach is to use a [secondary constructor][constructors] with the [`atStartOfDay`][atstartofday] method of the [`LocalDate`][localdate] class.

## Approach: Secondary constructor with `atStartOfDay`

```kotlin
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(baseDatetime: LocalDateTime) {
    private val gigaseconds: Long = 1_000_000_000
    val date: LocalDateTime = baseDatetime.plusSeconds(gigaseconds)

    constructor(baseDate: LocalDate) : this(baseDate.atStartOfDay())
}
```

For more information, check the [Secondary constructor with atStartOfDay approach][approach-secondary-constructor-atstartofday].

[approach-secondary-constructor-atstartofday]: https://exercism.org/tracks/kotlin/exercises/gigasecond/approaches/secondary-constructor-atstartofday

[constructors]: https://www.geeksforgeeks.org/kotlin-constructor/
[atstartofday]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#atStartOfDay--
[localdate]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
