import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    application
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

application {
    mainClassName = "uk.co.which.stephan.server.ServerKt"
}

group = "uk.co.which.stephan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.ktor:ktor-server-netty:1.1.1")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    shadowJar {
        // defaults to project.name
        //archiveBaseName.set("${project.name}-fat")

        // defaults to all, so removing this overrides the normal, non-fat jar
        archiveClassifier.set("")
    }
}