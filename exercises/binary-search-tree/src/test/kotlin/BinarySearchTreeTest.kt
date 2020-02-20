import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class BinarySearchTreeTest {

    @Test
    fun `data is retained`() {
        val tree = BinarySearchTree<Int>()
        val expected = 4
        tree.insert(expected)
        val root = tree.root
        assertNotNull(root)
        val actual = root.data
        assertEquals(expected, actual)
    }

    @Test
    fun `inserts less`() {
        val tree = BinarySearchTree<Char>()
        val expectedRoot = '4'
        val expectedLeft = '2'
        tree.insert(expectedRoot)
        tree.insert(expectedLeft)
        val root = tree.root
        assertNotNull(root)
        val left = root.left
        assertNotNull(left)
        val actualRoot = root.data
        val actualLeft = left.data
        assertEquals(expectedLeft, actualLeft)
        assertEquals(expectedRoot, actualRoot)
    }

    @Test
    fun `inserts same`() {
        val tree = BinarySearchTree<String>()
        val expectedRoot = "4"
        val expectedLeft = "4"
        tree.insert(expectedRoot)
        tree.insert(expectedLeft)
        val root = tree.root
        assertNotNull(root)
        val left = root.left
        assertNotNull(left)
        val actualRoot = root.data
        val actualLeft = left.data
        assertEquals(expectedLeft, actualLeft)
        assertEquals(expectedRoot, actualRoot)
    }

    @Test
    fun `inserts right`() {
        val tree = BinarySearchTree<Int>()
        val expectedRoot = 4
        val expectedRight = 5
        tree.insert(expectedRoot)
        tree.insert(expectedRight)
        val root = tree.root
        assertNotNull(root)
        val right = root.right
        assertNotNull(right)
        val actualRoot = root.data
        val actualRight = right.data
        assertEquals(expectedRight, actualRight)
        assertEquals(expectedRoot, actualRoot)
    }

    @Test
    fun `creates complex tree`() {
        val tree = BinarySearchTree<Char>()
        val expected = listOf('4', '2', '6', '1', '3', '5', '7')
        val treeData = listOf('4', '2', '6', '1', '3', '5', '7')
        treeData.forEach(tree::insert)
        val actual = tree.asLevelOrderList()
        assertEquals(expected, actual)
    }

    @Test
    fun `sorts single element`() {
        val tree = BinarySearchTree<String>()
        val expected = listOf("2")
        tree.insert("2")
        val actual = tree.asSortedList()
        assertEquals(expected, actual)
    }

    @Test
    fun `sorts collection of two if second inserted is smaller than first`() {
        val tree = BinarySearchTree<Int>()
        val expected: List<Int> = listOf(1, 2)
        tree.insert(2)
        tree.insert(1)
        val actual = tree.asSortedList()
        assertEquals(expected, actual)
    }

    @Test
    fun `sorts collection of two if second number is same as first`() {
        val tree = BinarySearchTree<Char>()
        val expected = listOf('2', '2')
        tree.insert('2')
        tree.insert('2')
        val actual = tree.asSortedList()
        assertEquals(expected, actual)
    }

    @Test
    fun `sorts collection of two if second inserted is bigger than first`() {
        val tree = BinarySearchTree<Char>()
        val expected = listOf('2', '3')
        tree.insert('2')
        tree.insert('3')
        val actual = tree.asSortedList()
        assertEquals(expected, actual)
    }

    @Test
    fun `iterates over complex tree`() {
        val tree = BinarySearchTree<String>()
        val expected = listOf("1", "2", "3", "5", "6", "7")
        val treeData = listOf("2", "1", "3", "6", "7", "5")
        treeData.forEach(tree::insert)
        val actual = tree.asSortedList()
        assertEquals(expected, actual)
    }

    @Test
    fun `big tree level order`() {
        val tree = BinarySearchTree<Int>()
        val expected = listOf(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15)
        val treeData = listOf(8, 4, 2, 6, 1, 3, 5, 7, 12, 14, 10, 9, 11, 13, 15)
        treeData.forEach(tree::insert)
        val actual = tree.asLevelOrderList()
        assertEquals(expected, actual)
    }
}
