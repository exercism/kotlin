import org.junit.Test
import org.junit.Ignore
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Enclosed::class)
class AtbashTest {

    @RunWith(Parameterized::class)
    class EncodeTest(val input: String, val expectedOutput: String) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun data() = listOf(
                    arrayOf("yes", "bvh"),
                    arrayOf("no", "ml"),
                    arrayOf("OMG", "lnt"),
                    arrayOf("O M G", "lnt"),
                    arrayOf("mindblowingly", "nrmwy oldrm tob"),
                    arrayOf("Testing,1 2 3, testing.", "gvhgr mt123 gvhgr mt"),
                    arrayOf("Truth is fiction.", "gifgs rhurx grlm"),
                    arrayOf("The quick brown fox jumps over the lazy dog.", "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt")
            )
        }

        @Test
        fun test() {
            assertEquals(expectedOutput, Atbash.encode(input))
        }

    }

    @RunWith(Parameterized::class)
    class DecodeTest(val input: String, val expectedOutput: String) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun data() = listOf(
                    arrayOf("vcvix rhn", "exercism"),
                    arrayOf("zmlyh gzxov rhlug vmzhg vkkrm thglm v", "anobstacleisoftenasteppingstone"),
                    arrayOf("gvhgr mt123 gvhgr mt", "testing123testing")
            )
        }

        @Ignore
        @Test
        fun test() {
            assertEquals(expectedOutput, Atbash.decode(input))
        }

    }

}
