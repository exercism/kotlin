fun twofer(name: String = ""): String {
    var tempName = name
    val regex = Regex("[A-Za-z]")
    val matched = regex.containsMatchIn(tempName)

    if(!matched)
        tempName = "you"

    return "One for $tempName, one for me."
}