import org.junit.Ignore
import org.junit.Test

import org.junit.Assert.assertEquals

class NaturalNumberTest {

    @Test
    fun smallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, getClassification(6))
    }

    @Ignore
    @Test
    fun mediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, getClassification(28))
    }

    @Ignore
    @Test
    fun largePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, getClassification(33550336))
    }

    @Ignore
    @Test
    fun smallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, getClassification(12))
    }

    @Ignore
    @Test
    fun mediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, getClassification(24))
    }

    @Ignore
    @Test
    fun largeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, getClassification(33550335))
    }

    @Ignore
    @Test
    fun smallDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, getClassification(8))
    }

    @Ignore
    @Test
    fun mediumNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, getClassification(31))
    }

    @Ignore
    @Test
    fun largeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, getClassification(33550337))
    }

}