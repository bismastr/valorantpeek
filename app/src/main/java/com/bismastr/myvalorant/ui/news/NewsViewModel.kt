package com.bismastr.myvalorant.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bismastr.myvalorant.data.Repository

class NewsViewModel(repository: Repository) : ViewModel() {
    val getAllNews = repository.getAllNews().asLiveData()
}