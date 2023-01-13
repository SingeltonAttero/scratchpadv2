/**
 * To define tools plugins
 */
object ToolsPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.Tools.android_gradle}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Tools.kotlin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.Tools.hilt}" }
    val serialization = "serialization" to Versions.Tools.kotlin
}

object Plugin {
    val kotlinxSerialization by lazy { "kotlinx-serialization" }
    val junit5 by lazy { "de.mannodermaus.android-junit5" }
}

/**
 * To define dependencies
 */
object Libs {
    // core android
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.Libs.core_ktx}" }
    val androidxAppCompat by lazy { "androidx.appcompat:appcompat:${Versions.Libs.androidxAppCompat}" }
    val googleMaterial by lazy { "com.google.android.material:material:${Versions.Libs.googleMaterial}" }
    val desugar_jdk_libs by lazy { "com.android.tools:desugar_jdk_libs:${Versions.Libs.desugar_jdk_libs}" }

    // compose
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.Libs.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.Libs.compose}" }
    val composeUIToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.Libs.compose}" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.Libs.navigationCompose}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Libs.lifecycleRuntime}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.Libs.activityCompose}" }

    // DI
    val daggerHiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.Libs.daggerHiltAndroid}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.Libs.hiltNavigationCompose}" }
    val daggerHiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.Libs.daggerHiltAndroid}" }

    // store
    val dataStoreCore by lazy { "androidx.datastore:datastore-core:${Versions.Libs.dataStore}" }
    val dataStore by lazy { "androidx.datastore:datastore:${Versions.Libs.dataStore}" }
    val protobufProtobufJavalite by lazy { "com.google.protobuf:protobuf-javalite:${Versions.Libs.protobufProtobufJavalite}" }
    val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.Libs.Room}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.Libs.Room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.Libs.Room}" }

    // test
    val junit4 by lazy { "junit:junit:${Versions.Libs.junit4}" }
    val junit5Api by lazy { "org.junit.jupiter:junit-jupiter-api:${Versions.Libs.junit5}" }
    val junit5Engine by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.Libs.junit5}" } // testRuntimeOnly
    val junit5Params by lazy { "org.junit.jupiter:junit-jupiter-params:${Versions.Libs.junit5}" }
    val mockkAndroid by lazy { "io.mockk:mockk-android:${Versions.Libs.mockk}" }
    val mockkAgent by lazy { "io.mockk:mockk-agent:${Versions.Libs.mockk}" }
    val coroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Libs.coroutinesTest}" }
    val hamcrest by lazy { "org.hamcrest:hamcrest:${Versions.Libs.hamcrest}" }

    val testExtJunit by lazy { "androidx.test.ext:junit:${Versions.Libs.testExtJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.Libs.testExtJunit}" }
    val composeUITest by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.Libs.compose}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.Libs.compose}" }

    // json
    val kotlinxSerializationJson by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Libs.kotlinxSerializationJson}" }

    // logs
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.Libs.timber}" }
}