plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}
dependencies {
    implementation(project(":common_utils"))
    implementation(libs.jetbrains.kotlinx.coroutines.core)
    testImplementation(libs.junit)

    // Mockk Dependencies
    testImplementation(libs.mockk)
    testImplementation(libs.mockk.agent)
}
