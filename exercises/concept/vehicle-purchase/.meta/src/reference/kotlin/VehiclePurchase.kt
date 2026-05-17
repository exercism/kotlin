fun needsLicense(kind: String): Boolean {
    return kind == "car" || kind == "truck"
}

fun chooseVehicle(option1: String, option2: String): String {
    val choice = if (option1 < option2) option1 else option2
    return "$choice is clearly the better choice."
}

fun calculateResellPrice(originalPrice: Double, age: Double): Double {
    val percentage =
        if (age < 3) {
            0.8
        } else if (age < 10) {
            0.7
        } else {
            0.5
        }
    return percentage * originalPrice
}