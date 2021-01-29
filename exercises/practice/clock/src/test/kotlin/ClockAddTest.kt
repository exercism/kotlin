import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ClockAddTest {

    @Ignore
    @Test
    fun `add minutes`() =
        Clock(10, 0)
            .plusMinutes(3)
            .shouldBe("10:03")

    @Ignore
    @Test
    fun `add no minutes`() =
        Clock(6, 41)
            .plusMinutes(0)
            .shouldBe("06:41")

    @Ignore
    @Test
    fun `add to next hour`() =
        Clock(0, 45)
            .plusMinutes(40)
            .shouldBe("01:25")


    @Ignore
    @Test
    fun `add more than one hour`() =
        Clock(10, 0)
            .plusMinutes(61)
            .shouldBe("11:01")


    @Ignore
    @Test
    fun `add more than two hours with carry`() =
        Clock(0, 45)
            .plusMinutes(160)
            .shouldBe("03:25")


    @Ignore
    @Test
    fun `add across midnight`() =
        Clock(23, 59)
            .plusMinutes(2)
            .shouldBe("00:01")


    @Ignore
    @Test
    fun `add more than one day`() =
        Clock(5, 32)
            .plusMinutes(1500)
            .shouldBe("06:32")


    @Ignore
    @Test
    fun `add more than two days`() =
        Clock(1, 1)
            .plusMinutes(3500)
            .shouldBe("11:21")

}

private fun Clock.plusMinutes(minutes: Int): Clock {
    add(minutes)
    return this
}

private fun Clock.shouldBe(expectation: String) = assertEquals(expectation, toString())
