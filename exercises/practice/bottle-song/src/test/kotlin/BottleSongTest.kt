import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class BottleSongTest {

    @Test
    fun `single verse`() {
        val expected = """
            Ten green bottles hanging on the wall,
            Ten green bottles hanging on the wall,
            And if one green bottle should accidentally fall,
            There'll be nine green bottles hanging on the wall.
        """.trimIndent()
        assertEquals(expected, BottleSong.recite(10, 1))
    }

    @Ignore
    @Test
    fun `last generic verse`() {
        val expected = """
            Three green bottles hanging on the wall,
            Three green bottles hanging on the wall,
            And if one green bottle should accidentally fall,
            There'll be two green bottles hanging on the wall.
        """.trimIndent()
        assertEquals(expected, BottleSong.recite(3, 1))
    }

    @Ignore
    @Test
    fun `verse with 2 bottles`() {
        val expected =
            """
            Two green bottles hanging on the wall,
            Two green bottles hanging on the wall,
            And if one green bottle should accidentally fall,
            There'll be one green bottle hanging on the wall.
        """.trimIndent()
        assertEquals(
            expected, BottleSong.recite(2, 1)
        )

    }

    @Ignore
    @Test
    fun `verse with 1 bottle`() {
        val expected =
            """
                One green bottle hanging on the wall,
                One green bottle hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be no green bottles hanging on the wall.
        """.trimIndent()
        assertEquals(
            expected, BottleSong.recite(1, 1)
        )
    }

    @Ignore
    @Test
    fun `multiple verses`() {
        val expected =
            """
                Ten green bottles hanging on the wall,
                Ten green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be nine green bottles hanging on the wall.
                
                Nine green bottles hanging on the wall,
                Nine green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be eight green bottles hanging on the wall.
        """.trimIndent()
        assertEquals(
            expected, BottleSong.recite(10, 2)
        )
    }

    @Ignore
    @Test
    fun `last three verses`() {
        val expected =
            """
                Three green bottles hanging on the wall,
                Three green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be two green bottles hanging on the wall.
                
                Two green bottles hanging on the wall,
                Two green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be one green bottle hanging on the wall.
                
                One green bottle hanging on the wall,
                One green bottle hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be no green bottles hanging on the wall.
        """.trimIndent()
        assertEquals(
            expected, BottleSong.recite(3, 3)
        )
    }

    @Ignore
    @Test
    fun `all verses`() {
        val expected =
            """
                Ten green bottles hanging on the wall,
                Ten green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be nine green bottles hanging on the wall.
                
                Nine green bottles hanging on the wall,
                Nine green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be eight green bottles hanging on the wall.
                
                Eight green bottles hanging on the wall,
                Eight green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be seven green bottles hanging on the wall.
                
                Seven green bottles hanging on the wall,
                Seven green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be six green bottles hanging on the wall.
                
                Six green bottles hanging on the wall,
                Six green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be five green bottles hanging on the wall.
                
                Five green bottles hanging on the wall,
                Five green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be four green bottles hanging on the wall.
                
                Four green bottles hanging on the wall,
                Four green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be three green bottles hanging on the wall.
                
                Three green bottles hanging on the wall,
                Three green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be two green bottles hanging on the wall.
                
                Two green bottles hanging on the wall,
                Two green bottles hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be one green bottle hanging on the wall.
                
                One green bottle hanging on the wall,
                One green bottle hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be no green bottles hanging on the wall.
        """.trimIndent()
        assertEquals(
            expected, BottleSong.recite(10, 10)
        )
    }
}
