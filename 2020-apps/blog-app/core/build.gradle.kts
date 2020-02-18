plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Enable data & view binding
    dataBinding.isEnabledForTests = true
    buildFeatures.dataBinding = true
    buildFeatures.viewBinding = true
}

dependencies {
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.61")

    // Theme
    api(project(":theming"))

    // Android
    api("androidx.core:core-ktx:1.2.0")
    api("androidx.appcompat:appcompat:1.1.0")
    api("androidx.legacy:legacy-support-v4:1.0.0")
    api("androidx.activity:activity-ktx:1.1.0")
    api("androidx.fragment:fragment-ktx:1.2.1")

    // Constraint Layout
    api("com.android.support.constraint:constraint-layout:2.0.0")

    // Navigation
    api("androidx.navigation:navigation-fragment-ktx:2.2.1")
    api("androidx.navigation:navigation-ui-ktx:2.2.1")
    api("androidx.navigation:navigation-runtime-ktx:2.2.1")

    // Material Components
    api("com.google.android.material:material:1.2.0-alpha04")

    // Lottie
    api("com.airbnb.android:lottie:3.3.1")

    // Anko
    api("org.jetbrains.anko:anko:0.10.8")

    // Glide
    api("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

    // Firebase
    api("com.google.firebase:firebase-analytics:17.2.2")
    api("com.google.firebase:firebase-auth:19.2.0")
    api("com.google.firebase:firebase-firestore-ktx:21.4.0")
    api("com.google.firebase:firebase-storage:19.1.1")

    // Room
    api("androidx.room:room-runtime:2.2.3")
    annotationProcessor("androidx.room:room-compiler:2.2.3")
    api("androidx.room:room-ktx:2.2.3")

    // Timber
    api("com.jakewharton.timber:timber:4.7.1")

    // Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")

    // Work Manager
    api("androidx.work:work-runtime-ktx:2.3.1")

    // Lifecycle
    annotationProcessor("androidx.lifecycle:lifecycle-common-java8:2.2.0")
    api("androidx.lifecycle:lifecycle-extensions:2.2.0")
    api("androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0")

    // Koin => Dependency Injection
    api("org.koin:koin-android:2.0.1")
    api("org.koin:koin-androidx-scope:2.0.1")
    api("org.koin:koin-androidx-viewmodel:2.0.1")

    // PhotoView
    api("com.github.chrisbanes:PhotoView:2.3.0")

    // Store
    api("com.dropbox.mobile.store:store4:4.0.0-alpha03")

    // Testing
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}