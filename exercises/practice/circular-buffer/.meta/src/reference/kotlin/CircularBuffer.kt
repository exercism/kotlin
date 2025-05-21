import kotlin.collections.ArrayDeque

class EmptyBufferException : Exception("Buffer is empty") {}

class BufferFullException : Exception("Buffer is full") {}

class CircularBuffer<T>(private val capacity: Int) {

    private val contents = ArrayDeque<T>(capacity)

    fun read() : T {
        if (contents.isNotEmpty()) {
            return contents.removeFirst()
        }
        throw EmptyBufferException()
    }

    fun write(value: T) {
        if (contents.size < capacity) {
            contents.add(value)
        } else {
            throw BufferFullException()
        }
    }

    fun overwrite(value: T) {
        if (contents.size >= capacity) {
            contents.removeFirst()
        }
        contents.add(value)
    }

    fun clear() {
        contents.clear()
    }
}