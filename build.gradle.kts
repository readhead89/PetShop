plugins {
    kotlin("jvm") version "2.0.0"
    id("io.qameta.allure") version "2.8.1"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
}

// Переменные для dependencies
val junitVersion = "5.10.2"
val junitSuitVersion = "1.10.2"
val allureJunit5 = "2.8.1"
val selenide = "7.3.1"
val retrofit2Version = "2.9.0"
val logbackClassic = "1.4.12"
val slf4j = "1.7.32"

dependencies {
    implementation(kotlin("test"))
    implementation("io.qameta.allure:allure-junit5:$allureJunit5")
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-migrationsupport:$junitVersion")
    implementation("org.junit.platform:junit-platform-suite:$junitSuitVersion")
    implementation("org.junit.platform:junit-platform-suite-api:$junitSuitVersion")
    implementation("com.codeborne:selenide:$selenide")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
    // Logs
    implementation("ch.qos.logback:logback-classic:$logbackClassic")
    implementation("org.slf4j:slf4j-api:$slf4j")
}

tasks.test {
    useJUnitPlatform()
}
// Задача по удалению папки /build/allure-results
tasks.register<Delete>("cleanAllureResults") {
    delete("$projectDir/build/allure-results")
}

// Задача по удалению папки /build
tasks.register<Delete>("cleanBuildFolder") {
    delete("$projectDir/build")
}

kotlin {
    jvmToolchain(19)
}

allure {
    version = "2.25.0"
}