#!/usr/bin/env kscript

import java.io.File

fun updateGradleFiles() {
    val exerciseDirs = File("exercises").listFiles()
        .filter { it.isDirectory }
        .filter { it.resolve("src/main/kotlin").exists() }
    //.filter { it.name == "hello-world" }

    val filesToCopy = listOf(
        "build.gradle.kts",
        "gradle/",
        "gradlew",
        "gradlew.bat"
    )

    val executables = listOf(
        "gradlew",
        "gradlew.bat"
    )

    exerciseDirs.forEach { dir ->
        println(dir.name)

        dir.resolve("buid.gradle")
            .takeIf { it.exists() }
            ?.delete()

        val templateDir = File("_template")

        filesToCopy.forEach { file ->
            val src = templateDir.resolve(file)
            val dest = dir.resolve(file)

            src.copyRecursively(dest, overwrite = true)

            if (file in executables) {
                dest.setExecutable(true)
            }
        }
    }
}

updateGradleFiles()
