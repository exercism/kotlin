import org.junit.Assert;
import org.junit.Test;

class RnaTranscriptionTest {

    /*
      In Kotlin functions can be declared at top level in a file, meaning
      you do not need to create a class to hold a function, like languages
      such as Java, C# or Scala.

      http://kotlinlang.org/docs/reference/functions.html#function-scope

     */

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
