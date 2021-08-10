package com.bismastr.myvalorant.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leaderBoard_table")
data class LeaderboardEntity(
    @ColumnInfo(name = "competitiveTier")
    val competitiveTier: Int,
    @ColumnInfo(name = "numberOfWins")
    val numberOfWins: Int,
    @ColumnInfo(name = "isBanned")
    val isBanned: Boolean,
    @ColumnInfo(name = "gameName")
    val gameName: String,
    @ColumnInfo(name = "rankedRating")
    val rankedRating: Int,
    @ColumnInfo(name = "playerCardID")
    val playerCardID: String,
    @ColumnInfo(name = "leaderboardRank")
    val leaderboardRank: Int,
    @ColumnInfo(name = "tagLine")
    val tagLine: String,
    @ColumnInfo(name = "isAnonymized")
    val isAnonymized: Boolean,
    @PrimaryKey
    @ColumnInfo(name = "puuid")
    val puuid: String,
    @ColumnInfo(name = "tittleID")
    val titleID: String
)