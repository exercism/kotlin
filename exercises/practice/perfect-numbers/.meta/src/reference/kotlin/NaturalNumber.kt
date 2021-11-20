
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) { "$naturalNumber is not a natural number" }

    val aliquotSum = naturalNumber.aliquotSum()
    return when {
        aliquotSum == naturalNumber -> Classification.PERFECT
        aliquotSum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}

fun Int.aliquotSum(): Int = (1 until this).filter { this % it == 0 }.sum()
