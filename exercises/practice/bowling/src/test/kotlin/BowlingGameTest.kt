import org.junit.Ignore
import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.test.Test
import kotlin.test.assertEquals

class BowlingGameTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    private fun playGame(rolls: IntArray): BowlingGame {
        val game = BowlingGame()
        rolls.forEach {
            game.roll(it)
        }
        return game
    }

    @Test
    fun `should be able to score a game with all zeros`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(0, game.score())
    }

    @Test
    @Ignore
    fun `should be able to score a game with no strike or spares`() {
        val game = playGame(intArrayOf(3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6))
        assertEquals(90, game.score())
    }

    @Test
    @Ignore
    fun `a spare followed by zeros is worth ten points`() {
        val game = playGame(intArrayOf(6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(10, game.score())
    }

    @Test
    @Ignore
    fun `points scored in the roll after a spare are counted twice`() {
        val game = playGame(intArrayOf(6, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(16, game.score())
    }

    @Test
    @Ignore
    fun `consecutive spares each get a one roll bonus`() {
        val game = playGame(intArrayOf(5, 5, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(31, game.score())
    }

    @Test
    @Ignore
    fun `a spare in the last frame gets a one roll bonus that is counted once`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 7))
        assertEquals(17, game.score())
    }

    @Test
    @Ignore
    fun `a strike earns ten points in frame with a single roll`() {
        val game = playGame(intArrayOf(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(10, game.score())
    }

    @Test
    @Ignore
    fun `points scored in the two rolls after a strike are counted twice as a bonus`() {
        val game = playGame(intArrayOf(10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(26, game.score())
    }

    @Test
    @Ignore
    fun `consecutive strikes each get the two roll bonus`() {
        val game = playGame(intArrayOf(10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(81, game.score())
    }

    @Test
    @Ignore
    fun `a strike in the last frame gets a two roll bonus that is counted once`() {
        val game = playGame(intArrayOf(10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(81, game.score())
    }

    @Test
    @Ignore
    fun `rolling a spare with the two roll bonus does not get a bonus roll`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3))
        assertEquals(20, game.score())
    }

    @Test
    @Ignore
    fun `strikes with the two roll bonus do not get bonus rolls`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10))
        assertEquals(30, game.score())
    }

    @Test
    @Ignore
    fun `last two strikes followed by only last bonus with non strike points`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 1))
        assertEquals(31, game.score())
    }

    @Test
    @Ignore
    fun `a strike with the one roll bonus after a spare in the last frame does not get a bonus`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 10))
        assertEquals(20, game.score())
    }

    @Test
    @Ignore
    fun `all strikes is a perfect game`() {
        val game = playGame(intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10))
        assertEquals(300, game.score())
    }

    @Test
    @Ignore
    fun `rolls can not score negative points`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    @Test
    @Ignore
    fun `a roll can not score more than 10 points`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    @Test
    @Ignore
    fun `two rolls in a frame can not score more than 10 points`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    @Test
    @Ignore
    fun `bonus roll after a strike in the last frame can not score more than 10 points`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 0))
    }

    @Test
    @Ignore
    fun `two bonus rolls after a strike in the last frame can not score more than 10 points`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 6))
    }

    @Test
    @Ignore
    fun `two bonus rolls after a strike in the last frame can score more than 10 points if one is a strike`() {
        val game = playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 6))
        assertEquals(26, game.score())
    }

    @Test
    @Ignore
    fun `the second bonus rolls after a strike in the last frame can not be a strike if the first one is not a strike`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 10))
    }

    @Test
    @Ignore
    fun `second bonus roll after a strike in the last frame can not score more than 10 points`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 11))
    }

    @Test
    @Ignore
    fun `an unstarted game can not be scored`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf()).score()
    }

    @Test
    @Ignore
    fun `an incomplete game can not be scored`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 1)).score()
    }

    @Test
    @Ignore
    fun `can not roll if game already has ten frames`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    @Test
    @Ignore
    fun `bonus rolls for a strike in the last frame must be rolled before score can be calculated`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10)).score()
    }

    @Test
    @Ignore
    fun `both bonus rolls for a strike in the last frame must be rolled before score can be calculated`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10)).score()
    }

    @Test
    @Ignore
    fun `bonus roll for a spare in the last frame must be rolled before score can be calculated`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3)).score()
    }

    @Test
    @Ignore
    fun `can not roll after bonus roll for spare`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 2, 2)).score()
    }

    @Test
    @Ignore
    fun `can not roll after bonus roll for strike`() {
        expectedException.expect(IllegalStateException::class.java)

        playGame(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 3, 2, 2)).score()
    }
}
