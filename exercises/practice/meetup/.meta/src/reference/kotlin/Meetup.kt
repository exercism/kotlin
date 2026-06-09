import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(monthOfYear: Int, year: Int) {

    private val startOfMonth: LocalDate = LocalDate.of(year, monthOfYear, 1)

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        val nextDate = cycleToNext(dayOfWeek, startOfMonth)

        return when (schedule) {
            MeetupSchedule.FIRST -> nextDate
            MeetupSchedule.SECOND -> nextDate.plusWeeks(1)
            MeetupSchedule.THIRD  -> nextDate.plusWeeks(2)
            MeetupSchedule.FOURTH -> nextDate.plusWeeks(3)
            MeetupSchedule.LAST   -> cycleToPrev(dayOfWeek, startOfMonth.plusMonths(1).minusDays(1))
            MeetupSchedule.TEENTH -> nextTeenth(nextDate)
        }
    }

    private fun nextTeenth(from : LocalDate) : LocalDate {
        var result = from
        while (result.dayOfMonth < 13) {
            result = result.plusWeeks(1)
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
