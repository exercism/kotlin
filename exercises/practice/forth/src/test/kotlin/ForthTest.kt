import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class ForthTest {

    @Rule
    @JvmField
    var expectedException = ExpectedException.none()

    class ParsingAndNumbersTest : ForthTest() {

        @Test
        fun `numbers just get pushed onto the stack`() = assertEquals(listOf(1, 2, 3, 4, 5), Forth().evaluate("1 2 3 4 5"))
    }

    class Addition : ForthTest() {

        @Ignore
        @Test
        fun `can add two numbers`() = assertEquals(listOf(3), Forth().evaluate("1 2 +"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("+")
        }

        @Ignore
        @Test
        fun `errors if there is only one value on the stack`() {
            expectedException.expectMessage("only one value on the stack")
            Forth().evaluate("1 +")
        }
    }

    class Subtraction : ForthTest() {

        @Ignore
        @Test
        fun `can subtract two numbers`() = assertEquals(listOf(-1), Forth().evaluate("3 4 -"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("-")
        }

        @Ignore
        @Test
        fun `errors if there is only one value on the stack`() {
            expectedException.expectMessage("only one value on the stack")
            Forth().evaluate("1 -")
        }
    }

    class Multiplication : ForthTest() {

        @Ignore
        @Test
        fun `can multiply two numbers`() = assertEquals(listOf(8), Forth().evaluate("2 4 *"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("*")
        }

        @Ignore
        @Test
        fun `errors if there is only one value on the stack`() {
            expectedException.expectMessage("only one value on the stack")
            Forth().evaluate("1 *")
        }
    }

    class Division : ForthTest() {

        @Ignore
        @Test
        fun `can divide two numbers`() = assertEquals(listOf(4), Forth().evaluate("12 3 /"))

        @Ignore
        @Test
        fun `performs integer division`() = assertEquals(listOf(2), Forth().evaluate("8 3 /"))

        @Ignore
        @Test
        fun `errors if dividing by zero`() {
            expectedException.expectMessage("divide by zero")
            Forth().evaluate("4 0 /")
        }

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("/")
        }

        @Ignore
        @Test
        fun `errors if there is only one value on the stack`() {
            expectedException.expectMessage("only one value on the stack")
            Forth().evaluate("1 /")
        }
    }

    class CombinedArithmetic : ForthTest() {

        @Ignore
        @Test
        fun `addition and subtraction`() = assertEquals(listOf(-1), Forth().evaluate("1 2 + 4 -"))

        @Ignore
        @Test
        fun `multiplication and division`() = assertEquals(listOf(2), Forth().evaluate("2 4 * 3 /"))
    }

    class Dup : ForthTest() {

        @Ignore
        @Test
        fun `copies a value on the stack`() = assertEquals(listOf(1, 1), Forth().evaluate("1 dup"))

        @Ignore
        @Test
        fun `copies the top value on the stack`() = assertEquals(listOf(1, 2, 2), Forth().evaluate("1 2 dup"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("dup")
        }
    }

    class Drop : ForthTest() {

        @Ignore
        @Test
        fun `removes the top value on the stack if it is the only one`() = assertEquals(listOf(), Forth().evaluate("1 drop"))

        @Ignore
        @Test
        fun `removes the top value on the stack if it is not the only one`() = assertEquals(listOf(1), Forth().evaluate("1 2 drop"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("drop")
        }
    }

    class Swap : ForthTest() {

        @Ignore
        @Test
        fun `swaps the top two values on the stack if they are the only ones`() = assertEquals(listOf(2, 1), Forth().evaluate("1 2 swap"))

        @Ignore
        @Test
        fun `swaps the top two values on the stack if they are not the only ones`() = assertEquals(listOf(1, 3, 2), Forth().evaluate("1 2 3 swap"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("swap")
        }

        @Ignore
        @Test
        fun `errors if there is only one value on the stack`() {
            expectedException.expectMessage("only one value on the stack")
            Forth().evaluate("1 swap")
        }
    }

    class Over : ForthTest() {

        @Ignore
        @Test
        fun `copies the second element if there are only two`() = assertEquals(listOf(1, 2, 1), Forth().evaluate("1 2 over"))

        @Ignore
        @Test
        fun `copies the second element if there are more than two`() = assertEquals(listOf(1, 2, 3, 2), Forth().evaluate("1 2 3 over"))

        @Ignore
        @Test
        fun `errors if there is nothing on the stack`() {
            expectedException.expectMessage("empty stack")
            Forth().evaluate("over")
        }

        @Ignore
        @Test
        fun `errors if there is only one value on the stack`() {
            expectedException.expectMessage("only one value on the stack")
            Forth().evaluate("1 over")
        }
    }

    class UserDefinedWords : ForthTest() {

        @Ignore
        @Test
        fun `can consist of built-in words`() = assertEquals(listOf(1, 1, 1), Forth().evaluate(": dup-twice dup dup ;", "1 dup-twice"))

        @Ignore
        @Test
        fun `execute in the right order`() = assertEquals(listOf(1, 2, 3), Forth().evaluate(": countup 1 2 3 ;", "countup"))

        @Ignore
        @Test
        fun `can override other user-defined words`() = assertEquals(listOf(1, 1, 1), Forth().evaluate(": foo dup ;", ": foo dup dup ;", "1 foo"))

        @Ignore
        @Test
        fun `can override built-in words`() = assertEquals(listOf(1, 1), Forth().evaluate(": swap dup ;", "1 swap"))

        @Ignore
        @Test
        fun `can override built-in operators`() = assertEquals(listOf(12), Forth().evaluate(": + * ;", "3 4 +"))

        @Ignore
        @Test
        fun `can use different words with the same name`() = assertEquals(listOf(5, 6), Forth().evaluate(": foo 5 ;", ": bar foo ;", ": foo 6 ;", "bar foo"))

        @Ignore
        @Test
        fun `can define word that uses word with the same name`() = assertEquals(listOf(11), Forth().evaluate(": foo 10 ;", ": foo foo 1 + ;", "foo"))

        @Ignore
        @Test
        fun `cannot redefine numbers`() {
            expectedException.expectMessage("illegal operation")
            Forth().evaluate(": 1 2 ;")
        }

        @Ignore
        @Test
        fun `errors if executing a non-existent word`() {
            expectedException.expectMessage("undefined operation")
            Forth().evaluate("foo")
        }
    }

    class CaseInsensitivity : ForthTest() {

        @Ignore
        @Test
        fun `DUP is case-insensitive`() = assertEquals(listOf(1, 1, 1, 1), Forth().evaluate("1 DUP Dup dup"))

        @Ignore
        @Test
        fun `DROP is case-insensitive`() = assertEquals(listOf(1), Forth().evaluate("1 2 3 4 DROP Drop drop"))

        @Ignore
        @Test
        fun `SWAP is case-insensitive`() = assertEquals(listOf(2, 3, 4, 1), Forth().evaluate("1 2 SWAP 3 Swap 4 swap"))

        @Ignore
        @Test
        fun `OVER is case-insensitive`() = assertEquals(listOf(1, 2, 1, 2, 1), Forth().evaluate("1 2 OVER Over over"))

        @Ignore
        @Test
        fun `user-defined words are case-insensitive`() = assertEquals(listOf(1, 1, 1, 1), Forth().evaluate(": foo dup ;", "1 FOO Foo foo"))

        @Ignore
        @Test
        fun `definitions are case-insensitive`() = assertEquals(listOf(1, 1, 1, 1), Forth().evaluate(": SWAP DUP Dup dup ;", "1 swap"))
    }
}
