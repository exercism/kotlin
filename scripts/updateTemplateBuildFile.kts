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

    File("_template").resolve("settings.gradle.kts").writeText(
        """
        pluginManagement {
            repositories {
                mavenCentral()
                gradlePluginPortal()
            }
            resolutionStrategy {
                eachPlugin {
                    when (requested.id.id) {
                        "org.jetbrains.kotlin.jvm" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}")
                    }
                }
            }
        }

        """.trimIndent()
    )
}

updateTemplate()
