import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class FlattenerTest {

    @Test
    fun flatListIsUnchanged() {
        val flatList = listOf(0, 1, 2)
        assertEquals(listOf(0, 1, 2), Flattener.flatten(flatList))
    }

    @Ignore
    @Test
    fun flattens2LevelNestedList() {
        val nestedList = listOf(1, listOf(2, 3, 4, 5, 6, 7), 8)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun flattens5LevelNestedList() {
        val nestedList = listOf(0, 2, listOf(listOf(2, 3), 8, 100, 4, listOf(listOf(listOf(50))), -2))
        assertEquals(listOf(0, 2, 2, 3, 8, 100, 4, 50, -2), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun flattens6LevelNestedList() {
        val nestedList = listOf(1, listOf(2, listOf(listOf(3)), listOf(4, listOf(listOf(5))), 6, 7), 8)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun flattens6LevelNestedListWithNulls() {
        val nestedList = listOf(0, 2, listOf(listOf(2, 3), 8, listOf(listOf(100)), null, listOf(listOf(null))), -2)
        assertEquals(listOf(0, 2, 2, 3, 8, 100, -2), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun allNullNestedListReturnsEmptyList() {
        val nestedList = listOf(null, listOf(listOf(listOf(null))), null, null, listOf(listOf(null, null), null), null)
        assertEquals(emptyList<Any>(), Flattener.flatten(nestedList))
    }

}
