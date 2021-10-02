import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

project(":practice").subprojects {
    afterEvaluate {
        configurations {
            create("starterSourceCompile").extendsFrom(getByName("implementation"))
            create("starterSourceRuntime").extendsFrom(getByName("runtimeOnly"))

            create("exerciseTestsCompile").extendsFrom(getByName("testImplementation"))
            create("exerciseTestsRuntime").extendsFrom(getByName("testRuntimeOnly"))
        }

        kotlin {
            sourceSets {
                main {
                    kotlin.setSrcDirs(listOf(file(".meta/src/reference/kotlin")))
                }
                test {
                    kotlin.setSrcDirs(listOf("build/gen/test/kotlin"))
                }
                val starterSource by creating {
                    kotlin.setSrcDirs(listOf("src/main/kotlin"))
                }
                val exerciseTests by creating {
                    kotlin.setSrcDirs(listOf("src/test/kotlin"))
                }
            }
        }

        tasks {
            val copyTestsFilteringIgnores by creating(Copy::class) {
                from("src/test/kotlin")
                into("build/gen/test/kotlin")
                filter { line -> if (line.contains("@Ignore")) "" else line }
            }

            compileKotlin {
                doFirst {
                    println("  (source = ${source.asPath})")
                }
            }
            compileTestKotlin {
                dependsOn(copyTestsFilteringIgnores)

                doFirst {
                    println("  (test source = ${source.asPath})")
                }
            }

            /*val compileStarterSourceKotlin by existing(KotlinCompile::class) {
                println("  (source = ${source.asPath})")
            }*/

        }
    }
}
