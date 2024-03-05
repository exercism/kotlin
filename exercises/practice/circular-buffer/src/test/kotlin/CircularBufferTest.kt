import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CircularBufferTest {
    @Test
    fun `reading empty buffer should fail`() {
        val buffer = CircularBuffer<Any>(1)
        assertFailsWith<EmptyBufferException>() {
            buffer.read()
        }
    }

    @Ignore
    @Test
    fun `can read an item just written`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.write(1)
        assertEquals(1, buffer.read())
    }

    @Ignore
    @Test
    fun `each item may only be read once`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.write(1)

        assertEquals(1, buffer.read())
        assertFailsWith<EmptyBufferException> {
            buffer.read()
        }
    }

    @Ignore
    @Test
    fun `items are read in the order they are written`() {
        val buffer = CircularBuffer<Int>(2)
        buffer.write(1)
        buffer.write(2)

        assertEquals(1, buffer.read())
        assertEquals(2, buffer.read())
    }

    @Ignore
    @Test
    fun `full buffer can't be written to`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.write(1)
        assertFailsWith<BufferFullException> {
            buffer.write(2)
        }
    }

    @Ignore
    @Test
    fun `a read frees up capacity for another write`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.write(1)
        assertEquals(1, buffer.read())

        buffer.write(2)
        assertEquals(2, buffer.read())
    }

    @Ignore
    @Test
    fun `read position is maintained even across multiple writes`() {
        val buffer = CircularBuffer<Int>(3)
        buffer.write(1)
        buffer.write(2)
        assertEquals(1, buffer.read())

        buffer.write(3)
        assertEquals(2, buffer.read())
        assertEquals(3, buffer.read())
    }

    @Ignore
    @Test
    fun `items cleared out of buffer can't be read`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.write(1)
        buffer.clear()

        assertFailsWith<EmptyBufferException> {
            buffer.read()
        }
    }

    @Ignore
    @Test
    fun `clear frees up capacity for another write`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.write(1)
        buffer.clear()
        buffer.write(2)

        assertEquals(2, buffer.read())
    }

    @Ignore
    @Test
    fun `clear does nothing on empty buffer`() {
        val buffer = CircularBuffer<Int>(1)
        buffer.clear()
        buffer.write(1)

        assertEquals(1, buffer.read())
    }

    @Ignore
    @Test
    fun `overwrite acts like write on non-full buffer`() {
        val buffer = CircularBuffer<Int>(2)
        buffer.write(1)
        buffer.overwrite(2)

        assertEquals(1, buffer.read())
        assertEquals(2, buffer.read())
    }

    @Ignore
    @Test
    fun `overwrite replaces the oldest item on full buffer`() {
        val buffer = CircularBuffer<Int>(2)
        buffer.write(1)
        buffer.write(2)
        buffer.overwrite(3)

        assertEquals(2, buffer.read())
        assertEquals(3, buffer.read())
    }

    @Ignore
    @Test
    fun `overwrite replaces the oldest item remaining in buffer following a read`() {
        val buffer = CircularBuffer<Int>(3)
        buffer.write(1)
        buffer.write(2)
        buffer.write(3)

        assertEquals(1, buffer.read())
        buffer.write(4)
        buffer.overwrite(5)

        assertEquals(3, buffer.read())
        assertEquals(4, buffer.read())
        assertEquals(5, buffer.read())
    }

    @Ignore
    @Test
    fun `initial clear does not affect wrapping around`() {
        val buffer = CircularBuffer<Int>(2)
        buffer.clear()
        buffer.write(1)
        buffer.write(2)
        buffer.overwrite(3)
        buffer.overwrite(4)

        assertEquals(3, buffer.read())
        assertEquals(4, buffer.read())
        assertFailsWith<EmptyBufferException> {
            buffer.read()
        }
    }
}
