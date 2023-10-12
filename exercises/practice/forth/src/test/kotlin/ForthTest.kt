import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

@Nested
class ForthTest {
    @Nested
    inner class ParsingAndNumbersTest {

        @Test
        fun `numbers just get pushed onto the stack`() =
            assertEquals(listOf(1, 2, 3, 4, 5), Forth().evaluate("1 2 3 4 5"))
    }

    @Nested
    inner class Addition {

        @Test
        fun `can add two numbers`() = assertEquals(listOf(3), Forth().evaluate("1 2 +"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("+") }
            assertEquals("empty stack", ex.message)
        }

        @Test
        fun `errors if there is only one value on the stack`() {
            val ex = assertFails { Forth().evaluate("1 +") }
            assertEquals("only one value on the stack", ex.message)
        }
    }

    @Nested
    inner class Subtraction {

        @Test
        fun `can subtract two numbers`() = assertEquals(listOf(-1), Forth().evaluate("3 4 -"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("-") }
            assertEquals("empty stack", ex.message)
        }

        @Test
        fun `errors if there is only one value on the stack`() {
            val ex = assertFails { Forth().evaluate("1 -") }
            assertEquals("only one value on the stack", ex.message)
        }
    }

    @Nested
    inner class Multiplication {

        @Test
        fun `can multiply two numbers`() =
            assertEquals(listOf(8), Forth().evaluate("2 4 *"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails {
                Forth().evaluate("*")
            }
            assertEquals("empty stack", ex.message)
        }

        @Test
        fun `errors if there is only one value on the stack`() {
            val ex = assertFails {
                Forth().evaluate("1 *")
            }
            assertEquals("only one value on the stack", ex.message)
        }
    }

    @Nested
    inner class Division {

        @Test
        fun `can divide two numbers`() =
            assertEquals(listOf(4), Forth().evaluate("12 3 /"))

        @Test
        fun `performs integer division`() =
            assertEquals(listOf(2), Forth().evaluate("8 3 /"))

        @Test
        fun `errors if dividing by zero`() {
            val ex = assertFails { Forth().evaluate("4 0 /") }
            assertEquals("divide by zero", ex.message)
        }

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("/") }
            assertEquals("empty stack", ex.message)
        }

        @Test
        fun `errors if there is only one value on the stack`() {
            val ex = assertFails { Forth().evaluate("1 /") }
            assertEquals("only one value on the stack", ex.message)
        }
    }

    @Nested
    inner class CombinedArithmetic {

        @Test
        fun `addition and subtraction`() =
            assertEquals(listOf(-1), Forth().evaluate("1 2 + 4 -"))

        @Test
        fun `multiplication and division`() =
            assertEquals(listOf(2), Forth().evaluate("2 4 * 3 /"))
    }

    @Nested
    inner class Dup {

        @Test
        fun `copies a value on the stack`() =
            assertEquals(listOf(1, 1), Forth().evaluate("1 dup"))

        @Test
        fun `copies the top value on the stack`() =
            assertEquals(listOf(1, 2, 2), Forth().evaluate("1 2 dup"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("dup") }
            assertEquals("empty stack", ex.message)
        }
    }

    @Nested
    inner class Drop {

        @Test
        fun `removes the top value on the stack if it is the only one`() =
            assertEquals(emptyList(), Forth().evaluate("1 drop"))

        @Test
        fun `removes the top value on the stack if it is not the only one`() =
            assertEquals(listOf(1), Forth().evaluate("1 2 drop"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("drop") }
            assertEquals("empty stack", ex.message)
        }
    }

    @Nested
    inner class Swap {

        @Test
        fun `swaps the top two values on the stack if they are the only ones`() =
            assertEquals(listOf(2, 1), Forth().evaluate("1 2 swap"))

        @Test
        fun `swaps the top two values on the stack if they are not the only ones`() =
            assertEquals(listOf(1, 3, 2), Forth().evaluate("1 2 3 swap"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("swap") }
            assertEquals("empty stack", ex.message)
        }

        @Test
        fun `errors if there is only one value on the stack`() {
            val ex = assertFails { Forth().evaluate("1 swap") }
            assertEquals("only one value on the stack", ex.message)
        }
    }

    @Nested
    inner class Over {

        @Test
        fun `copies the second element if there are only two`() =
            assertEquals(listOf(1, 2, 1), Forth().evaluate("1 2 over"))

        @Test
        fun `copies the second element if there are more than two`() =
            assertEquals(listOf(1, 2, 3, 2), Forth().evaluate("1 2 3 over"))

        @Test
        fun `errors if there is nothing on the stack`() {
            val ex = assertFails { Forth().evaluate("over") }
            assertEquals("empty stack", ex.message)
        }

        @Test
        fun `errors if there is only one value on the stack`() {
            val ex = assertFails { Forth().evaluate("1 over") }
            assertEquals("only one value on the stack", ex.message)
        }
    }

    @Nested
    inner class UserDefinedWords {

        @Test
        fun `can consist of built-in words`() = assertEquals(
            listOf(1, 1, 1),
            Forth().evaluate(
                ": dup-twice dup dup ;",
                "1 dup-twice",
            )
        )

        @Test
        fun `execute in the right order`() = assertEquals(
            listOf(1, 2, 3),
            Forth().evaluate(
                ": countup 1 2 3 ;",
                "countup",
            )
        )

        @Test
        fun `can override other user-defined words`() =
            assertEquals(
                listOf(1, 1, 1),
                Forth().evaluate(
                    ": foo dup ;",
                    ": foo dup dup ;",
                    "1 foo",
                )
            )

        @Test
        fun `can override built-in words`() = assertEquals(
            listOf(1, 1), Forth().evaluate(
                ": swap dup ;",
                "1 swap",
            )
        )

        @Test
        fun `can override built-in operators`() = assertEquals(
            listOf(12), Forth().evaluate(
                ": + * ;",
                "3 4 +",
            )
        )

        @Test
        fun `can use different words with the same name`() = assertEquals(
            listOf(5, 6), Forth().evaluate(
                ": foo 5 ;",
                ": bar foo ;",
                ": foo 6 ;",
                "bar foo",
            )
        )

        @Test
        fun `can define word that uses word with the same name`() = assertEquals(
            listOf(11), Forth().evaluate(
                ": foo 10 ;",
                ": foo foo 1 + ;",
                "foo",
            )
        )

        @Test
        fun `cannot redefine numbers`() {
            val ex = assertFails { Forth().evaluate(": 1 2 ;") }
            assertEquals("illegal operation", ex.message)
        }

        @Test
        fun `errors if executing a non-existent word`() {
            val ex = assertFails { Forth().evaluate("foo") }
            assertEquals("undefined operation", ex.message)
        }
    }

    @Nested
    inner class CaseInsensitivity {

        @Test
        fun `DUP is case-insensitive`() = assertEquals(listOf(1, 1, 1, 1), Forth().evaluate("1 DUP Dup dup"))

        @Test
        fun `DROP is case-insensitive`() = assertEquals(listOf(1), Forth().evaluate("1 2 3 4 DROP Drop drop"))

        @Test
        fun `SWAP is case-insensitive`() = assertEquals(listOf(2, 3, 4, 1), Forth().evaluate("1 2 SWAP 3 Swap 4 swap"))

        @Test
        fun `OVER is case-insensitive`() = assertEquals(listOf(1, 2, 1, 2, 1), Forth().evaluate("1 2 OVER Over over"))

        @Test
        fun `user-defined words are case-insensitive`() =
            assertEquals(
                listOf(1, 1, 1, 1),
                Forth().evaluate(": foo dup ;", "1 FOO Foo foo")
            )

        @Test
        fun `definitions are case-insensitive`() = assertEquals(
            listOf(1, 1, 1, 1), Forth().evaluate(
                ": SWAP DUP Dup dup ;",
                "1 swap",
            )
        )
    }
}
