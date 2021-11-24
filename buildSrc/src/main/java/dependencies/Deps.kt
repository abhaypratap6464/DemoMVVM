package dependencies

import dependencies.Version.espressoVersion

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
        const val applicationId = "com.android.example.demoMvvM"
        const val compileSdkVersion = 31
        const val minSdkVersion = 21
        const val targetSdkVersion = 31
        const val versionCode = 1
        const val versionName = "rc_1.0.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        const val multidexSupport = "com.android.support:multidex:2.0.1"
        const val multidex = "androidx.multidex:multidex:2.0.1"
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
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Version.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
        const val moshiAdapter = "com.squareup.moshi:moshi-adapters:${Version.moshi}"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
    }

    object SwipeRefreshLayout {
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipeRefreshLayout}"
    }

    object LocalUnitTest {
        const val junit = "junit:junit:${Version.junit}"
        const val hamcrest = "org.hamcrest:hamcrest-all:${Version.hamcrest}"
        const val coreTesting = "androidx.arch.core:core-testing:${Version.coreTesting}"
        const val kotlinxCoroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinxCoroutinesTest}"
        const val robolectric = "org.robolectric:robolectric:${Version.robolectric}"
        const val googleTruth = "com.google.truth:truth:${Version.googleTruth}"
        const val mockito = "org.mockito:mockito-core:${Version.mockito}"
    }


    object JVMTesting {
        const val testCore = "androidx.test:core-ktx:${Version.testCore}"
        const val testExt = "androidx.test.ext:junit-ktx:${Version.testExt}"
        const val testRule = "androidx.test:rules:${Version.testCore}"
        const val testKoin = "org.koin:koin-test:${Version.koin}"
    }

    object InstrumentedTesting {
        const val roomTesting = "androidx.room:room-testing:${Version.room}"
        const val robolectricAnnotations = "org.robolectric:annotations:${Version.robolectric}"
        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
        const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"
        const val espressoIntents = "androidx.test.espresso:espresso-intents:$espressoVersion"
        const val idlingConcurrent =
            "androidx.test.espresso.idling:idling-concurrent:$espressoVersion"
        const val fragmentTesting = "androidx.fragment:fragment-testing:${Version.fragmentTesting}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragmentTesting}"
        const val dexmakerMockito =
            "com.linkedin.dexmaker:dexmaker-mockito:${Version.dexmakerMockito}"
        const val testCore = "androidx.test:core:${Version.testCore}"
    }

    object Pagination {
        const val pagination = "androidx.paging:paging-runtime:${Version.pagination}"
    }


}
