plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.11.1")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}