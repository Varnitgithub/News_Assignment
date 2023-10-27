package com.example.newsassignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsassignment.models.Model

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class viewmodel @Inject constructor(var repository: repository):ViewModel() {

    var user: LiveData<Response<Model>> = repository._livedata


    fun getnews(newsType:String?) {
        repository.getnews(newsType)
    }
}

