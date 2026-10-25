plugins {
    kotlin("jvm") version "2.4.0"
}

repositories {
    mavenCentral()
}

project.subprojects {
    if (name == "concept" || name == "practice") {
        return@subprojects
    }

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
                    kotlin.setSrcDirs(listOf("build/generated/src/test/kotlin"))
                }
            }
        }

        tasks {
            val prepareTests = register<Copy>("prepareTests") {
                description = "Filter tests to remove @ignore"
                from(layout.projectDirectory.dir("src/test/kotlin")) {
                    filter {
                        line -> line.replace("""^\s*@Ignore""".toRegex(), "")
                    }
                }
                into(layout.buildDirectory.dir("generated/src/test/kotlin"))
            }

            compileTestKotlin {
                dependsOn(prepareTests)
            }
        }
    }
}
