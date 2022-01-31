group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    (id("com.github.node-gradle.node") version "3.1.1").apply(false)
    (kotlin("multiplatform") version "1.6.10").apply(false)
    (kotlin("plugin.serialization") version "1.6.10").apply(false)
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}
