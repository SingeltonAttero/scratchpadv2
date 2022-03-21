buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ToolsPlugins.android)
        classpath(ToolsPlugins.kotlin)
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath("com.android.tools.build:gradle:7.1.2")
    }
}
task("clean") {
    delete(rootProject.buildDir)
}