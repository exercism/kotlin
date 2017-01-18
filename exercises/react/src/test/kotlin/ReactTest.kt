import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

class ReactTest {
    @Test
    fun inputCellsHaveValue() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(10)
        assertEquals(10, input.value)
    }

    @Test
    fun inputCellsValueCanBeSet() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(4)
        input.value = 20
        assertEquals(20, input.value)
    }

    @Test
    fun computeCellsCalculateInitialValue() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it + 1 }
        assertEquals(2, output.value)
    }

    @Test
    fun computeCellsTakeInputsInTheRightOrder() {
        val reactor = Reactor<Int>()
        val one = reactor.InputCell(1)
        val two = reactor.InputCell(2)
        val output = reactor.ComputeCell(one, two) { x, y -> x + y * 10 }
        assertEquals(21, output.value)
    }

    @Test
    fun computeCellsUpdateValueWhenDependenciesAreChanged() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it + 1 }
        input.value = 3
        assertEquals(4, output.value)
    }

    @Test
    fun computeCellsCanDependOnOtherComputeCells() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val timesTwo = reactor.ComputeCell(input) { it * 2 }
        val timesThirty = reactor.ComputeCell(input) { it * 30 }
        val output = reactor.ComputeCell(timesTwo, timesThirty) { x, y -> x + y }

        assertEquals(32, output.value)
        input.value = 3
        assertEquals(96, output.value)
    }

    @Test
    fun computeCellsFireCallbacks() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it + 1 }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 3
        assertEquals(listOf(4), vals)
    }

    @Test
    fun callbacksOnlyFireOnChange() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { if (it < 3) 111 else 222 }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 2
        assertEquals(listOf<Int>(), vals)

        input.value = 4
        assertEquals(listOf(222), vals)
    }

    @Test
    fun callbacksCanBeAddedAndRemoved() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(11)
        val output = reactor.ComputeCell(input) { it + 1 }

        val vals1 = mutableListOf<Int>()
        val sub1 = output.addCallback { vals1.add(it) }
        val vals2 = mutableListOf<Int>()
        output.addCallback { vals2.add(it) }

        input.value = 31
        sub1.cancel()

        val vals3 = mutableListOf<Int>()
        output.addCallback { vals3.add(it) }

        input.value = 41

        assertEquals(listOf(32), vals1)
        assertEquals(listOf(32, 42), vals2)
        assertEquals(listOf(42), vals3)
    }

    @Test
    fun removingACallbackMultipleTimesDoesntInterfereWithOtherCallbacks() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it + 1 }

        val vals1 = mutableListOf<Int>()
        val sub1 = output.addCallback { vals1.add(it) }
        val vals2 = mutableListOf<Int>()
        output.addCallback { vals2.add(it) }

        for (i in 1..10) {
            sub1.cancel()
        }

        input.value = 2
        assertEquals(listOf<Int>(), vals1)
        assertEquals(listOf(3), vals2)
    }

    @Test
    fun callbacksShouldOnlyBeCalledOnceEvenIfMultipleDependenciesChange() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val plusOne = reactor.ComputeCell(input) { it + 1 }
        val minusOne1 = reactor.ComputeCell(input) { it - 1 }
        val minusOne2 = reactor.ComputeCell(minusOne1) { it - 1 }
        val output = reactor.ComputeCell(plusOne, minusOne2) { x, y -> x * y }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 4
        assertEquals(listOf(10), vals)
    }

    @Test
    fun callbacksShouldNotBeCalledIfDependenciesChangeButOutputValueDoesntChange() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val plusOne = reactor.ComputeCell(input) { it + 1 }
        val minusOne = reactor.ComputeCell(input) { it - 1 }
        val alwaysTwo = reactor.ComputeCell(plusOne, minusOne) { x, y -> x - y }

        val vals = mutableListOf<Int>()
        alwaysTwo.addCallback { vals.add(it) }

        for (i in 1..10) {
            input.value = i
        }

        assertEquals(listOf<Int>(), vals)
    }
}

@RunWith(Parameterized::class)
// This is a digital logic circuit called an adder:
// https://en.wikipedia.org/wiki/Adder_(electronics)
class ReactAdderTest(val aval: Boolean, val bval: Boolean, val cin: Boolean, val expectedCout: Boolean, val expectedSum: Boolean) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} + {1} + {2} = {3} {4}")
        fun data() = listOf(
                arrayOf(false, false, false, false, false),
                arrayOf(false, false, true, false, true),
                arrayOf(false, true, false, false, true),
                arrayOf(false, true, true, true, false),
                arrayOf(true, false, false, false, true),
                arrayOf(true, false, true, true, false),
                arrayOf(true, true, false, true, false),
                arrayOf(true, true, true, true, true)
        )
    }

    @Test
    fun test() {
        val reactor = Reactor<Boolean>()
        val a = reactor.InputCell(aval)
        val b = reactor.InputCell(bval)
        val carryIn = reactor.InputCell(cin)

        val aXorB = reactor.ComputeCell(a, b) { a, b -> a.xor(b) }
        val sum = reactor.ComputeCell(aXorB, carryIn) { axorb, cin -> axorb.xor(cin) }

        val aXorBAndCin = reactor.ComputeCell(aXorB, carryIn) { axorb, cin -> axorb && cin }
        val aAndB = reactor.ComputeCell(a, b) { a, b -> a && b }
        val carryOut = reactor.ComputeCell(aXorBAndCin, aAndB) { a, b -> a || b }

        // Test them both at once so if they fail we get to see both values.
        assertEquals(
                listOf(expectedSum, expectedCout),
                listOf(sum.value, carryOut.value)
        )
    }
}
