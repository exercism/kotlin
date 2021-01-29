import java.time.LocalDate
import java.time.LocalDateTime

data class Gigasecond(val initialDateTime: LocalDateTime) {

    constructor(initialDate: LocalDate): this(initialDate.atTime(0, 0))

    val date = initialDateTime.plusSeconds(1_000_000_000)
}
