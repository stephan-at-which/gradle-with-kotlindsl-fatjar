import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
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

    jar {
        manifest {
            attributes("Main-Class" to "uk.co.which.stephan.server.ServerKt")
        }

        from({
            val compileConfig = configurations.compile.get()
            logger.info("#files to iterate over: ${compileConfig.count()}")
            compileConfig.map { file ->
                {
                    logger.info("compileConfig.file: ${file.canonicalPath}")
                    if (file.isDirectory) file else zipTree(file)
                }
            }
        })
    }
}