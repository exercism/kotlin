import org.junit.Before
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class DequeTest {
    private lateinit var subject: Deque<Int>

    @Before
    fun setUp() {
        subject = Deque()
    }

    @Test
    fun emptyPop() {
        assertEquals(null, subject.pop())
    }

    @Ignore
    @Test
    fun emptyShift() {
        assertEquals(null, subject.shift())
    }

    @Ignore
    @Test
    fun pushPop() {
        subject.push(10)
        subject.push(20)
        assertEquals(20, subject.pop())
        assertEquals(10, subject.pop())
        assertEquals(null, subject.pop())
    }

    @Ignore
    @Test
    fun pushPopEmptyShift() {
        subject.push(10)
        subject.push(20)
        assertEquals(20, subject.pop())
        assertEquals(10, subject.pop())
        assertEquals(null, subject.shift())
    }

    @Ignore
    @Test
    fun pushShift() {
        subject.push(10)
        subject.push(20)
        assertEquals(10, subject.shift())
        assertEquals(20, subject.shift())
        assertEquals(null, subject.shift())
    }

    @Ignore
    @Test
    fun pushShiftEmptyPop() {
        subject.push(10)
        subject.push(20)
        assertEquals(10, subject.shift())
        assertEquals(20, subject.shift())
        assertEquals(null, subject.pop())
    }

    @Ignore
    @Test
    fun unshiftShift() {
        subject.unshift(10)
        subject.unshift(20)
        assertEquals(20, subject.shift())
        assertEquals(10, subject.shift())
        assertEquals(null, subject.shift())
    }

    @Ignore
    @Test
    fun unshiftShiftEmptyPop() {
        subject.unshift(10)
        subject.unshift(20)
        assertEquals(20, subject.shift())
        assertEquals(10, subject.shift())
        assertEquals(null, subject.pop())
    }

    @Ignore
    @Test
    fun unshiftPop() {
        subject.unshift(10)
        subject.unshift(20)
        assertEquals(10, subject.pop())
        assertEquals(20, subject.pop())
        assertEquals(null, subject.pop())
    }

    @Ignore
    @Test
    fun unshiftPopEmptyShift() {
        subject.unshift(10)
        subject.unshift(20)
        assertEquals(10, subject.pop())
        assertEquals(20, subject.pop())
        assertEquals(null, subject.shift())
    }

    @Ignore
    @Test
    fun example() {
        subject.push(10)
        subject.push(20)
        assertEquals(20, subject.pop())

        subject.push(30)
        assertEquals(10, subject.shift())

        subject.unshift(40)
        subject.push(50)
        assertEquals(40, subject.shift())
        assertEquals(50, subject.pop())
        assertEquals(30, subject.shift())
    }

    @Ignore
    @Test
    fun shiftAndPop() {
        subject.push(10)
        subject.push(20)
        subject.push(30)

        assertEquals(10, subject.shift())
        assertEquals(30, subject.pop())
        assertEquals(20, subject.pop())
        assertEquals(null, subject.pop())
    }

    @Ignore
    @Test
    fun popAndShift() {
        subject.push(10)
        subject.push(20)
        subject.push(30)

        assertEquals(30, subject.pop())
        assertEquals(10, subject.shift())
        assertEquals(20, subject.shift())
        assertEquals(null, subject.shift())
    }
}
