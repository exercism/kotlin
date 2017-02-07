import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class BobTest {


    @Test
    fun saySomething() {
        assertEquals("Whatever.", Bob.hey("Tom-ay-to, tom-aaaah-to."))
    }

    @Ignore
    @Test
    fun shouting() {
        assertEquals("Whoa, chill out!", Bob.hey("WATCH OUT!"))
    }

    @Ignore
    @Test
    fun askingAQuestion() {
        assertEquals("Sure.", Bob.hey("Does this cryogenic chamber make me look fat?"))
    }

    @Ignore
    @Test
    fun askingANumericQuestion() {
        assertEquals("Sure.", Bob.hey("You are, what, like 15?"))
    }

    @Ignore
    @Test
    fun talkingForcefully() {
        assertEquals("Whatever.", Bob.hey("Let's go make out behind the gym!"))
    }

    @Ignore
    @Test
    fun usingAcronymsInRegularSpeech() {
        assertEquals("Whatever.", Bob.hey("It's OK if you don't want to go to the DMV."))
    }

    @Ignore
    @Test
    fun forcefulQuestions() {
        assertEquals("Whoa, chill out!", Bob.hey("WHAT THE HELL WERE YOU THINKING?"))
    }

    @Ignore
    @Test
    fun shoutingNumbers() {
        assertEquals("Whoa, chill out!", Bob.hey("1, 2, 3 GO!"))
    }

    @Ignore
    @Test
    fun onlyNumbers() {
        assertEquals("Whatever.", Bob.hey("1, 2, 3"))
    }

    @Ignore
    @Test
    fun questionWithOnlyNumbers() {
        assertEquals("Sure.", Bob.hey("4?"))
    }

    @Ignore
    @Test
    fun shoutingWithSpecialCharacters() {
        assertEquals("Whoa, chill out!", Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
    }

    @Ignore
    @Test
    fun shoutingWithUmlauts() {
        assertEquals("Whoa, chill out!", Bob.hey("\u00dcML\u00c4\u00dcTS!"))
    }

    @Ignore
    @Test
    fun calmlySpeakingWithUmlauts() {
        assertEquals("Whatever.", Bob.hey("\u00dcML\u00e4\u00dcTS!"))
    }

    @Ignore
    @Test
    fun shoutingWithNoExclamationMark() {
        assertEquals("Whoa, chill out!", Bob.hey("I HATE YOU"))
    }

    @Ignore
    @Test
    fun statementContainingQuestionMark() {
        assertEquals("Whatever.", Bob.hey("Ending with ? means a question."))
    }

    @Ignore
    @Test
    fun prattlingOn() {
        assertEquals("Sure.", Bob.hey("Wait! Hang on. Are you going to be OK?"))
    }

    @Ignore
    @Test
    fun silence() {
        assertEquals("Fine. Be that way!", Bob.hey(""))
    }

    @Ignore
    @Test
    fun prolongedSilence() {
        assertEquals("Fine. Be that way!", Bob.hey("    "))
    }
}
