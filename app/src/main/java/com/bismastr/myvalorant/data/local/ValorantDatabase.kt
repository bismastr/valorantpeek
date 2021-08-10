package com.bismastr.myvalorant.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity
import com.bismastr.myvalorant.data.local.entity.NewsEntity

@Database(
    entities =[NewsEntity::class, LeaderboardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ValorantDatabase: RoomDatabase() {
    abstract fun Dao(): Dao
}