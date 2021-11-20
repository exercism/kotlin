import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(monthOfYear: Int, year: Int) {

    private val startOfMonth: LocalDate = LocalDate.of(year, monthOfYear, 1)

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        var result = cycleToNext(dayOfWeek, startOfMonth)

        @Suppress("NON_EXHAUSTIVE_WHEN")
        when (schedule) {
            MeetupSchedule.SECOND -> result = result.plusWeeks(1)
            MeetupSchedule.THIRD  -> result = result.plusWeeks(2)
            MeetupSchedule.FOURTH -> result = result.plusWeeks(3)
            MeetupSchedule.LAST   -> result = cycleToPrev(dayOfWeek, startOfMonth.plusMonths(1).minusDays(1))
            MeetupSchedule.TEENTH -> {
                while (result.dayOfMonth < 13) result = result.plusWeeks(1)
            }

            // TODO: This may need to be fixed in the future as Kotlin 1.7+ may raise a compilation error for
            //  non-exhaustive when blocks.
        }

        return result
    }

    private fun cycleToPrev(dayOfWeek: DayOfWeek, current: LocalDate): LocalDate {
        var result = current

        while (result.dayOfWeek != dayOfWeek) {
            result = result.minusDays(1)
        }

        return result
    }

    private fun cycleToNext(dayOfWeek: DayOfWeek, current: LocalDate): LocalDate {
        var result = current

        while (result.dayOfWeek != dayOfWeek) {
            result = result.plusDays(1)
        }

        return result
    }

}
