import xyz.jpenilla.resourcefactory.bukkit.Permission
import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml

plugins {
    alias(libs.plugins.convention.plugin)
    alias(libs.plugins.resourcefactory.paper)
}

val pluginName = "Kokonut_Model"
val libraryDir: Provider<RegularFile> = layout.buildDirectory.file("generated/paper-library")
val dependenciesContent: String = libs.bundles.library.map { bundle ->
    bundle.joinToString("\n") { dep -> dep.toString() }
}.get()

dependencies {
    shade(project(":nms:v26_R3")) { isTransitive = false }
}

val generatePaperLibrary = tasks.register("generatePaperLibrary") {
    description = "Generates paper library info."
    val outputProvider = libraryDir
    val contentProvider = dependenciesContent

    outputs.file(outputProvider)

    doLast {
        val file = outputProvider.get().asFile
        file.parentFile.mkdirs()
        file.writeText(contentProvider)
    }
}

tasks.shadowJar {
    archiveBaseName.set(pluginName)
    archiveClassifier.set("")
    dependsOn(generatePaperLibrary)
    from(libraryDir)
    manifest {
        attributes["paperweight-mappings-namespace"] = "mojang"
    }
}

paperPluginYaml {
    main = "$group.paper.BetterModelPaper"
    loader = "$group.paper.BetterModelLoader"
    version = project.version.toString()
    this.name = pluginName
    foliaSupported = true
    apiVersion = providers.gradleProperty("minecraft_version").get()
    author = "toxicity188, pingpong"
    contributors = listOf("https://github.com/toxicity188/BetterModel/graphs/contributors")
    description = "에고버스 플러그인"
    website = "https://modrinth.com/plugin/bettermodel"
    dependencies {
        server(
            name = "MythicMobs",
            required = false,
            load = PaperPluginYaml.Load.BEFORE
        )
        server(
            name = "Citizens",
            required = false,
            load = PaperPluginYaml.Load.BEFORE
        )
        server(
            name = "SkinsRestorer",
            required = false,
            load = PaperPluginYaml.Load.BEFORE
        )
        server(
            name = "Nexo",
            required = false,
            load = PaperPluginYaml.Load.OMIT
        )
    }
    permissions.create("bettermodel") {
        default = Permission.Default.OP
        description = "Accesses to command."
        children = mapOf(
            "reload" to true,
            "spawn" to true,
            "disguise" to true,
            "undisguise" to true,
            "test" to true,
            "play" to true,
            "version" to true,
            "hide" to true,
            "show" to true
        )
    }
}
