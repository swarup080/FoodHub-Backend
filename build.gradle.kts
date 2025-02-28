plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    application
}

group = "com.swarup.foodhab"
version = "0.0.1"

application {
    mainClass.set("com.swarup.foodhab.ApplicationKt")

    val isDevelopment: Boolean = project.hasProperty("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    implementation("org.ktorm:ktorm-core:4.1.1")
    implementation("com.mysql:mysql-connector-j:9.2.0")
}

// Create Fat JAR (Shadow JAR)
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.swarup.foodhab.ApplicationKt"
    }
}
