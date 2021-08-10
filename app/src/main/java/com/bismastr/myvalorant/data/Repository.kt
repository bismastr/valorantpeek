package com.bismastr.myvalorant.data

import android.util.Log
import com.bismastr.myvalorant.data.local.LocalDataSource
import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity
import com.bismastr.myvalorant.data.local.entity.NewsEntity
import com.bismastr.myvalorant.data.remote.RemoteDataSource
import com.bismastr.myvalorant.data.remote.api.ApiResponse
import com.bismastr.myvalorant.data.remote.response.LeaderboardResponseItem
import com.bismastr.myvalorant.data.remote.response.NewsItem
import com.bismastr.myvalorant.domain.IRepository
import com.bismastr.myvalorant.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class Repository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): IRepository {
    override fun getAllNews(): Flow<Resource<List<NewsEntity>>> =
        object : NetworkBoundResource<List<NewsEntity>, List<NewsItem>>(){
            override fun loadFromDB(): Flow<List<NewsEntity>> {
                return localDataSource.getAllNews()
            }

            override fun shouldFetch(data: List<NewsEntity>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<NewsItem>>> {
                return remoteDataSource.getAllNews("en-us", "dev") //Mending di isi di viewmodel
            }

            override suspend fun saveCallResult(data: List<NewsItem>) {
                val newsEntity = DataMapper.newsResponseToEntities(data)
                Log.d("DATA", "$newsEntity")
                localDataSource.insertNews(newsEntity)
            }

        }.asFlow()

    override fun getLeaderboard(): Flow<Resource<List<LeaderboardEntity>>> =
        object : NetworkBoundResource<List<LeaderboardEntity>, List<LeaderboardResponseItem>>() {
            override fun loadFromDB(): Flow<List<LeaderboardEntity>> {
                return localDataSource.getLeaderboard()
            }

            override fun shouldFetch(data: List<LeaderboardEntity>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<LeaderboardResponseItem>>> {
                return remoteDataSource.getLeaderboard("ap") //Mending di isi di viewmodel
            }

            override suspend fun saveCallResult(data: List<LeaderboardResponseItem>) {
                val leaderboardEntity = DataMapper.leaderboardResponseToEntities(data)
                localDataSource.insertLeaderboard(leaderboardEntity)
            }

        }.asFlow()
}