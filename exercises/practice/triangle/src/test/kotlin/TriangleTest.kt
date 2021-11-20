import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TriangleTest {

    @Test
    fun `equilateral - all sides are equal`() {
        assertTrue(Triangle(2, 2, 2).isEquilateral)
    }

    @Ignore
    @Test
    fun `equilateral - any side is unequal`() {
        assertFalse(Triangle(2, 3, 2).isEquilateral)
    }

    @Ignore
    @Test
    fun `equilateral - no sides are equal`() {
        assertFalse(Triangle(5, 4, 6).isEquilateral)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `equilateral - all zero sides is not a triangle`() {
        assertFalse(Triangle(0, 0, 0).isEquilateral)
    }

    @Ignore
    @Test
    fun `equilateral - sides may be floats`() {
        assertTrue(Triangle(0.5, 0.5, 0.5).isEquilateral)
    }

    @Ignore
    @Test
    fun `isosceles - last two sides are equal`() {
        assertTrue(Triangle(3, 4, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun `isosceles - first two sides are equal`() {
        assertTrue(Triangle(4, 4, 3).isIsosceles)
    }

    @Ignore
    @Test
    fun `isosceles - first and last sides are equal`() {
        assertTrue(Triangle(4, 3, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun `isosceles - equilateral triangles are also isosceles`() {
        assertTrue(Triangle(4, 4, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun `isosceles - no sides are equal`() {
        assertFalse(Triangle(2, 3, 4).isIsosceles)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `triangle inequality violation - last is greater then sum of others `() {
        Triangle(1, 1, 3)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `triangle inequality violation - second is greater then sum of others `() {
        Triangle(1, 3, 1)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `triangle inequality violation - first is greater then sum of others `() {
        Triangle(3, 1, 1)
    }

    @Ignore
    @Test
    fun `isosceles - sides may be floats`() {
        assertTrue(Triangle(0.5, 0.4, 0.5).isIsosceles)
    }

    @Ignore
    @Test
    fun `scalene - no sides are equal`() {
        assertTrue(Triangle(5, 4, 6).isScalene)
    }

    @Ignore
    @Test
    fun `scalene - all sides are equal`() {
        assertFalse(Triangle(4, 4, 4).isScalene)
    }

    @Ignore
    @Test
    fun `scalene - two sides are equal`() {
        assertFalse(Triangle(4, 4, 3).isScalene)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `scalene - may not violate triangle inequality`() {
        Triangle(7, 3, 2)
    }

    @Ignore
    @Test
    fun `scalene - sides may be floats`() {
        assertTrue(Triangle(0.5, 0.4, 0.6).isScalene)
    }

}
