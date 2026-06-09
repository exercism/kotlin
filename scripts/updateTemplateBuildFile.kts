#!/usr/bin/env kscript

import java.io.File

fun updateTemplate() {
    val versions = object {
        val kotlin = "1.6.0"
        val junit4 = "4.13.2"
    }

    File("_template").resolve("build.gradle.kts").writeText(
        """
        import org.gradle.api.tasks.testing.logging.TestExceptionFormat
        
        plugins {
            kotlin("jvm") version "2.4.0"
        }
        
        repositories {
            mavenCentral()
        }
        
        dependencies {
            testImplementation(kotlin("test"))
        }
        
        tasks.withType<Test> {
            testLogging {
                exceptionFormat = TestExceptionFormat.FULL
                events("passed", "failed", "skipped")
            }
        }

        """.trimIndent()
    )

    File("_template").resolve("settings.gradle.kts").writeText(
        """
        """.trimIndent()
    )
}

updateTemplate()
