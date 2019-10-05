import org.junit.Test
import org.junit.Ignore
import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class HammingTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun noDistanceBetweenEmptyStrands() {
        assertEquals(0, Hamming.compute("", ""))
    }

    @Ignore
    @Test
    fun noDistanceBetweenSingleLetterIdenticalStrands() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Ignore
    @Test
    fun completeDistanceInSingleLetterDifferentStrands() {
        assertEquals(1, Hamming.compute("G", "T"))
    }

    @Ignore
    @Test
    fun noDistanceBetweenLongIdenticalStrands() {
        assertEquals(0, Hamming.compute("GGACTGAAATCTG", "GGACTGAAATCTG"))
    }

    @Ignore
    @Test
    fun largeDistanceBetweenLongDifferentStrands() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

    @Ignore
    @Test
    fun disallowFirstStrandLonger() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("left and right strands must be of equal length")

        Hamming.compute("AATG", "AAA")
    }

    @Ignore
    @Test
    fun disallowSecondStrandLonger() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("left and right strands must be of equal length")

        Hamming.compute("ATA", "AGTG")
    }
}
