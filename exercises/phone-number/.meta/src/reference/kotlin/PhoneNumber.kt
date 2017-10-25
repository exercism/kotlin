data class PhoneNumber(private val rawNumber: String) {

    companion object {
        private val invalidChars = Regex("[^\\d() -.]")
        private val digitsValidationRegex = Regex("^1?([2-9]\\d{2}[2-9]\\d{6})$")
    }

    val number: String?

    init {
        val containsInvalidChar = invalidChars.containsMatchIn(rawNumber)

        if (containsInvalidChar) {
            number = null
        } else {
            val digits = rawNumber.replace(Regex("[^\\d]"), "")
            number = digitsValidationRegex.matchEntire(digits)?.groupValues?.last()
        }
    }

}
