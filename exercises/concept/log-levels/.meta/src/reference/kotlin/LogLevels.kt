fun message(logLine : String) : String {
    return logLine.substringAfter(":").trim()
}

fun logLevel(logLine : String) : String {
    return logLine.substringBefore(":").removeSurrounding("[", "]").lowercase()
}

fun reformat(logLine : String, location : String) : String {
    return """
        |${logLevel(logLine)}@$location:
        |  ${message(logLine)}
    """.trimMargin()
}