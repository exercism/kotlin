import org.junit.Test
import kotlin.test.assertEquals

class HammingTest {
    
    @Test
    fun noDifferenceBetweenIdenticalStrands() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Test
    fun completeHammingDistanceOfForSingleNucleotideStrand() {
        assertEquals(1, Hamming.compute("A", "G"))
    }

    @Test
    fun completeHammingDistanceForSmallStrand() {
        assertEquals(2, Hamming.compute("AG", "CT"))
    }

    @Test
    fun smallHammingDistance() {
        assertEquals(1, Hamming.compute("AT", "CT"))
    }

    @Test
    fun smallHammingDistanceInLongerStrand() {
        assertEquals(1, Hamming.compute("GGACG", "GGTCG"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun validatesFirstStrandNotLonger() {
        Hamming.compute("AAAG", "AAA")
    }

    @Test(expected = IllegalArgumentException::class)
    fun validatesOtherStrandNotLonger() {
        Hamming.compute("AAA", "AAAG")
    }

    @Test
    fun largeHammingDistance() {
        assertEquals(4, Hamming.compute("GATACA", "GCATAA"))
    }

    @Test
    fun hammingDistanceInVeryLongStrand() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

}
