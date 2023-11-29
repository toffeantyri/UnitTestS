plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.toffeantyri.unittests"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.toffeantyri.unittests"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }

    packaging {
        resources.merges.add("core.properties")

        resources.excludes.apply {
            add("META-INF/LICENSE")
            add("META-INF/*.properties")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
            add("META-INF/DEPENDENCIES")
            add("META-INF/LICENSE")
            add("META-INF/LICENSE.txt")
            add("META-INF/license.txt")
            add("META-INF/NOTICE")
            add("META-INF/NOTICE.txt")
            add("META-INF/notice.txt")
            add("META-INF/ASL2.0")
            add("META-INF/*.kotlin_module")
        }
    }


}

dependencies {

    val kotlin_version = "1.9.0"
    val room_version = "2.6.0"
    val dagger_hilt_android_version = "2.48"
    val retrofit_version = "2.9.0"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    implementation("androidx.core:core-ktx:$kotlin_version")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.10.0")

    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    //arch components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    //timber
    implementation("com.jakewharton.timber:timber:4.7.1")


    //room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version")

    //DI hilt
    implementation("com.google.dagger:hilt-android:$dagger_hilt_android_version")
    ksp("com.google.dagger:hilt-android-compiler:$dagger_hilt_android_version")

    //glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    ksp("com.github.bumptech.glide:compiler:4.11.0")

    //network
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")


    implementation("androidx.test:core:1.5.0")
    implementation("androidx.test:rules:1.5.0")

    testImplementation("android.arch.core:core-testing:1.1.1")
    androidTestImplementation("android.arch.core:core-testing:1.1.1")

    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("android.arch.core:core-testing:1.1.1")
    testImplementation("org.robolectric:robolectric:4.3.1")
    testImplementation("org.mockito:mockito-core:5.3.1")
    //testImplementation("com.linkedin.dexmaker:dexmaker-mockito:2.12.1")


    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    //default testing lib
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //lib for beauty vis tests
    testImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("com.google.truth:truth:1.0.1")


}