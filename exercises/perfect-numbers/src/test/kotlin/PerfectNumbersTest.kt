import org.junit.Ignore
import org.junit.Test

import org.junit.Assert.assertEquals

class NaturalNumberTest {

    @Test
    fun smallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, classify(6))
    }

    @Ignore
    @Test
    fun mediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, classify(28))
    }

    @Ignore
    @Test
    fun largePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, classify(33550336))
    }

    @Ignore
    @Test
    fun smallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, classify(12))
    }

    @Ignore
    @Test
    fun mediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, classify(24))
    }

    @Ignore
    @Test
    fun largeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, classify(33550335))
    }

    @Ignore
    @Test
    fun smallDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, classify(8))
    }

    @Ignore
    @Test
    fun mediumNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, classify(31))
    }

    @Ignore
    @Test
    fun largeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, classify(33550337))
    }

    @Ignore
    @Test(expected = RuntimeException::class)
    fun mustProvideNaturalNumber() {
        assertEquals(Classification.DEFICIENT, classify(-1))
    }

}