import kotlin.test.assertEquals
import org.junit.Test

class HelloWorldTest {

    @Test
    fun helloNoName() {
        assertEquals("Hello, World!", HelloWorld.hello())
    }

    @Test
    fun helloBlankName() {
        assertEquals("Hello, World!", HelloWorld.hello(""))
        assertEquals("Hello, World!", HelloWorld.hello("    "))
    }

    @Test
    fun helloNullName() {
        //This isn't advised in Kotlin but demonstrates the null safety in Kotlin
        assertEquals("Hello, World!", HelloWorld.hello(null))
    }

    @Test
    fun helloSampleName() {
        assertEquals("Hello, Alice!", HelloWorld.hello("Alice"))
    }

    @Test
    fun helloAnotherSampleName() {
        assertEquals("Hello, Bob!", HelloWorld.hello("Bob"))
    }
}
