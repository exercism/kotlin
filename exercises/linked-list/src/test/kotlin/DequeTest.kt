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
    fun pushPop() {
        subject.push(10)
        subject.push(20)
        assertEquals(20, subject.pop())
        assertEquals(10, subject.pop())
    }

    @Ignore
    @Test
    fun pushShift() {
        subject.push(10)
        subject.push(20)
        assertEquals(10, subject.shift())
        assertEquals(20, subject.shift())
    }

    @Ignore
    @Test
    fun unshiftShift() {
        subject.unshift(10)
        subject.unshift(20)
        assertEquals(20, subject.shift())
        assertEquals(10, subject.shift())
    }

    @Ignore
    @Test
    fun unshiftPop() {
        subject.unshift(10)
        subject.unshift(20)
        assertEquals(10, subject.pop())
        assertEquals(20, subject.pop())
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
}
