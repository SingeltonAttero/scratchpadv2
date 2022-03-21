plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.weber.scratchpadv2"
        compileSdk = ConfigData.compileSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        minSdk = ConfigData.minSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.Libs.compose
        }
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("com.android.tools:desugar_jdk_libs:1.1.5")

    // compose
    implementation("com.android.tools:desugar_jdk_libs:1.1.5")
    implementation("androidx.compose.ui:ui:${Versions.Libs.compose}")
    implementation("androidx.compose.material:material:${Versions.Libs.compose}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.Libs.compose}")
    implementation("androidx.navigation:navigation-compose:2.5.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    // DI
    implementation("com.google.dagger:hilt-android:2.38.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-compiler:2.38.1")
    // store
    implementation("androidx.datastore:datastore-core:1.0.0")
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("com.google.protobuf:protobuf-javalite:3.18.0")
    // datastore
    implementation("androidx.room:room-runtime:${Versions.Libs.Room}")
    implementation("androidx.room:room-ktx:${Versions.Libs.Room}")
    kapt("androidx.room:room-compiler:${Versions.Libs.Room}")
    // testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    // compose test
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.Libs.compose}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.Libs.compose}")
}
kapt {
    correctErrorTypes = true
}