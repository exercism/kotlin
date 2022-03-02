import org.junit.Test
import kotlin.test.assertEquals

class KnapsackTest {

    @Test
    fun `no items`() = assertEquals(0, knapsack(100, listOf()))

    @Test
    fun `one item, too heavy`() {
        val items = listOf(Item(100, 1))
        assertEquals(0, knapsack(10, items))
    }

    @Test
    fun `five items (cannot be greedy by weight)`() {
        val items = listOf(
            Item(2, 5),
            Item(2, 5),
            Item(2, 5),
            Item(2, 5),
            Item(10, 21)
        )
        assertEquals(21, knapsack(10, items))
    }

    @Test
    fun `five items (cannot be greedy by value)`() {
        val items = listOf(
            Item(2, 20),
            Item(2, 20),
            Item(2, 20),
            Item(2, 20),
            Item(10, 50)
        )
        assertEquals(80, knapsack(10, items))
    }

    @Test
    fun `example knapsack`() {
        val items = listOf(
            Item(5, 10),
            Item(4, 40),
            Item(6, 30),
            Item(4, 50)
        )
        assertEquals(90, knapsack(10, items))
    }

    @Test
    fun `8 items`() {
        val items = listOf(
            Item(25, 350),
            Item(35, 400),
            Item(45, 450),
            Item(5, 20),
            Item(25, 70),
            Item(3, 8),
            Item(2, 5),
            Item(2, 5)
        )
        assertEquals(900, knapsack(104, items))
    }

    @Test
    fun `15 items`() {
        val items = listOf(
            Item(70, 135),
            Item(73, 139),
            Item(77, 149),
            Item(80, 150),
            Item(82, 156),
            Item(87, 163),
            Item(90, 173),
            Item(94, 184),
            Item(98, 192),
            Item(106, 201),
            Item(110, 210),
            Item(113, 214),
            Item(115, 221),
            Item(118, 229),
            Item(120, 240)
        )
        assertEquals(1458, knapsack(750, items))
    }
}