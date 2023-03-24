# `plusDays()` method

```kotlin
import java.time.*

data class Year(val year: Int) {
    val isLeap = LocalDate.of(year, Month.FEBRUARY, 28).plusDays(1).dayOfMonth == 29
}
```

This approach may be considered a "cheat" for this exercise.
By adding a day to February 28th for the year, you can see if the new day is the 29th or the 1st.
If it is the 29th, then the year is a leap year.
This is done by using the [`plusDays()`][plusdays] and [`getDayOfMonth()`][getdayofmonth] methods of the [LocalDate][localdate] class.

[plusdays]: https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/LocalDate.html#plusDays(long)
[getdayofmonth]: https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/LocalDate.html#getDayOfMonth()
[localdate]: https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/LocalDate.html
