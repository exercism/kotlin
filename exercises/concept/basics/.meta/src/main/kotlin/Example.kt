fun remainingMinutesInOven(actualMinutesInOven: Int = 0): Int {
    val cookingTime = 40

    return cookingTime - actualMinutesInOven
}

fun preparationTimeInMinutes(numberOfIngredientTypes: Int): Int {
    return 5 + numberOfIngredientTypes * 2
}

fun elapsedCookingTimeInMinutes(numberOfIngredientTypes: Int, servingTimeInMinutes: Int = 0): Int {
    val preparationTime = preparationTimeInMinutes(numberOfIngredientTypes)
    val backingTime = remainingMinutesInOven()

    return preparationTime + backingTime + servingTimeInMinutes
}
