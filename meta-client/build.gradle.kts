plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js(IR) {
        moduleName = "meta-client"
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":a-client"))
                implementation(project(":b-client"))
                implementation(project(":common-client"))
            }
        }
    }
}
