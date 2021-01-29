import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ClockSubtractTest {

    @Ignore
    @Test
    fun `subtract minutes`() =
        Clock(10, 3)
            .minusMinutes(3)
            .shouldBe("10:00")

    @Ignore
    @Test
    fun `subtract to previous hour`() =
        Clock(10, 3)
            .minusMinutes(30)
            .shouldBe("09:33")

    @Ignore
    @Test
    fun `subtract more than an hour`() =
        Clock(10, 3)
            .minusMinutes(70)
            .shouldBe("08:53")

    @Ignore
    @Test
    fun `subtract across midnight`() =
        Clock(0, 3)
            .minusMinutes(4)
            .shouldBe("23:59")

    @Ignore
    @Test
    fun `subtract more than two hours`() =
        Clock(0, 0)
            .minusMinutes(160)
            .shouldBe("21:20")

    @Ignore
    @Test
    fun `subtract more than two hours with borrow`() =
        Clock(6, 15)
            .minusMinutes(160)
            .shouldBe("03:35")

    @Ignore
    @Test
    fun `subtract more than one day`() =
        Clock(5, 32)
            .minusMinutes(1500)
            .shouldBe("04:32")

    @Ignore
    @Test
    fun `subtract more than two days`() =
        Clock(2, 20)
            .minusMinutes(3000)
            .shouldBe("00:20")

}

private fun Clock.minusMinutes(minutes: Int): Clock {
    subtract(minutes)
    return this
}

private fun Clock.shouldBe(expectation: String) = assertEquals(expectation, toString())
