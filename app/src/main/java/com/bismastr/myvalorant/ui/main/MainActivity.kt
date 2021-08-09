package com.bismastr.myvalorant.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bismastr.myvalorant.R
import com.bismastr.myvalorant.data.Resource
import com.bismastr.myvalorant.data.remote.response.NewsItem
import com.bismastr.myvalorant.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    //viewmodel
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        testViewModel()
    }

    fun testViewModel(){
        mainViewModel.getAllNews.observe(this, {News ->
            if(News != null){
                when(News){
                    is Resource.Loading -> Log.d("RESOURCE", "Loading!")
                    is Resource.Success -> {
                        val newsArrayList = News.data
                        Log.d("RESOURCE", "$newsArrayList")
                    }
                    is Resource.Error -> Log.d("RESOURCE", "${News.message}")
                }
            }
        })
    }


}