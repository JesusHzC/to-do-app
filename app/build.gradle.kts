plugins {
    id ("com.android.application")
    kotlin ("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

val versions = rootProject.extra

@Suppress ("UnstableApiUsage")
android {
    namespace = "com.github.jesushzc.todoapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.github.jesushzc.todoapplication"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
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
    composeOptions {
        kotlinCompilerExtensionVersion = versions.get("compose_ui_version") as String
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:${versions.get("compose_ui_version")}")
    implementation("androidx.compose.ui:ui-tooling-preview:${versions.get("compose_ui_version")}")
    implementation("androidx.compose.material:material:1.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${versions.get("compose_ui_version")}")
    debugImplementation("androidx.compose.ui:ui-tooling:${versions.get("compose_ui_version")}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${versions.get("compose_ui_version")}")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:${versions.get("dagger_hilt_version")}")
    kapt("com.google.dagger:hilt-android-compiler:${versions.get("dagger_hilt_version")}")

    //Dagger Hilt Navigation
    implementation("androidx.hilt:hilt-navigation-compose:${versions.get("hilt_navigation_version")}")

    //Navigation
    implementation("androidx.navigation:navigation-compose:${versions.get("navigation_version")}")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:${versions.get("retrofit_version")}")
    implementation("com.squareup.retrofit2:converter-gson:${versions.get("retrofit_version")}")

    //OkHttp
    implementation("com.squareup.okhttp3:okhttp:${versions.get("okhttp_version")}")
    implementation("com.squareup.okhttp3:logging-interceptor:${versions.get("okhttp_version")}")

    //Room
    implementation("androidx.room:room-runtime:${versions.get("room_version")}")
    implementation("androidx.room:room-ktx:${versions.get("room_version")}")
    kapt("androidx.room:room-compiler:${versions.get("room_version")}")
}

kapt {
    correctErrorTypes = true
}