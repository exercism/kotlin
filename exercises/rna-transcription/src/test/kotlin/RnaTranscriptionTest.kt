import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class RnaTranscriptionTest {

    /*
      In Kotlin functions can be declared at top level in a file, meaning
      you do not need to create a class to hold a function, like languages
      such as Java, C# or Scala.

      http://kotlinlang.org/docs/reference/functions.html#function-scope

     */

    @Test
    fun cytosineComplementIsGuanine() {
        assertEquals("G", transcribeToRna("C"))
    }

    @Ignore
    @Test
    fun guanineComplementIsCytosine() {
        assertEquals("C", transcribeToRna("G"))
    }

    @Ignore
    @Test
    fun thymineComplementIsAdenine() {
        assertEquals("A", transcribeToRna("T"))
    }

    @Ignore
    @Test
    fun adenineComplementIsUracil() {
        assertEquals("U", transcribeToRna("A"))
    }

    @Ignore
    @Test
    fun rnaTranscription() {
        assertEquals("UGCACCAGAAUU", transcribeToRna("ACGTGGTCTTAA"))
    }

}
