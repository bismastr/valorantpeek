package com.bismastr.myvalorant.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bismastr.myvalorant.data.Repository

class MainViewModel(repository: Repository): ViewModel() {
    val getAllNews = repository.getAllNews().asLiveData()
}