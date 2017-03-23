class BankAccount {
    var balance: Long = 0
        get() {
            synchronized(lock) {
                if (!isOpen) throw IllegalStateException("Account is closed")
                return field
            }
        }
        private set

    var isOpen = true
        private set

    fun adjustBalance(amount: Long) {
        synchronized(lock) {
            balance += amount
        }
    }

    fun close() {
        synchronized(lock) {
            isOpen = false
        }
    }

    private val lock = Any()
}
