fun reverse(input: String): String {
    var result = StringBuilder()
    for(i in 0 until input.length) {
        result.append(input[input.length - 1 - i])
    }
    return result.toString()
}