package com.bismastr.myvalorant.data.local

import androidx.room.*
import androidx.room.Dao
import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity
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

    //leaderBoard
    @Query("SELECT * FROM leaderBoard_table")
    fun getLeaderboard(): Flow<List<LeaderboardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeaderboard(leaderBoard: List<LeaderboardEntity>)

    @Update(entity = LeaderboardEntity::class)
    suspend fun updateLeaderboard(leaderBoard: LeaderboardEntity)
}