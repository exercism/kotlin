fun makeIdGenerator(day : Int) : (Int, Int) -> Int {
    return {num1 : Int, num2 : Int -> num1 * num2 + day}
}

fun protectSecret(secret : String, password : String) : (String) -> String {
    return {
        if (it == password) {
            secret
        } else {
            "Sorry. No hidden secrets here."
        }
    }
}

fun getPassword(room : Int, minionFunction : ((Int, Int) -> Int) -> String) : String {
    return minionFunction {num1 : Int, num2 : Int -> (num1 + num2) * room}
}
