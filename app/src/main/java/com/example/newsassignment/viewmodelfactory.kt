package com.example.newsassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class viewmodelfactory @Inject constructor(var repository: repository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewmodel(repository) as T
    }
}