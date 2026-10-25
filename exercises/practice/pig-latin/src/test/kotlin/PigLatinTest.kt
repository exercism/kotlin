import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test

class PigLatinTest() {

    @Test
    fun `word beginning with a`() {
        assertEquals("appleay", PigLatin.translate("apple"))
    }

    @Ignore
    @Test
    fun `word beginning with e`() {
        assertEquals("earay", PigLatin.translate("ear"))
    }

    @Ignore
    @Test
    fun `word beginning with i`() {
        assertEquals("iglooay", PigLatin.translate("igloo"))
    }

    @Ignore
    @Test
    fun `word beginning with o`() {
        assertEquals("objectay", PigLatin.translate("object"))
    }

    @Ignore
    @Test
    fun `word beginning with u`() {
        assertEquals("underay", PigLatin.translate("under"))
    }

    @Ignore
    @Test
    fun `word beginning with a vowel and followed by a qu`() {
        assertEquals("equalay", PigLatin.translate("equal"))
    }

    @Ignore
    @Test
    fun `word beginning with p`() {
        assertEquals("igpay", PigLatin.translate("pig"))
    }

    @Ignore
    @Test
    fun `word beginning with k`() {
        assertEquals("oalakay", PigLatin.translate("koala"))
    }

    @Ignore
    @Test
    fun `word beginning with x`() {
        assertEquals("enonxay", PigLatin.translate("xenon"))
    }

    @Ignore
    @Test
    fun `word beginning with q without a following u`() {
        assertEquals("atqay", PigLatin.translate("qat"))
    }

    @Ignore
    @Test
    fun `word beginning with consonant and vowel containing qu`() {
        assertEquals("iquidlay", PigLatin.translate("liquid"))
    }

    @Ignore
    @Test
    fun `word beginning with ch`() {
        assertEquals("airchay", PigLatin.translate("chair"))
    }

    @Ignore
    @Test
    fun `word beginning with qu`() {
        assertEquals("eenquay", PigLatin.translate("queen"))
    }

    @Ignore
    @Test
    fun `word beginning with qu and a preceding consonant`() {
        assertEquals("aresquay", PigLatin.translate("square"))
    }

    @Ignore
    @Test
    fun `word beginning with th`() {
        assertEquals("erapythay", PigLatin.translate("therapy"))
    }

    @Ignore
    @Test
    fun `word beginning with thr`() {
        assertEquals("ushthray", PigLatin.translate("thrush"))
    }

    @Ignore
    @Test
    fun `word beginning with sch`() {
        assertEquals("oolschay", PigLatin.translate("school"))
    }

    @Ignore
    @Test
    fun `word beginning with yt`() {
        assertEquals("yttriaay", PigLatin.translate("yttria"))
    }

    @Ignore
    @Test
    fun `word beginning with xr`() {
        assertEquals("xrayay", PigLatin.translate("xray"))
    }

    @Ignore
    @Test
    fun `y is treated like a consonant at the beginning of a word`() {
        assertEquals("ellowyay", PigLatin.translate("yellow"))
    }

    @Ignore
    @Test
    fun `y is treated like a vowel at the end of a consonant cluster`() {
        assertEquals("ythmrhay", PigLatin.translate("rhythm"))
    }

    @Ignore
    @Test
    fun `y as second letter in two letter word`() {
        assertEquals("ymay", PigLatin.translate("my"))
    }

    @Ignore
    @Test
    fun `a whole phrase`() {
        assertEquals("ickquay astfay unray", PigLatin.translate("quick fast run"))
    }
}
