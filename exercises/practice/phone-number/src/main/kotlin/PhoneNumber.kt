
class PhoneNumber(plainPhoneNumber: String) {

    var number: String

    init {
        val nRange = 2..9

        number = plainPhoneNumber.filter { it.isDigit() }
            .takeIf {
                it.length == 11 && it[0] == '1'
                        || it.length == 10
            }
            ?.takeLast(10)
            ?.takeIf {
                it[0].digitToInt() in nRange
                        && it[3].digitToInt() in nRange
            }
            ?: throw IllegalArgumentException()
    }

}