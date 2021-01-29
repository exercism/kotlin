import org.junit.Test
import org.junit.Ignore
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

    @Ignore
    @Test
    fun inputCellsValueCanBeSet() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(4)
        input.value = 20
        assertEquals(20, input.value)
    }

    @Ignore
    @Test
    fun computeCellsCalculateInitialValue() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it[0] + 1 }
        assertEquals(2, output.value)
    }

    @Ignore
    @Test
    fun computeCellsTakeInputsInTheRightOrder() {
        val reactor = Reactor<Int>()
        val one = reactor.InputCell(1)
        val two = reactor.InputCell(2)
        val output = reactor.ComputeCell(one, two) { (x, y) -> x + y * 10 }
        assertEquals(21, output.value)
    }

    @Ignore
    @Test
    fun computeCellsUpdateValueWhenDependenciesAreChanged() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it[0] + 1 }
        input.value = 3
        assertEquals(4, output.value)
    }

    @Ignore
    @Test
    fun computeCellsCanDependOnOtherComputeCells() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val timesTwo = reactor.ComputeCell(input) { it[0] * 2 }
        val timesThirty = reactor.ComputeCell(input) { it[0] * 30 }
        val output = reactor.ComputeCell(timesTwo, timesThirty) { (x, y) -> x + y }

        assertEquals(32, output.value)
        input.value = 3
        assertEquals(96, output.value)
    }

    @Ignore
    @Test
    fun computeCellsFireCallbacks() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it[0] + 1 }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 3
        assertEquals(listOf(4), vals)
    }

    @Ignore
    @Test
    fun callbacksOnlyFireOnChange() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { if (it[0] < 3) 111 else 222 }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 2
        assertEquals(listOf<Int>(), vals)

        input.value = 4
        assertEquals(listOf(222), vals)
    }

    @Ignore
    @Test
    fun callbacksCanBeAddedAndRemoved() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(11)
        val output = reactor.ComputeCell(input) { it[0] + 1 }

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

    @Ignore
    @Test
    fun removingACallbackMultipleTimesDoesntInterfereWithOtherCallbacks() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val output = reactor.ComputeCell(input) { it[0] + 1 }

        val vals1 = mutableListOf<Int>()
        val sub1 = output.addCallback { vals1.add(it) }
        val vals2 = mutableListOf<Int>()
        output.addCallback { vals2.add(it) }

        for (i in 1..3) {
            sub1.cancel()
        }

        input.value = 2
        assertEquals(listOf<Int>(), vals1)
        assertEquals(listOf(3), vals2)
    }

    @Ignore
    @Test
    fun callbacksShouldOnlyBeCalledOnceEvenIfMultipleDependenciesChange() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val plusOne = reactor.ComputeCell(input) { it[0] + 1 }
        val minusOne1 = reactor.ComputeCell(input) { it[0] - 1 }
        val minusOne2 = reactor.ComputeCell(minusOne1) { it[0] - 1 }
        val output = reactor.ComputeCell(plusOne, minusOne2) { (x, y) -> x * y }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 4
        assertEquals(listOf(10), vals)
    }

    @Ignore
    @Test
    fun callbacksShouldNotBeCalledIfDependenciesChangeButOutputValueDoesntChange() {
        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val plusOne = reactor.ComputeCell(input) { it[0] + 1 }
        val minusOne = reactor.ComputeCell(input) { it[0] - 1 }
        val alwaysTwo = reactor.ComputeCell(plusOne, minusOne) { (x, y) -> x - y }

        val vals = mutableListOf<Int>()
        alwaysTwo.addCallback { vals.add(it) }

        for (i in 2..5) {
            input.value = i
        }

        assertEquals(listOf<Int>(), vals)
    }

}

/*
 * Extension
 *
 * This is a digital logic circuit called an adder:
 * https://en.wikipedia.org/wiki/Adder_(electronics)
 */
@RunWith(Parameterized::class)
class ReactAdderTest(val input: Input, val expected: Expected) {

    companion object {
        data class Input(val a: Boolean, val b: Boolean, val carryIn: Boolean)
        data class Expected(val carryOut: Boolean, val sum: Boolean)

        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} = {1}")
        fun data() = listOf(
                arrayOf(Input(a=false, b=false, carryIn=false), Expected(carryOut=false, sum=false)),
                arrayOf(Input(a=false, b=false, carryIn=true),  Expected(carryOut=false, sum=true)),
                arrayOf(Input(a=false, b=true,  carryIn=false), Expected(carryOut=false, sum=true)),
                arrayOf(Input(a=false, b=true,  carryIn=true),  Expected(carryOut=true,  sum=false)),
                arrayOf(Input(a=true,  b=false, carryIn=false), Expected(carryOut=false, sum=true)),
                arrayOf(Input(a=true,  b=false, carryIn=true),  Expected(carryOut=true,  sum=false)),
                arrayOf(Input(a=true,  b=true,  carryIn=false), Expected(carryOut=true,  sum=false)),
                arrayOf(Input(a=true,  b=true,  carryIn=true),  Expected(carryOut=true,  sum=true))
        )
    }

    @Ignore
    @Test
    fun test() {
        val reactor = Reactor<Boolean>()
        val a = reactor.InputCell(input.a)
        val b = reactor.InputCell(input.b)
        val carryIn = reactor.InputCell(input.carryIn)

        val aXorB = reactor.ComputeCell(a, b) { (x, y) -> x.xor(y) }
        val sum = reactor.ComputeCell(aXorB, carryIn) { (x, y) -> x.xor(y) }

        val aXorBAndCin = reactor.ComputeCell(aXorB, carryIn) { (x, y) -> x && y }
        val aAndB = reactor.ComputeCell(a, b) { (x, y) -> x && y }
        val carryOut = reactor.ComputeCell(aXorBAndCin, aAndB) { (x, y) -> x || y }

        assertEquals(expected, Expected(sum=sum.value, carryOut=carryOut.value))
    }

}
