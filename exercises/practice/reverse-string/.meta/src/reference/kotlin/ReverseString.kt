fun reverse(input: String): String {
    val result = StringBuilder()
    for(i in input.indices) {
        result.append(input[input.length - 1 - i])
    }
    return result.toString()
}