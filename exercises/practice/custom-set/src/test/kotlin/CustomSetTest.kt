import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class CustomSetTest {

    @Test
    fun `sets with no elements are empty`() {
        val sut = CustomSet()
        assertTrue(sut.isEmpty())
    }

    @Test
    fun `sets with elements are not empty`() {
        val sut = CustomSet(1)
        assertFalse(sut.isEmpty())
    }

    @Test
    fun `nothing is contained in an empty set`() {
        val sut = CustomSet()
        assertFalse(sut.contains(1))
    }

    @Test
    fun `when the element is in the set`() {
        val sut = CustomSet(1, 2, 3)
        assertTrue(sut.contains(1))
    }

    @Test
    fun `when the element is not in the set`() {
        val sut = CustomSet(1, 2, 3)
        assertFalse(sut.contains(4))
    }

    @Test
    fun `empty set is a subset of another empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet()
        assertTrue(set1.isSubset(set2))
    }

    @Test
    fun `empty set is a subset of non empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet(1)
        assertTrue(set1.isSubset(set2))
    }

    @Test
    fun `non empty set is not a subset of empty set`() {
        val set1 = CustomSet(1)
        val set2 = CustomSet()
        assertFalse(set1.isSubset(set2))
    }

    @Test
    fun `set is a subset of set with exact same elements`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet(1, 2, 3)
        assertTrue(set1.isSubset(set2))
    }

    @Test
    fun `set is a subset of larger set with same elements`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet(4, 1, 2, 3)
        assertTrue(set1.isSubset(set2))
    }

    @Test
    fun `set is not a subset of set that does not contain its elements`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet(4, 1, 3)
        assertFalse(set1.isSubset(set2))
    }

    @Test
    fun `the empty set is disjoint with itself`() {
        val set1 = CustomSet()
        val set2 = CustomSet()
        assertTrue(set1.isDisjoint(set2))
    }

    @Test
    fun `empty set is disjoint with non empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet(1)
        assertTrue(set1.isDisjoint(set2))
    }

    @Test
    fun `non empty set is disjoint with empty set`() {
        val set1 = CustomSet(1)
        val set2 = CustomSet()
        assertTrue(set1.isDisjoint(set2))
    }

    @Test
    fun `sets are not disjoint if they share an element`() {
        val set1 = CustomSet(1, 2)
        val set2 = CustomSet(2, 3)
        assertFalse(set1.isDisjoint(set2))
    }

    @Test
    fun `sets are disjoint if they share no elements`() {
        val set1 = CustomSet(1, 2)
        val set2 = CustomSet(3, 4)
        assertTrue(set1.isDisjoint(set2))
    }

    @Test
    fun `empty sets are equal`() {
        val set1 = CustomSet()
        val set2 = CustomSet()
        assertEquals(set1, set2)
    }

    @Test
    fun `empty set is not equal to non empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet(1, 2, 3)
        assertNotEquals(set1, set2)
    }

    @Test
    fun `non empty set is not equal to empty set`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet()
        assertNotEquals(set1, set2)
    }

    @Test
    fun `sets with the same elements are equal`() {
        val set1 = CustomSet(1, 2)
        val set2 = CustomSet(2, 1)
        assertEquals(set1, set2)

    }

    @Test
    fun `sets with different elements are not equal`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet(1, 2, 4)
        assertNotEquals(set1, set2)
    }

    @Test
    fun `set is not equal to larger set with same elements`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet(1, 2, 3, 4)
        assertNotEquals(set1, set2)
    }

    @Test
    fun `add to empty set`() {
        val sut = CustomSet()
        val expected = CustomSet(3)
        sut.add(3)
        assertEquals(expected, sut)
    }

    @Test
    fun `add to non empty set`() {
        val sut = CustomSet(1, 2, 4)
        val expected = CustomSet(1, 2, 3, 4)
        sut.add(3)
        assertEquals(expected, sut)
    }

    @Test
    fun `adding an existing element does not change the set`() {
        val sut = CustomSet(1, 2, 3)
        val expected = CustomSet(1, 2, 3)
        sut.add(3)
        assertEquals(expected, sut)
    }

    @Test
    fun `intersection of two empty sets is an empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet()
        val expected = CustomSet()
        assertEquals(expected, set1.intersection(set2))
    }

    @Test
    fun `intersection of an empty set and non empty set is an empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet(3, 2, 5)
        val expected = CustomSet()
        assertEquals(expected, set1.intersection(set2))
    }

    @Test
    fun `intersection of a non empty set and an empty set is an empty set`() {
        val set1 = CustomSet(1, 2, 3, 4)
        val set2 = CustomSet()
        val expected = CustomSet()
        assertEquals(expected, set1.intersection(set2))
    }

    @Test
    fun `intersection of two sets with no shared elements is an empty set`() {
        val set1 = CustomSet(1, 2, 3)
        val set2 = CustomSet(4, 5, 6)
        val expected = CustomSet()
        assertEquals(expected, set1.intersection(set2))
    }

    @Test
    fun `intersection of two sets with shared elements is a set of the shared elements`() {
        val set1 = CustomSet(1, 2, 3, 4)
        val set2 = CustomSet(3, 2, 5)
        val expected = CustomSet(2, 3)
        assertEquals(expected, set1.intersection(set2))
    }

    @Test
    fun `difference of two empty sets is an empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet()
        val expected = CustomSet()
        assertEquals(expected, set1 - set2)
    }

    @Test
    fun `difference of empty set and non empty set is an empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet(3, 2, 5)
        val expected = CustomSet()
        assertEquals(expected, set1 - set2)
    }

    @Test
    fun `difference of a non empty set and an empty set is the non empty set`() {
        val set1 = CustomSet(1, 2, 3, 4)
        val set2 = CustomSet()
        val expected = CustomSet(1, 2, 3, 4)
        assertEquals(expected, set1 - set2)
    }

    @Test
    fun `difference of two non empty sets is a set of elements that are only in the first set`() {
        val set1 = CustomSet(3, 2, 1)
        val set2 = CustomSet(2, 4)
        val expected = CustomSet(1, 3)
        assertEquals(expected, set1 - set2)
    }

    @Test
    fun `union of empty sets is an empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet()
        val expected = CustomSet()
        assertEquals(expected, set1 + set2)
    }

    @Test
    fun `union of an empty set and non empty set is the non empty set`() {
        val set1 = CustomSet()
        val set2 = CustomSet(2)
        val expected = CustomSet(2)
        assertEquals(expected, set1 + set2)
    }

    @Test
    fun `union of a non empty set and empty set is the non empty set`() {
        val set1 = CustomSet(1, 3)
        val set2 = CustomSet()
        val expected = CustomSet(1, 3)
        assertEquals(expected, set1 + set2)
    }

    @Test
    fun `union of non empty sets contains all unique elements`() {
        val set1 = CustomSet(1, 3)
        val set2 = CustomSet(2, 3)
        val expected = CustomSet(3, 2, 1)
        assertEquals(expected, set1 + set2)
    }
}
