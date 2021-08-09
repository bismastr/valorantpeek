package com.bismastr.myvalorant.data.local

import com.bismastr.myvalorant.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: Dao) {
    fun getAllNews(): Flow<List<NewsEntity>> = dao.getAllNews()

    suspend fun insertNews(newsList: List<NewsEntity>) = dao.insertNews(newsList)
}