fun shiftBack(value: Int, amount: Int): Int {
    return value ushr amount
}

fun setBits(value: Int, mask: Int): Int {
    return value or mask
}

fun flipBits(value: Int, mask: Int): Int {
    return value xor mask
}

fun clearBits(value: Int, mask: Int): Int {
    return value and mask.inv()
}
