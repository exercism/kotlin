class BankAccount {
    var balance: Long = 0
        get() {
             synchronized(this) {
                 if (!isOpen) throw IllegalStateException("Account is closed")
                 return field
             }
        }

        private set

    var isOpen = true
        private set

    fun adjustBalance(amount: Long) {
        synchronized(this) {
            balance += amount
        }
    }

    fun close() {
        synchronized(this) {
            isOpen = false
        }
    }

}
