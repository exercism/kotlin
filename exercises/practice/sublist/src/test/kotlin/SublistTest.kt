import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class SublistTest {

    @Test
    fun testThatTwoEmptyListsAreConsideredEqual() {
        assertEquals(
                Relationship.EQUAL,
                emptyList<String>().relationshipTo(emptyList<String>()))
    }

    @Ignore
    @Test
    fun testEmptyListIsSublistOfNonEmptyList() {
        assertEquals(
                Relationship.SUBLIST,
                emptyList<Int>().relationshipTo(listOf(1, 2, 3)))
    }

    @Ignore
    @Test
    fun testNonEmptyListIsSuperlistOfEmptyList() {
        assertEquals(
                Relationship.SUPERLIST,
                listOf('1', '2', '3').relationshipTo(emptyList()))
    }

    @Ignore
    @Test
    fun testListIsEqualToItself() {
        val anyList = listOf("1", "2", "3")

        assertEquals(
                Relationship.EQUAL,
                anyList.relationshipTo(anyList))
    }

    @Ignore
    @Test
    fun testDifferentListsOfTheSameLengthAreUnequal() {
        assertEquals(
                Relationship.UNEQUAL,
                listOf(1, 2, 3).relationshipTo(listOf(2, 3, 4)))
    }

    @Ignore
    @Test
    fun testSublistCheckDoesNotAbortAfterFalseStart() {
        assertEquals(
                Relationship.SUBLIST,
                listOf('1', '2', '5').relationshipTo(listOf('0', '1', '2', '3', '1', '2', '5', '6')))
    }

    @Ignore
    @Test
    fun testSublistCheckHandlesExtraneousRepeatsOfFirstEntry() {
        assertEquals(
                Relationship.SUBLIST,
                listOf("1", "1", "2").relationshipTo(listOf("0", "1", "1", "1", "2", "1", "2")))
    }

    @Ignore
    @Test
    fun testSublistAtStart() {
        assertEquals(
                Relationship.SUBLIST,
                listOf(0, 1, 2).relationshipTo(listOf(0, 1, 2, 3, 4, 5)))
    }

    @Ignore
    @Test
    fun testSublistInMiddle() {
        assertEquals(
                Relationship.SUBLIST,
                listOf('2', '3', '4').relationshipTo(listOf('0', '1', '2', '3', '4', '5')))
    }

    @Ignore
    @Test
    fun testSublistAtEnd() {
        assertEquals(
                Relationship.SUBLIST,
                listOf("3", "4", "5").relationshipTo(listOf("0", "1", "2", "3", "4", "5")))
    }

    @Ignore
    @Test
    fun testAtStartOfSuperlist() {
        assertEquals(
                Relationship.SUPERLIST,
                listOf(0, 1, 2, 3, 4, 5).relationshipTo(listOf(0, 1, 2)))
    }

    @Ignore
    @Test
    fun testInMiddleOfSuperlist() {
        assertEquals(
                Relationship.SUPERLIST,
                listOf('0', '1', '2', '3', '4', '5').relationshipTo(listOf('2', '3')))
    }

    @Ignore
    @Test
    fun testAtEndOfSuperlist() {
        assertEquals(
                Relationship.SUPERLIST,
                listOf("0", "1", "2", "3", "4", "5").relationshipTo(listOf("3", "4", "5")))
    }

    @Ignore
    @Test
    fun testFirstListMissingElementFromSecondList() {
        assertEquals(
                Relationship.UNEQUAL,
                listOf(1, 3).relationshipTo(listOf(1, 2, 3)))
    }

    @Ignore
    @Test
    fun testSecondListMissingElementFromFirstList() {
        assertEquals(
                Relationship.UNEQUAL,
                listOf('1', '2', '3').relationshipTo(listOf('1', '3')))
    }

    @Ignore
    @Test
    fun testThatListOrderingIsAccountedFor() {
        assertEquals(
                Relationship.UNEQUAL,
                listOf("1", "2", "3").relationshipTo(listOf("3", "2", "1")))
    }

    @Ignore
    @Test
    fun testThatListsWithSameDigitsButDifferentNumbersAreUnequal() {
        assertEquals(
                Relationship.UNEQUAL,
                listOf(1, 0, 1).relationshipTo(listOf(10, 1)))
    }

}
