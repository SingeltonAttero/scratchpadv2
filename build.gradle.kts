buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ToolsPlugins.android)
        classpath(ToolsPlugins.kotlin)
        classpath(ToolsPlugins.hilt)
    }
}
task("clean") {
    delete(rootProject.buildDir)
}