plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = ConfigData.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "ru.bitc.webnet"
        compileSdk = ConfigData.COMPILE_SDK_VERSION
        targetSdk = ConfigData.TARGET_SDK_VERSION
        minSdk = ConfigData.MIN_SDK_VERSION

        versionCode = ConfigData.VERSION_CODE
        versionName = ConfigData.VERSION_NAME


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
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
    implementation(Libs.coreKtx)
    implementation(Libs.androidxAppCompat)
    implementation(Libs.googleMaterial)
    implementation(Libs.desugar_jdk_libs)

    // compose
    implementation(Libs.composeUI)
    implementation(Libs.composeMaterial)
    implementation(Libs.composeUIToolingPreview)
    implementation(Libs.navigationCompose)
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.activityCompose)
    // DI
    implementation(Libs.daggerHiltAndroid)
    implementation(Libs.hiltNavigationCompose)
    kapt(Libs.daggerHiltCompiler)
    // store
    implementation(Libs.dataStoreCore)
    implementation(Libs.dataStore)
    implementation(Libs.protobufProtobufJavalite)
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)
    // testing
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExtJunit)
    androidTestImplementation(Libs.espressoCore)
    // compose test
    androidTestImplementation(Libs.composeUITest)
    debugImplementation(Libs.composeUiTooling)
}

kapt {
    correctErrorTypes = true
}