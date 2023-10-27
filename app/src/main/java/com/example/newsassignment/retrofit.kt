package com.example.newsassignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {

   private val retrofit by lazy {
        Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiinterfaceinstance by lazy {
        retrofit.create(apiinterface::class.java)
    }
}