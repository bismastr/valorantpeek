package com.bismastr.myvalorant.utils

import com.bismastr.myvalorant.data.local.entity.NewsEntity
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
}