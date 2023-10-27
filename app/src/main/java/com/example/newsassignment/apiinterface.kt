package com.example.newsassignment

import com.example.newsassignment.models.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface apiinterface {
//?limit=100
@GET("everything")
  fun getdata(@Query("q") query: String,
              @Query("from") fromDate: String,
              @Query("sortBy") sortBy: String,
              @Query("apiKey") apiKey: String ):Call<Model>
}