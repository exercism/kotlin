data class PhoneNumber(private val rawNumber: String) {

    companion object {
        private val invalidChars = Regex("[^\\d() -.]")
        private val digitsValidationRegex = Regex("^1?([2-9]\\d{2}[2-9]\\d{6})$")
    }

    val number: String?

    init {
        require(!invalidChars.containsMatchIn(rawNumber))
        number = pure() ?: throw  IllegalArgumentException()
    }

    private fun pure(): String? {
        val digits = rawNumber.replace(Regex("[^\\d]"), "")
        return digitsValidationRegex.matchEntire(digits)?.groupValues?.last()
    }

}
