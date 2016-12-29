import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TriangleTest {

    @Test
    fun equilateralIfAllSidesAreEqual() {
        assertTrue(Triangle(2, 2, 2).isEquilateral)
    }

    @Test
    fun notEquilateralIfAnySideIsUnequal() {
        assertFalse(Triangle(2, 3, 2).isEquilateral)
    }

    @Test
    fun notEquilateralIfNoSidesAreEqual() {
        assertFalse(Triangle(5, 4, 6).isEquilateral)
    }

    @Test(expected = IllegalArgumentException::class)
    fun allZeroSidesAreIllegalSoNotEquilateral() {
        assertFalse(Triangle(0, 0, 0).isEquilateral)
    }

    @Test
    fun equilateralSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.5, 0.5).isEquilateral)
    }

    @Test
    fun isoscelesIfLastTwoSidesAreEqual() {
        assertTrue(Triangle(3, 4, 4).isIsosceles)
    }

    @Test
    fun isoscelesIfFirstTwoSidesAreEqual() {
        assertTrue(Triangle(4, 4, 3).isIsosceles)
    }

    @Test
    fun isoscelesIfFirstAndLastSidesAreEqual() {
        assertTrue(Triangle(4, 3, 4).isIsosceles)
    }

    @Test
    fun equilateralIsAlsoIsosceles() {
        assertTrue(Triangle(4, 4, 4).isIsosceles)
    }

    @Test
    fun notIsoscelesIfNoSidesAreEqual() {
        assertFalse(Triangle(2, 3, 4).isIsosceles)
    }

    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotIsosceles() {
        assertFalse(Triangle(1, 1, 3).isIsosceles)
    }

    @Test
    fun isoscelesSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.4, 0.5).isIsosceles)
    }

    @Test
    fun scaleneIfNoSidesAreEqual() {
        assertTrue(Triangle(5, 4, 6).isScalene)
    }

    @Test
    fun notScaleneIfAllSidesAreEqual() {
        assertFalse(Triangle(4, 4, 4).isScalene)
    }

    @Test
    fun notScaleneIfTwoSidesAreEqual() {
        assertFalse(Triangle(4, 4, 3).isScalene)
    }

    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotScalene() {
        assertFalse(Triangle(7, 3, 2).isScalene)
    }

    @Test
    fun scaleneSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.4, 0.6).isScalene)
    }

}
