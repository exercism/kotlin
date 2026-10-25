
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MatchingBracketsTest() {

    @Test
    fun `paired square bracket`() {
        assertTrue(MatchingBrackets.isValid("[]"))
    }

    @Ignore
    @Test
    fun `empty string`() {
        assertTrue(MatchingBrackets.isValid(""))
    }

    @Ignore
    @Test
    fun `unpaired brackets`() {
        assertFalse(MatchingBrackets.isValid("[["))
    }

    @Ignore
    @Test
    fun `wrong ordered brackets`() {
        assertFalse(MatchingBrackets.isValid("}{"))
    }

    @Ignore
    @Test
    fun `wrong closing brackets`() {
        assertFalse(MatchingBrackets.isValid("{]"))
    }

    @Ignore
    @Test
    fun `paired with whitespace`() {
        assertTrue(MatchingBrackets.isValid("{ }"))
    }

    @Ignore
    @Test
    fun `partially paired brackets`() {
        assertFalse(MatchingBrackets.isValid("{[])"))
    }

    @Ignore
    @Test
    fun `simple nested brackets`() {
        assertTrue(MatchingBrackets.isValid("{[]}"))
    }

    @Ignore
    @Test
    fun `several paired brackets`() {
        assertTrue(MatchingBrackets.isValid("{}[]"))
    }

    @Ignore
    @Test
    fun `paired and nested brackets`() {
        assertTrue(MatchingBrackets.isValid("([{}({}[])])"))
    }

    @Test
    fun `unopened closing brackets`() {
        assertFalse(MatchingBrackets.isValid("{[)][]}"))
    }

    @Test
    fun `unpaired and nested brackets`() {
        assertFalse(MatchingBrackets.isValid("([{])"))
    }

    @Ignore
    @Test
    fun `paired and wrong nested brackets`() {
        assertFalse(MatchingBrackets.isValid("[({]})"))
    }

    @Ignore
    @Test
    fun `paired and wrong nested brackets but innermost are correct`() {
        assertFalse(MatchingBrackets.isValid("[({}])"))
    }

    @Ignore
    @Test
    fun `paired and incomplete brackets`() {
        assertFalse(MatchingBrackets.isValid("{}["))
    }

    @Ignore
    @Test
    fun `too many closing brackets`() {
        assertFalse(MatchingBrackets.isValid("[]]"))
    }

    @Ignore
    @Test
    fun `early unexpected brackets`() {
        assertFalse(MatchingBrackets.isValid(")()"))
    }

    @Ignore
    @Test
    fun `early mismatched brackets`() {
        assertFalse(MatchingBrackets.isValid("{)()"))
    }

    @Ignore
    @Test
    fun `math expression`() {
        assertTrue(MatchingBrackets.isValid("(((185 + 223.85) * 15) - 543)/2"))
    }

    @Ignore
    @Test
    fun `complex latex expression`() {
        assertTrue(MatchingBrackets.isValid("\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)"))
    }
}
