data class Clock(private var hours: Int, private var minutes: Int) {

    companion object {
        private const val MINUTES_IN_AN_HOUR = 60
        private const val HOURS_IN_A_DAY = 24
    }

    init {
        sanitiseTime()
    }

    override fun toString(): String {
        return "${hours.toTimeString()}:${minutes.toTimeString()}"
    }

    fun add(minutes: Int) {
        this.minutes += minutes
        sanitiseTime()
    }

    fun subtract(minutes: Int) = add(minutes * -1)

    private fun sanitiseTime() {
        while (minutes < 0) {
            minutes += MINUTES_IN_AN_HOUR
            hours--
        }

        while (hours < 0) {
            hours += HOURS_IN_A_DAY
        }

        val minutesOverflow = minutes / MINUTES_IN_AN_HOUR
        minutes %= MINUTES_IN_AN_HOUR
        hours = (hours + minutesOverflow) % HOURS_IN_A_DAY
    }

}

private fun Int.toTimeString(): String {
    return toString().padStart(length = 2, padChar = '0')
}
