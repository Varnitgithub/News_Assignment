package com.example.newsassignment

import android.app.Application
import com.apollographql.apollo.ApolloClient
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass():Application() {
    override fun onCreate() {
        super.onCreate()


    }
}