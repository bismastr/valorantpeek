package com.bismastr.myvalorant.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bismastr.myvalorant.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface Dao {
    //ApiValHendrik
    //News
    @Query("SELECT * FROM news_table")
    fun getAllNews(): Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsEntity>)
}