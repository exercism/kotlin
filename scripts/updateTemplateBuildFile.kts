#!/usr/bin/env kscript

import java.io.File

fun updateTemplate() {
    val versions = object {
        val junit4 = "4.13.2"
    }

    File("exercises/_template").resolve("build.gradle.kts").writeText(
        """
        import org.gradle.api.tasks.testing.logging.TestExceptionFormat
        
        plugins {
            kotlin("jvm")
        }
        
        repositories {
            mavenCentral()
        }
        
        dependencies {
            implementation(kotlin("stdlib-jdk8"))
            
            testImplementation("junit:junit:${versions.junit4}")
            testImplementation(kotlin("test-junit"))
        }
        
        tasks.withType<Test> {
            testLogging {
                exceptionFormat = TestExceptionFormat.FULL
                events("passed", "failed", "skipped")
            }
        }

        """.trimIndent()
    )
}

updateTemplate()
