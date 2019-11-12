#!/usr/bin/env kscript

/*
 * NOTE: To run this script you need to install kscript:
 *       https://github.com/holgerbrandl/kscript#installation
 */

/*
 * This scripts check all exercise directories and updates
 * gradle-related files using their prototypes from `_template`.
 */

import java.io.File

// --- Configuration ---

val templateDir = File("_template")
val filesToUpdate = listOf(
    "build.gradle.kts",
    "gradlew",
    "gradlew.bat",
    "settings.gradle.kts",
    "gradle/wrapper/gradle-wrapper.jar",
    "gradle/wrapper/gradle-wrapper.properties"
)

// --- /Configuration ---

/**
 * Find exercises directories.
 * They should contain gradle buildfile.
 */
fun findExerciseDirectories(): List<File> {
    fun File.containsGradleFiles() =
        resolve("build.gradle.kts").exists() || resolve("build.gradle").exists()

    return File("exercises")
        .listFiles()
        .filter(File::containsGradleFiles)
}

/**
 * Copy gradle files from template to exercise dir
 */
fun copyTemplateGradleFilesTo(exersiseDir: File) {
    val exerciseName = exersiseDir.name

    println("Processing `$exerciseName`...")
    filesToUpdate.forEach { subPath ->
        val source = templateDir.resolve(subPath)
        val destination = exersiseDir.resolve(subPath)

        println("\t${source.path} -> ${destination.path}")
        source.copyTo(destination, overwrite = true)
    }
}

// --- Script body

findExerciseDirectories()
    .forEach(::copyTemplateGradleFilesTo)
