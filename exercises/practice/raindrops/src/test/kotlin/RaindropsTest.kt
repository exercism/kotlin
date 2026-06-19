import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test

class RaindropsTest() {

    @Test
    fun `the sound for 1 is 1`() {
        assertEquals("1", Raindrops.convert(1))
    }

    @Ignore
    @Test
    fun `the sound for 3 is Pling`() {
        assertEquals("Pling", Raindrops.convert(3))
    }

    @Ignore
    @Test
    fun `the sound for 5 is Plang`() {
        assertEquals("Plang", Raindrops.convert(5))
    }

    @Ignore
    @Test
    fun `the sound for 7 is Plong`() {
        assertEquals("Plong", Raindrops.convert(7))
    }

    @Ignore
    @Test
    fun `the sound for 6 is Pling as it has a factor 3`() {
        assertEquals("Pling", Raindrops.convert(6))
    }

    @Ignore
    @Test
    fun `2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base`() {
        assertEquals("8", Raindrops.convert(8))
    }

    @Ignore
    @Test
    fun `the sound for 9 is Pling as it has a factor 3`() {
        assertEquals("Pling", Raindrops.convert(9))
    }

    @Ignore
    @Test
    fun `the sound for 10 is Plang as it has a factor 5`() {
        assertEquals("Plang", Raindrops.convert(10))
    }

    @Ignore
    @Test
    fun `the sound for 14 is Plong as it has a factor of 7`() {
        assertEquals("Plong", Raindrops.convert(14))
    }

    @Ignore
    @Test
    fun `the sound for 15 is PlingPlang as it has factors 3 and 5`() {
        assertEquals("PlingPlang", Raindrops.convert(15))
    }

    @Ignore
    @Test
    fun `the sound for 21 is PlingPlong as it has factors 3 and 7`() {
        assertEquals("PlingPlong", Raindrops.convert(21))
    }

    @Ignore
    @Test
    fun `the sound for 25 is Plang as it has a factor 5`() {
        assertEquals("Plang", Raindrops.convert(25))
    }

    @Ignore
    @Test
    fun `the sound for 27 is Pling as it has a factor 3`() {
        assertEquals("Pling", Raindrops.convert(27))
    }

    @Ignore
    @Test
    fun `the sound for 35 is PlangPlong as it has factors 5 and 7`() {
        assertEquals("PlangPlong", Raindrops.convert(35))
    }

    @Ignore
    @Test
    fun `the sound for 49 is Plong as it has a factor 7`() {
        assertEquals("Plong", Raindrops.convert(49))
    }

    @Ignore
    @Test
    fun `the sound for 52 is 52`() {
        assertEquals("52", Raindrops.convert(52))
    }

    @Ignore
    @Test
    fun `the sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7`() {
        assertEquals("PlingPlangPlong", Raindrops.convert(105))
    }

    @Ignore
    @Test
    fun `the sound for 3125 is Plang as it has a factor 5`() {
        assertEquals("Plang", Raindrops.convert(3125))
    }
}
