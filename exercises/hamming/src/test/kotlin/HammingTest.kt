import org.junit.Test
import kotlin.test.assertEquals

class HammingTest {
    
    @Test
    fun testNoDifferenceBetweenIdenticalStrands() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Test
    fun testCompleteHammingDistanceOfForSingleNucleotideStrand() {
        assertEquals(1, Hamming.compute("A", "G"))
    }

    @Test
    fun testCompleteHammingDistanceForSmallStrand() {
        assertEquals(2, Hamming.compute("AG", "CT"))
    }

    @Test
    fun testSmallHammingDistance() {
        assertEquals(1, Hamming.compute("AT", "CT"))
    }

    @Test
    fun testSmallHammingDistanceInLongerStrand() {
        assertEquals(1, Hamming.compute("GGACG", "GGTCG"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testValidatesFirstStrandNotLonger() {
        Hamming.compute("AAAG", "AAA");
    }

    @Test(expected = IllegalArgumentException::class)
    fun testValidatesOtherStrandNotLonger() {
        Hamming.compute("AAA", "AAAG");
    }

    @Test
    fun testLargeHammingDistance() {
        assertEquals(4, Hamming.compute("GATACA", "GCATAA"))
    }

    @Test
    fun testHammingDistanceInVeryLongStrand() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

}
