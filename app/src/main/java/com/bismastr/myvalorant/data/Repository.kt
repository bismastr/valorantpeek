package com.bismastr.myvalorant.data

import android.util.Log
import com.bismastr.myvalorant.data.local.LocalDataSource
import com.bismastr.myvalorant.data.local.entity.NewsEntity
import com.bismastr.myvalorant.data.remote.RemoteDataSource
import com.bismastr.myvalorant.data.remote.api.ApiResponse
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
                return remoteDataSource.getAllNews("en-us", "dev")
            }

            override suspend fun saveCallResult(data: List<NewsItem>) {
                val newsEntity = DataMapper.newsResponseToEntities(data)
                Log.d("DATA", "$newsEntity")
                localDataSource.insertNews(newsEntity)
            }

        }.asFlow()
}