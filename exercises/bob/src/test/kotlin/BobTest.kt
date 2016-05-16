import org.junit.Test
import kotlin.test.assertEquals

class BobTest {

    @Test
    fun saySomething() {
        assertEquals("Whatever.", Bob.hey("Tom-ay-to, tom-aaaah-to."))
    }

    @Test
    fun shouting() {
        assertEquals("Whoa, chill out!", Bob.hey("WATCH OUT!"))
    }

    @Test
    fun askingAQuestion() {
        assertEquals("Sure.", Bob.hey("Does this cryogenic chamber make me look fat?"))
    }

    @Test
    fun askingANumericQuestion() {
        assertEquals("Sure.", Bob.hey("You are, what, like 15?"))
    }

    @Test
    fun talkingForcefully() {
        assertEquals("Whatever.", Bob.hey("Let's go make out behind the gym!"))
    }

    @Test
    fun usingAcronymsInRegularSpeech() {
        assertEquals("Whatever.", Bob.hey("It's OK if you don't want to go to the DMV."))
    }

    @Test
    fun forcefulQuestions() {
        assertEquals("Whoa, chill out!", Bob.hey("WHAT THE HELL WERE YOU THINKING?"))
    }

    @Test
    fun shoutingNumbers() {
        assertEquals("Whoa, chill out!", Bob.hey("1, 2, 3 GO!"))
    }

    @Test
    fun onlyNumbers() {
        assertEquals("Whatever.", Bob.hey("1, 2, 3"))
    }

    @Test
    fun questionWithOnlyNumbers() {
        assertEquals("Sure.", Bob.hey("4?"))
    }

    @Test
    fun shoutingWithSpecialCharacters() {
        assertEquals("Whoa, chill out!", Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
    }

    @Test
    fun shoutingWithUmlauts() {
        assertEquals("Whoa, chill out!", Bob.hey("\u00dcML\u00c4\u00dcTS!"))
    }

    @Test
    fun calmlySpeakingWithUmlauts() {
        assertEquals("Whatever.", Bob.hey("\u00dcML\u00e4\u00dcTS!"))
    }

    @Test
    fun shoutingWithNoExclamationMark() {
        assertEquals("Whoa, chill out!", Bob.hey("I HATE YOU"))
    }

    @Test
    fun statementContainingQuestionMark() {
        assertEquals("Whatever.", Bob.hey("Ending with ? means a question."))
    }

    @Test
    fun prattlingOn() {
        assertEquals("Sure.", Bob.hey("Wait! Hang on. Are you going to be OK?"))
    }

    @Test
    fun silence() {
        assertEquals("Fine. Be that way!", Bob.hey(""))
    }

    @Test
    fun prolongedSilence() {
        assertEquals("Fine. Be that way!", Bob.hey("    "))
    }
}
