import org.junit.Assert;
import org.junit.Test;

class RnaTranscriptionTest {

    @Test
    fun emptyDnaIsEmptyRna() {
        Assert.assertEquals("", transcribeToRna(""));
    }

    @Test
    fun cytosineIsGuanine() {
        Assert.assertEquals("G", transcribeToRna("C"));
    }

    @Test
    fun guanineIsCytosine() {
        Assert.assertEquals("C", transcribeToRna("G"));
    }

    @Test
    fun thymineIsAdenine() {
        Assert.assertEquals("A", transcribeToRna("T"));
    }

    @Test
    fun adenineIsUracil() {
        Assert.assertEquals("U", transcribeToRna("A"));
    }

    @Test
    fun rnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", transcribeToRna("ACGTGGTCTTAA"));
    }
}
