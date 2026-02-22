object Messenger {
    val messages = mutableListOf<String>()

    fun sendMessage(message: String) {
        messages.add(message)
    }

    fun latestMessage(): String {
        return messages.last()
    }

    fun allMessages(): List<String> {
        return messages
    }

    fun messageCount(): Int {
        return messages.size
    }
}