
import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class MatchingBracketsTest(val input: String, val expectedOutput: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: bracket({0})={1}")
        fun data() = listOf(
                arrayOf("[]", true),
                arrayOf("", true),
                arrayOf("[[", false),
                arrayOf("}{", false),
                arrayOf("{]", false),
                arrayOf("{ }", true),
                arrayOf("{[])", false),
                arrayOf("{[]}", true),
                arrayOf("{}[]", true),
                arrayOf("([{}({}[])])", true),
                arrayOf("{[)][]}", false),
                arrayOf("([{])", false),
                arrayOf("[({]})", false),
                arrayOf("{}[", false),
                arrayOf("[]]", false),
                arrayOf("(((185 + 223.85) * 15) - 543)/2", true),
                arrayOf("\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)", true)
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, MatchingBrackets.isValid(input))
    }

}
