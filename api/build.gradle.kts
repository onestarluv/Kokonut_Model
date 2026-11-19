plugins {
    alias(libs.plugins.convention.standard)
    `java-library`
}

dependencies {
    api(libs.bundles.library) {
        exclude(module = "jspecify")
    }
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    compileOnly(libs.bundles.minecraft)
    testImplementation(libs.bundles.minecraft)
}
