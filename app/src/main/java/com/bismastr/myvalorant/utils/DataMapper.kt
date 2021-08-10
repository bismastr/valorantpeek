package com.bismastr.myvalorant.utils

import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity
import com.bismastr.myvalorant.data.local.entity.NewsEntity
import com.bismastr.myvalorant.data.remote.response.LeaderboardResponseItem
import com.bismastr.myvalorant.data.remote.response.NewsItem

object DataMapper {
    fun newsResponseToEntities(input: List<NewsItem>): List<NewsEntity>{
        val newsResult = ArrayList<NewsEntity>()
        input.map {
            val news = NewsEntity(
                date = it.date,
                bannerUrl = it.banner_url,
                category = it.category,
                title = it.title,
                url = it.url,
                externalLink = it.external_link
            )
            newsResult.add(news)
        }
        return newsResult
    }

    fun leaderboardResponseToEntities(input: List<LeaderboardResponseItem>): List<LeaderboardEntity> {
        val leaderboardResult = ArrayList<LeaderboardEntity>()
        input.map {
            val leaderboard = LeaderboardEntity(
                competitiveTier = it.competitiveTier,
                numberOfWins = it.numberOfWins,
                isBanned = it.isBanned,
                gameName = it.gameName,
                rankedRating = it.rankedRating,
                playerCardID = it.playerCardID,
                leaderboardRank = it.leaderboardRank,
                tagLine = it.tagLine,
                isAnonymized = it.isAnonymized,
                puuid = it.puuid,
                titleID = it.titleID
            )
            leaderboardResult.add(leaderboard)
        }
        return leaderboardResult
    }
}