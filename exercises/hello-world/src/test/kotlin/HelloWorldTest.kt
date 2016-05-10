import kotlin.test.assertEquals
import org.junit.Test

class HelloWorldTest {

    @Test
    fun helloNoName() {
        assertEquals("Hello, World!", hello(""))
        assertEquals("Hello, World!", hello(null))
    }

    @Test
    fun helloSampleName() {
        assertEquals("Hello, Alice!", hello("Alice"))
    }

    @Test
    fun helloAnotherSampleName() {
        assertEquals("Hello, Bob!", hello("Bob"))
    }
}
