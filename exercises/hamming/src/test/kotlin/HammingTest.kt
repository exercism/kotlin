import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class HammingTest {
    

    @Test
    fun noDifferenceBetweenIdenticalStrands() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Ignore
    @Test
    fun completeHammingDistanceOfForSingleNucleotideStrand() {
        assertEquals(1, Hamming.compute("A", "G"))
    }

    @Ignore
    @Test
    fun completeHammingDistanceForSmallStrand() {
        assertEquals(2, Hamming.compute("AG", "CT"))
    }

    @Ignore
    @Test
    fun smallHammingDistance() {
        assertEquals(1, Hamming.compute("AT", "CT"))
    }

    @Ignore
    @Test
    fun smallHammingDistanceInLongerStrand() {
        assertEquals(1, Hamming.compute("GGACG", "GGTCG"))
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun validatesFirstStrandNotLonger() {
        Hamming.compute("AAAG", "AAA")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun validatesOtherStrandNotLonger() {
        Hamming.compute("AAA", "AAAG")
    }

    @Ignore
    @Test
    fun largeHammingDistance() {
        assertEquals(4, Hamming.compute("GATACA", "GCATAA"))
    }

    @Ignore
    @Test
    fun hammingDistanceInVeryLongStrand() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

}
