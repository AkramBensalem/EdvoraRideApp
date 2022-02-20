plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")

    id("com.google.devtools.ksp")

}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "dz.akram.bensalem.edvorarideapp"
        minSdk = 24
        targetSdk= 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core
    implementation ("androidx.activity:activity-compose:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    //KSP
    implementation("com.google.devtools.ksp:symbol-processing-api:1.6.10-1.0.3")


    // For smooth startup (Nice Splash screen)
    implementation( "androidx.core:core-splashscreen:1.0.0-beta01")


    // Compose
    val composeVersion = "1.1.0"
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")

    // Compose Preview
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")

    // Compose Addition
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")


    // Compose ViewModel support
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")



    // Coil (Images, Videos, multimedia ...etc better that Picaso/Glide
    // Version "2.0.0-alpha09" is still alpha but it's faster X2 than version 1.4.0
    implementation("io.coil-kt:coil-compose:2.0.0-alpha09")


    //Logger better than the basic logger
    implementation("com.jakewharton.timber:timber:5.0.1")



    // Hilt Dagger for Dependency Injection
    implementation("com.google.dagger:hilt-android:2.40")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-android-compiler:2.40")



    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")


    // Accompanist
    val accompanist = "0.23.0"
    implementation("com.google.accompanist:accompanist-insets:${accompanist}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${accompanist}")
    implementation("com.google.accompanist:accompanist-swiperefresh:${accompanist}")
    implementation("com.google.accompanist:accompanist-insets-ui:${accompanist}")
    implementation("com.google.accompanist:accompanist-navigation-animation:${accompanist}")
  //  implementation("com.google.accompanist:accompanist-pager:${accompanist}")
 //   implementation("com.google.accompanist:accompanist-pager-indicators:${accompanist}")
 //   implementation("com.google.accompanist:accompanist-permissions:${accompanist}")



    // lyricist is internationalization/localization library for Jetpack Compose!
    // support (English, French, Hindu, Arabic ...etc)
    implementation("cafe.adriel.lyricist:lyricist:1.0.1")
    compileOnly("cafe.adriel.lyricist:lyricist-processor:1.0.1")
    ksp("cafe.adriel.lyricist:lyricist-processor:1.0.1")



    // Android Test
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeVersion")

    testImplementation ("junit:junit:4.13.2")

    // Debug UI
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")

}