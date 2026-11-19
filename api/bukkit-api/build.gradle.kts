plugins {
    alias(libs.plugins.convention.bukkit)
    `java-library`
}

dependencies {
    api(project(":bettermodel-api"))
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}
