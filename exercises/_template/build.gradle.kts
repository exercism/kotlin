import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    
    testImplementation("junit:junit:4.13.2")
    testImplementation(kotlin("test-junit"))
}

tasks.withType<Test> {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}
