package com.bismastr.myvalorant.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bismastr.myvalorant.data.Resource
import com.bismastr.myvalorant.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //viewmodel
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllNews()
        getLeaderboard()
    }

    fun getAllNews() {
        mainViewModel.getAllNews.observe(this, { News ->
            if (News != null) {
                when (News) {
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

    fun getLeaderboard(){
        mainViewModel.getLeaderboard.observe(this, { Leaderboard ->
            if (Leaderboard != null){
                when (Leaderboard){
                    is Resource.Loading -> Log.d("LEADERBOARD", "Loading!")
                    is Resource.Success -> {
                        val leaderboardArrayList = Leaderboard.data
                        Log.d("LEADERBOARD", "$leaderboardArrayList")
                    }
                    is Resource.Error -> Log.d("LEADERBOARD", "${Leaderboard.message}")
                }
            }
        })
    }


}