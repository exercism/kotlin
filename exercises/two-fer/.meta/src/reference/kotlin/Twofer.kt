fun twofer(name: String = "you"): String {
    return "One for ${if (name.isBlank()) "you" else name}, one for me."
}