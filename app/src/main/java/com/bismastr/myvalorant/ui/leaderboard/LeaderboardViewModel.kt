package com.bismastr.myvalorant.ui.leaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bismastr.myvalorant.data.Repository

class LeaderboardViewModel(repository: Repository): ViewModel() {
    val getLeaderboard = repository.getLeaderboard().asLiveData()
}