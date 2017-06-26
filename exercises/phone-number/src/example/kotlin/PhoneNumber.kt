data class PhoneNumber(private val rawNumber: String) {
    companion object {
        private val validationRegex = Regex("^1?([2-9]\\d{2}[2-9]\\d{6})$")
    }
    private val cleanedNumber = rawNumber.replace(Regex("[^\\d]"), "")

    val number = validationRegex.matchEntire(cleanedNumber)?.groupValues?.last() ?: throw IllegalArgumentException()
    val areaCode = number.substring(0, 3)
    val exchangeCode = number.substring(3, 6)
    val subscriberNumber = number.substring(6, 10)

    override fun toString() = "($areaCode) $exchangeCode-$subscriberNumber"
}
