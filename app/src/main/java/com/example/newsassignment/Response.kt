package com.example.newsassignment

import android.content.Context

sealed class Response<T>( var data:T?=null,var errormessage:String?=null) {

    class loading<T>():Response<T>()
    class success<T>(response:T?=null):Response<T>(data = response)
    class error<T>(error:String):Response<T>(errormessage= error)


}