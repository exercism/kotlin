import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class FlattenerTest {


    @Test
    fun flattensANestedList() {
        val nestedList = listOf<Any>(emptyList<Any>())
        assertEquals(emptyList<Any>(), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun flattens2LevelNestedList() {
        val nestedList = listOf(1, listOf(2, 3, 4), 5)
        assertEquals(listOf(1, 2, 3, 4, 5), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun flattens3LevelNestedList() {
        val nestedList = listOf(1, listOf(2, 3, 4), 5, listOf(6, listOf(7, 8)))
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
        val nestedList = listOf(1, listOf(2, null, listOf(listOf(3), null), listOf(4, listOf(listOf(5))), 6, 7, listOf(listOf(null))), 8, null)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), Flattener.flatten(nestedList))
    }

    @Ignore
    @Test
    fun allNullNestedListReturnsEmptyList() {
        val nestedList = listOf(null, listOf(null, listOf(null), listOf(listOf(listOf(null)))), null)
        assertEquals(emptyList<Any>(), Flattener.flatten(nestedList))
    }
}

