import org.junit.Ignore
import org.junit.Test
import org.junit.Assert.assertEquals


class HelloWorldTest {

    @Test
    fun helloNoName() {
        assertEquals("Hello, World!", hello())
    }

    @Test
    @Ignore
    fun helloSampleName() {
        assertEquals("Hello, Alice!", hello("Alice"))
    }

    @Test
    @Ignore
    fun helloBlankName() {
        assertEquals("Hello, World!", hello("    "))
    }

    @Test
    @Ignore
    fun helloAnotherSampleName() {
        assertEquals("Hello, Bob!", hello("Bob"))
    }
}
