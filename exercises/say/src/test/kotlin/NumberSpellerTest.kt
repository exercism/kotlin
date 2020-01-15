import org.junit.Ignore
import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class NumberSpellerTest {
    @Test
    fun `0 as zero`() = 0.shouldSoundLike("zero")

    @Ignore
    @Test
    fun `1 as one`() = 1.shouldSoundLike("one")

    @Ignore
    @Test
    fun `14 as fourteen`() = 14.shouldSoundLike("fourteen")

    @Ignore
    @Test
    fun `20 as twenty`() = 20.shouldSoundLike("twenty")

    @Ignore
    @Test
    fun `22 as twenty-two`() = 22.shouldSoundLike("twenty-two")

    @Ignore
    @Test
    fun `100 as one hundred`() = 100.shouldSoundLike("one hundred")

    @Ignore
    @Test
    fun `123 as one hundred twenty-three`() = 123.shouldSoundLike("one hundred twenty-three")

    @Ignore
    @Test
    fun `1000 as one thousand`() = 1000.shouldSoundLike("one thousand")

    @Ignore
    @Test
    fun `1234 as one thousand two hundred thirty-four`() = 1234.shouldSoundLike("one thousand two hundred thirty-four")

    @Ignore
    @Test
    fun `1000000 as one million`() = 1000000.shouldSoundLike("one million")

    @Ignore
    @Test
    fun `1002345 as one million two thousand three hundred forty-five`() =
        1002345.shouldSoundLike("one million two thousand three hundred forty-five")

    @Ignore
    @Test
    fun `1000000000 as one billion`() = 1000000000.shouldSoundLike("one billion")

    @Ignore
    @Test
    fun `spell a big number`() = 987654321123
        .shouldSoundLike("nine hundred eighty-seven billion six hundred fifty-four million three hundred twenty-one thousand one hundred twenty-three")

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `numbers below zero are out of range`() {
        NumberSpeller().say(-1)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun `numbers above 999,999,999,999 are out of range`() {
        NumberSpeller().say(1000000000000)
    }
}

private fun Long.shouldSoundLike(expected: String) = assertEquals(expected, NumberSpeller().say(this))

private fun Int.shouldSoundLike(expected: String) = this.toLong().shouldSoundLike(expected)
