import org.junit.Assert;
import org.junit.Test;

class RnaTranscriptionTest {

    @Test
    fun emptyDnaIsEmptyRna() {
        Assert.assertEquals("", RnaTranscription.ofDna(""));
    }

    @Test
    fun cytosineIsGuanine() {
        Assert.assertEquals("G", RnaTranscription.ofDna("C"));
    }

    @Test
    fun guanineIsCytosine() {
        Assert.assertEquals("C", RnaTranscription.ofDna("G"));
    }

    @Test
    fun thymineIsAdenine() {
        Assert.assertEquals("A", RnaTranscription.ofDna("T"));
    }

    @Test
    fun adenineIsUracil() {
        Assert.assertEquals("U", RnaTranscription.ofDna("A"));
    }

    @Test
    fun rnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGGTCTTAA"));
    }
}
