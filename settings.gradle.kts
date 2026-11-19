pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://libraries.minecraft.net/") {
            content { includeGroup("com.mojang") }
        }
        maven("https://repo.codemc.org/repository/maven-public/")
        maven("https://repo.alessiodp.com/releases/")
        maven("https://repo.redlance.org/public")
        maven("https://maven.citizensnpcs.co/repo/")
        maven("https://mvn.lumine.io/repository/maven-public/")
        maven("https://repo.nexomc.com/releases/")
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/") {
            name = "central-snapshots"
            mavenContent { snapshotsOnly() }
        }
    }
}

rootProject.name = "bettermodel"

val modules = listOf("api", "api:bukkit-api", "core", "core:bukkit-core", "platform:paper")
include(modules)
include("nms:v26_R3")

modules.forEach { path ->
    project(":$path").apply {
        name = "${rootProject.name}-$name"
    }
}
