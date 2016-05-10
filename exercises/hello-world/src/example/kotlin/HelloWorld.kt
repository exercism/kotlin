fun hello(name: String?): String {
    val output = if (name == null || name.isEmpty()) "World" else name
    return "Hello, $output!"
}
