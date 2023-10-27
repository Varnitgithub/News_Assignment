
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.google.gms:google-services:4.2.0")
        classpath ("com.android.tools.build:gradle:8.1.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21") // Update Kotlin version to 1.5.21
    }
}


plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

//// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    repositories {
//        google()
//        jcenter()
//    }
//    dependencies {
//        classpath ("com.android.tools.build:gradle:8.1.0")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21") // Update Kotlin version to 1.5.21
//    }
//}
//
//@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
//plugins {
//    alias(libs.plugins.androidApplication) apply false
//    alias(libs.plugins.kotlinAndroid) apply false
//    id("com.google.dagger.hilt.android") version "2.44" apply false
//}
//true // Needed to make the Suppress annotation work for the plugins block