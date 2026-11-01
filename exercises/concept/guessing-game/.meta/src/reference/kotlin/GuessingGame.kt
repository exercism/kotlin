fun reply(guess : Int, guessCount : Int) : String {
    return when(guess) {
        42 -> "Correct"
        41 if guessCount > 5 -> "Try one higher"
        43 if guessCount > 5 -> "Try one lower"
        41, 43 -> "So close"
        else if guess < 41 -> "Too low"
        else -> "Too high"
    }
}