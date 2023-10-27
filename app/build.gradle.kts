
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    //  id("com.apollographql.apollo3") version "3.8.2"


}

android {
    namespace = "com.example.newsassignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.varnittyagi.newsassignment"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String","BASE_URL","\" https://newsapi.org/v2/\"")
        }
        release {
            buildConfigField("String","BASE_URL","\" https://newsapi.org/v2/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        dataBinding = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}



dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    //implementation("com.apollographql.apollo3:apollo-runtime:3.8.2")
    implementation ("com.apollographql.apollo:apollo-runtime:2.5.6")
    implementation ("com.apollographql.apollo:apollo-android-support:2.5.6")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //cardview
    implementation ("androidx.cardview:cardview:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // Room components
    implementation("androidx.room:room-ktx:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")
    androidTestImplementation("androidx.room:room-testing:2.5.2")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.6.2")

    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.15.1")

    //constraint
    implementation ("androidx.constraintlayout:constraintlayout:2.1.2")

    //daggerhilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.appcompat:appcompat:1.6.1")

    //browser
    implementation ("androidx.browser:browser:1.4.0")

}
kapt {
    correctErrorTypes = true
}