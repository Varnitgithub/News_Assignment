package com.example.newsassignment

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.newsassignment.models.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class repository @Inject constructor(var apiinterface: apiinterface) {

    var _livedata = MutableLiveData<Response<Model>>()

    fun getnews(newsType:String?) {

        CoroutineScope(Dispatchers.IO).launch {
            apiinterface.getdata(
                newsType?:"tesla",
                "2023-09-27",
                "publishedAt",
                "a469e6fe787d471192075ac490a11556"
            ).enqueue(object : Callback<Model?> {
                override fun onResponse(call: Call<Model?>, response: retrofit2.Response<Model?>) {
                    _livedata.postValue(Response.success(response.body()))
                }

                override fun onFailure(call: Call<Model?>, t: Throwable) {
                    _livedata.postValue(Response.error(t.message.toString()))

                }
            })
        }
    }

}

