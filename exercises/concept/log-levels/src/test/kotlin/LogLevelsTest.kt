import kotlin.test.Test
import kotlin.test.assertEquals

class LogLevelsTest {
    @Test
    fun `error message`() {
        assertEquals("Stack overflow", message("[ERROR]: Stack overflow"))
    }

    @Test
    fun `warning message`() {
        assertEquals("Disk almost full", message("[WARNING]: Disk almost full"))
    }

    @Test
    fun `info message`() {
        assertEquals("File info", message("[INFO]: File info"))
    }

    @Test
    fun `warning message with leading and trailing whitespace`() {
        val logLine = """[WARNING]:     Timezone not set  
        """
        assertEquals("Timezone not set", message(logLine))
    }

    @Test
    fun `error log level`() {
        assertEquals("error", logLevel("[ERROR]: Stack overflow"))
    }

    @Test
    fun `warning log level`() {
        assertEquals("warning", logLevel("[WARNING]: Disk almost full"))
    }

    @Test
    fun `info log level`() {
        assertEquals("info", logLevel("[INFO]: File info"))
    }

    @Test
    fun `warning log level with leading and trailing whitespace`() {
        val logLine = """[WARNING]:     Timezone not set  
        """
        assertEquals("warning", logLevel(logLine))
    }

    @Test
    fun `reformat error log line`() {
        val expected = """
           |error@code:
           |  Segmentation fault
        """.trimMargin()
        assertEquals(expected, reformat("[ERROR]: Segmentation fault", "code"))
    }

    @Test
    fun `reformat warn log line`() {
        val expected = """
            |warn@CPU:
            |  High temperature
        """.trimMargin()
        assertEquals(expected, reformat("[WARN]: High temperature", "CPU"))
    }

    @Test
    fun `reformat info log line`() {
        val expected = """
            |info@disk:
            |  Disk defragmented
        """.trimMargin()
        assertEquals(expected, reformat("[INFO]: Disk defragmented", "disk"))
    }

    @Test
    fun `reformat a log line with multiple whitespace`() {
        val expected = """
            |notice@shell:
            |  Entered bad input too many times! 
            |
            |  This incident will be reported!
        """.trimMargin()
        val logLine = """
            |[NOTICE]:     Entered bad input too many times! 
            |
            |  This incident will be reported!               
                   
        """.trimMargin()
        assertEquals(expected, reformat(logLine, "shell"))
    }
}