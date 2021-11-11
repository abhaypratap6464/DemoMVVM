package dependencies

/**
 * contains all the dependencies used in application
 * @since 1.0.0
 * @author Abhay Pratap
 */
object Deps {

    const val dependency = "./gradleScript/dependencies.gradle"


    object ClassPaths {
        const val gradlePlugin = "com.android.tools.build:gradle:${Version.gradlePlugin}"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val navArgsPlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navArgs}"
    }

    object Plugins {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val parcelize = "kotlin-parcelize"
        const val kapt = "kotlin-kapt"
        const val safeargs = "androidx.navigation.safeargs.kotlin"
        const val crashlytics = "com.google.firebase.crashlytics"
        const val androidLibrary = "com.android.library"
    }

    object Configs {
        const val applicationId = "com.android.example.demomvvm"
        const val compileSdkVersion = 31
        const val minSdkVersion = 21
        const val targetSdkVersion = 31
        const val versionCode = 1
        const val versionName = "rc_1.0.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Test {
        const val testJunit = "junit:junit:${Version.junit}"
        const val androidXExtJunit =
            "androidx.test.ext:junit:${Version.ext_junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    }

    object Kotlin {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
        const val kotlinCoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutine}"
        const val kotlinCoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinCoroutine}"
        const val kotlinxSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Version.kotlinSerialization}"
    }

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
        const val appCompact = "androidx.appcompat:appcompat:${Version.appCompact}"
        const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val multidex="com.android.support:multidex:2.0.1"
    }

    object Lifecycle {
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleVersion}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycleVersion}"
    }

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Version.navArgs}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navArgs}"
    }


    object Koin {
        const val koinAndroid = "org.koin:koin-android:${Version.koin}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"
        const val koinScope = "org.koin:koin-androidx-scope:${Version.koin}"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Version.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
        const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit: ${Version.retrofit}"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
        const val kotlinCoroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Version.retrofitCoroutinesAdapter}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Version.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
        const val moshiAdapter = "com.squareup.moshi:moshi-adapters:${Version.moshi}"
    }

}
