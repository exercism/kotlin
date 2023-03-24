# `isLeap()`

```kotlin
import java.time.*

data class Year(val year: Int) {
    val isLeap = LocalDate.of(year, Month.FEBRUARY, 28).isLeapYear
}
```

This may be considered a "wicked cheat" for this exercise, by simply passing the year into the [isLeap()][is-leap] method of the [Year][year] class.
Although it is not in the spirit of this exercise, `isLeap()` would be the idiomatic way to determine if a year is a leap year in the "real world".

[is-leap]: https://docs.oracle.com/javase/8/docs/api/java/time/Year.html#isLeap--
[year]: https://docs.oracle.com/javase/8/docs/api/java/time/Year.html
