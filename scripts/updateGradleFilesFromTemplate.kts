#!/usr/bin/env kscript

import java.io.File

fun updateGradleFiles() {
    val exerciseDirs = File("exercises").listFiles()
        .filter { it.isDirectory }
        .flatMap { it.listFiles().filter { it.resolve("src/main/kotlin").exists() } }

    val filesToCopy = listOf(
        "build.gradle.kts",
        "settings.gradle.kts",
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

        dir.resolve("build.gradle")
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
