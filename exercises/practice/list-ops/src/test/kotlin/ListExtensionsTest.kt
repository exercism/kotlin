import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ListExtensionsTest {

    @Test
    fun `append - empty lists`() =
        assertEquals(
            emptyList(),
            emptyList<Int>().customAppend(emptyList())
        )

    @Ignore
    @Test
    fun `append - list to empty list`() =
        assertEquals(
            listOf('1', '2', '3', '4'),
            emptyList<Char>().customAppend(listOf('1', '2', '3', '4'))
        )

    @Ignore
    @Test
    fun `append - non-empty lists`() =
        assertEquals(
            listOf("1", "2", "2", "3", "4", "5"),
            listOf("1", "2").customAppend(listOf("2", "3", "4", "5"))
        )

    @Ignore
    @Test
    fun `concatenate - empty list`() =
        assertEquals(
            emptyList<Char>(),
            emptyList<Any>().customConcat()
        )

    @Ignore
    @Test
    fun `concatenate - list of lists`() =
        assertEquals(
            listOf('1', '2', '3', '4', '5', '6'),
            listOf(
                listOf('1', '2'),
                listOf('3'),
                emptyList(),
                listOf('4', '5', '6')
            ).customConcat()
        )

    @Ignore
    @Test
    fun `concatenate - list of nested lists`() =
        assertEquals(
            listOf('1', '2', '3', '4', '5', '6'),
            listOf(
                listOf(
                    listOf('1'),
                    listOf('2')
                ),
                listOf(
                    listOf('3')
                ),
                listOf(
                    emptyList()
                ),
                listOf(
                    listOf('4', '5', '6')
                )
            ).customConcat()
        )

    @Ignore
    @Test
    fun `filter - empty list`() =
        assertEquals(
            emptyList(),
            emptyList<Int>().customFilter { it % 2 == 1 })


    @Ignore
    @Test
    fun `filter - non-empty list`() =
        assertEquals(
            listOf(1, 3, 5),
            listOf(1, 2, 3, 5).customFilter { it % 2 == 1 })

    @Ignore
    @Test
    fun `size - empty list`() = assertEquals(0, emptyList<Int>().customSize)

    @Ignore
    @Test
    fun `size - non-empty list`() = assertEquals(4, listOf("one", "two", "three", "four").customSize)

    @Ignore
    @Test
    fun `map - empty list`() =
        assertEquals(
            emptyList(),
            emptyList<Int>().customMap { it -> it + 1 })

    @Ignore
    @Test
    fun `map - non-empty list`() =
        assertEquals(
            listOf(2, 4, 6, 8),
            listOf(1, 3, 5, 7).customMap { it -> it + 1 })

    @Ignore
    @Test
    fun `fold left - empty list`() =
        assertEquals(
            2.0,
            emptyList<Int>().customFoldLeft(2.0, Double::times)
        )

    @Ignore
    @Test
    fun `fold left - direction independent function`() =
        assertEquals(
            15,
            listOf(1, 2, 3, 4).customFoldLeft(5, Int::plus)
        )

    @Ignore
    @Test
    fun `fold left - direction dependent function`() =
        assertEquals(
            0,
            listOf(2, 5).customFoldLeft(5, Int::div)
        )

    @Ignore
    @Test
    fun `fold right - empty list`() =
        assertEquals(
            2.0,
            emptyList<Double>().customFoldRight(2.0, Double::times)
        )

    @Ignore
    @Test
    fun `fold right - direction independent function`() =
        assertEquals(
            15,
            listOf(1, 2, 3, 4).customFoldRight(5, Int::plus)
        )

    @Ignore
    @Test
    fun `fold right - direction dependent function`() =
        assertEquals(
            2,
            listOf(2, 5).customFoldRight(5, Int::div)
        )

    @Ignore
    @Test
    fun `reverse - empty list`() =
        assertEquals(
            emptyList(),
            emptyList<Int>().customReverse()
        )

    @Ignore
    @Test
    fun `reverse - non-empty list`() =
        assertEquals(
            listOf('7', '5', '3', '1'),
            listOf('1', '3', '5', '7').customReverse()
        )

    @Ignore
    @Test
    fun `reverse - list of lists`() =
        assertEquals(
            listOf(
                listOf('4', '5', '6'),
                emptyList<Char>(),
                '3',
                listOf('1', '2')
            ),
            listOf(
                listOf('1', '2'),
                '3',
                emptyList<Char>(),
                listOf('4', '5', '6')
            ).customReverse()
        )

}
