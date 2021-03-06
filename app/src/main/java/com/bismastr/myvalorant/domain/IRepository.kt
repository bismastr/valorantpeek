package com.bismastr.myvalorant.domain

import com.bismastr.myvalorant.data.Resource
import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity
import com.bismastr.myvalorant.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getAllNews(): Flow<Resource<List<NewsEntity>>>
    fun getLeaderboard(): Flow<Resource<List<LeaderboardEntity>>>
    fun updateLeaderboard(): Flow<Resource<LeaderboardEntity>>
}