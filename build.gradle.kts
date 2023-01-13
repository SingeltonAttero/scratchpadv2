buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ToolsPlugins.android)
        classpath(ToolsPlugins.kotlin)
        classpath(ToolsPlugins.hilt)
        classpath(
            kotlin(
                ToolsPlugins.serialization.first,
                ToolsPlugins.serialization.second
            )
        )

    }
}
task("clean") {
    delete(rootProject.buildDir)
}