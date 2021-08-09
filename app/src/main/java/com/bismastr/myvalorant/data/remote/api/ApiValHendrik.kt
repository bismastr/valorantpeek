package com.bismastr.myvalorant.data.remote.api

import com.bismastr.myvalorant.data.remote.response.AllNewsResponse
import com.bismastr.myvalorant.data.remote.response.UserMmrResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiValHendrik {
    companion object {
//        const val KEY
    }

    //news
    @GET("valorant/v1/website/{country-code}")
    suspend fun getAllNews(
        @Path("country-code") countryCode: String,
        @Query("filter") filter: String, //Filter Available: game_updates, dev, esports, announcments
    ): AllNewsResponse

    @GET("/valorant/v2/mmr/ap/{username}/{tag}")
    suspend fun getUserMmr(
        @Path("username") username: String,
        @Path("tag") tag: String,
        @Query("filter") filter: String
    ): UserMmrResponse //Filter available: e2a2, e2a1, e1a3, e1a2, e1a1

}