object Versions {

    object Tools {
        val android_gradle by lazy { "7.3.1" }
        val kotlin by lazy { "1.6.10" }
        val hilt by lazy { "2.38.1" }
    }


    object Libs {
        val core_ktx: String by lazy { "1.7.0" }
        val androidxAppCompat by lazy { "1.4.1" }
        val googleMaterial by lazy { "1.5.0" }
        val desugar_jdk_libs by lazy { "1.1.5" }

        // compose
        val compose by lazy { "1.1.1" }
        val navigationCompose by lazy { "2.5.3" }
        val lifecycleRuntime by lazy { "2.4.1" }
        val activityCompose by lazy { "1.4.0" }

        // DI
        val daggerHiltAndroid by lazy { "2.38.1" }
        val hiltNavigationCompose by lazy { "1.0.0" }

        // store
        val dataStore by lazy { "1.0.0" }
        val protobufProtobufJavalite by lazy { "3.18.0" }
        val Room by lazy { "2.4.1" }

        // test
        val junit4 by lazy { "4.13.2" }
        val junit5 by lazy { "5.8.2" }
        val testExtJunit by lazy { "1.1.3" }
        val espressoCore by lazy { "3.4.0" }
        val mockk by lazy { "1.13.3" }
        val coroutinesTest by lazy { "1.6.4" }
        val hamcrest: String by lazy { "2.2" }

        // json
        val kotlinxSerializationJson by lazy { "1.4.1" }

        // logs
        val timber by lazy { "5.0.1" }
    }

    object Plugins {
        val junitPlugin by lazy { "1.8.2.1" }
    }

}