plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    // For JSON (de)serialization of shared events/DTOs
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${rootProject.extra["jackson.version"]}")}

java.sourceCompatibility = JavaVersion.VERSION_17