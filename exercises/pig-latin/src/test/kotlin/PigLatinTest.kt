import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class PigLatinTest(val input: String, val expectedOutput: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: translate({0})={1}")
        fun data() = arrayOf(
                // Ay is added to words that start with vowels
                arrayOf("apple",  "appleay"),
                arrayOf("ear",    "earay"),
                arrayOf("igloo",  "iglooay"),
                arrayOf("object", "objectay"),
                arrayOf("under",  "underay"),

                // Ay is added to words that start with vowels followed by qu
                arrayOf("equal",  "equalay"),

                // First letter and ay are moved to the end of words that start with consonants
                arrayOf("pig",    "igpay"),
                arrayOf("koala",  "oalakay"),
                arrayOf("xenon",  "enonxay"),
                arrayOf("qat",    "atqay"),

                // Ch is treated like a single consonant
                arrayOf("chair", "airchay"),

                // Qu is treated like a single consonant
                arrayOf("queen", "eenquay"),

                // Qu and a single preceding consonant are treated like a single consonant
                arrayOf("square", "aresquay"),

                // Th is treated like a single consonant
                arrayOf("therapy", "erapythay"),

                // Thr is treated like a single consonant
                arrayOf("thrush", "ushthray"),

                // Sch is treated like a single consonant
                arrayOf("school", "oolschay"),

                // Yt is treated like a single vowel
                arrayOf("yttria", "yttriaay"),

                // Xr is treated like a single vowel
                arrayOf("xray", "xrayay"),

                // Y is treated like a consonant at the beginning of a word
                arrayOf("yellow", "ellowyay"),

                // Y is treated like a vowel at the end of a consonant cluster
                arrayOf("rhythm", "ythmrhay"),

                // Y as second letter in two letter word
                arrayOf("my",     "ymay"),

                // Phrases are translated
                arrayOf("quick fast run", "ickquay astfay unray")
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, PigLatin.translate(input))
    }

}
