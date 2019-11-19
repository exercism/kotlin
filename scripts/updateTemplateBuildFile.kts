#!/usr/bin/env kscript

import java.io.File

fun updateTemplate() {
    val versions = object {
        val kotlin = "1.3.60"
        val junit4 = "4.12"
    }

    File("_template").resolve("build.gradle.kts").writeText(
        """
        import org.gradle.api.tasks.testing.logging.TestExceptionFormat
        
        plugins {
            kotlin("jvm") version "${versions.kotlin}"
        }
        
        repositories {
            jcenter()
        }
        
        dependencies {
            compile(kotlin("stdlib"))
            
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
