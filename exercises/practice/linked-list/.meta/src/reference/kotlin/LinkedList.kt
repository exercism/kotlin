class Deque<T> {
    private var head: Element<T>? = null

    fun push(value: T) {
        if(head == null) {
            head = Element(value)
            head?.prev = head
            head?.next = head
        } else {
            val oldTail = head?.prev
            val tail = Element(value, prev = oldTail, next = head)
            oldTail?.next = tail
            head?.prev = tail
        }

    }

    fun pop(): T? {
        head = head?.prev
        return shift()
    }

    fun unshift(value: T) {
        push(value)
        head = head?.prev
    }

    fun shift(): T? {
        val value = head?.value
        val newHead = head?.next
        val newTail = head?.prev

        if (newHead == head) {
            head = null
        } else {
            newHead?.prev = newTail
            newTail?.next = newHead
            head = newHead
        }

        return value
    }

    private data class Element<T>(val value: T, var prev: Element<T>? = null, var next: Element<T>? = null)
}
