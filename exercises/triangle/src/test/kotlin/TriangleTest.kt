import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TriangleTest {

    @Test
    fun equilateralIfAllSidesAreEqual() {
        assertTrue(Triangle(2, 2, 2).isEquilateral)
    }

    @Ignore
    @Test
    fun notEquilateralIfAnySideIsUnequal() {
        assertFalse(Triangle(2, 3, 2).isEquilateral)
    }

    @Ignore
    @Test
    fun notEquilateralIfNoSidesAreEqual() {
        assertFalse(Triangle(5, 4, 6).isEquilateral)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun allZeroSidesAreIllegalSoNotEquilateral() {
        assertFalse(Triangle(0, 0, 0).isEquilateral)
    }

    @Ignore
    @Test
    fun equilateralSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.5, 0.5).isEquilateral)
    }

    @Ignore
    @Test
    fun isoscelesIfLastTwoSidesAreEqual() {
        assertTrue(Triangle(3, 4, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun isoscelesIfFirstTwoSidesAreEqual() {
        assertTrue(Triangle(4, 4, 3).isIsosceles)
    }

    @Ignore
    @Test
    fun isoscelesIfFirstAndLastSidesAreEqual() {
        assertTrue(Triangle(4, 3, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun equilateralIsAlsoIsosceles() {
        assertTrue(Triangle(4, 4, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun notIsoscelesIfNoSidesAreEqual() {
        assertFalse(Triangle(2, 3, 4).isIsosceles)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotIsosceles() {
        assertFalse(Triangle(1, 1, 3).isIsosceles)
    }

    @Ignore
    @Test
    fun isoscelesSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.4, 0.5).isIsosceles)
    }

    @Ignore
    @Test
    fun scaleneIfNoSidesAreEqual() {
        assertTrue(Triangle(5, 4, 6).isScalene)
    }

    @Ignore
    @Test
    fun notScaleneIfAllSidesAreEqual() {
        assertFalse(Triangle(4, 4, 4).isScalene)
    }

    @Ignore
    @Test
    fun notScaleneIfTwoSidesAreEqual() {
        assertFalse(Triangle(4, 4, 3).isScalene)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotScalene() {
        assertFalse(Triangle(7, 3, 2).isScalene)
    }

    @Ignore
    @Test
    fun scaleneSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.4, 0.6).isScalene)
    }

}
