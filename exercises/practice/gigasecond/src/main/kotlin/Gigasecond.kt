import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(val ldt: LocalDateTime) {

    constructor(ld: LocalDate): this(ld.atTime(0, 0))

    val date = ldt.plusSeconds(1_000_000_000)
}
