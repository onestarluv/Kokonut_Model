plugins {
    base
}

val paper = evaluationDependsOn(":platform:bettermodel-paper")
val paperJar = paper.tasks.named<Jar>("shadowJar")

val collectPaperPlugin = tasks.register<Copy>("collectPaperPlugin") {
    description = "Copies the Paper plugin jar to the Kokonut distribution directory."
    group = "build"
    from(paperJar.flatMap { it.archiveFile })
    into(providers.gradleProperty("deployDir").orElse("../plugin"))
}

tasks.build {
    dependsOn(collectPaperPlugin)
}
