package com.bismastr.myvalorant.data.remote

import com.bismastr.myvalorant.data.remote.api.ApiResponse
import com.bismastr.myvalorant.data.remote.api.ApiValHendrik
import com.bismastr.myvalorant.data.remote.response.CurrentData
import com.bismastr.myvalorant.data.remote.response.NewsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiValHendrik: ApiValHendrik) {

    suspend fun getAllNews(
        countryCode: String,
        filter: String
    ): Flow<ApiResponse<ArrayList<NewsItem>>> {
        return flow {
            try {
                val response = apiValHendrik.getAllNews(countryCode, filter)
                val responseArray = response.data as ArrayList<NewsItem>
                if (responseArray.isNotEmpty()) {
                    this.emit(ApiResponse.Success(response.data))
                } else {
                    this.emit(ApiResponse.Empty)
                }

            } catch (e: Exception) {
                this.emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getUserMmr(
        username: String,
        tag: String,
        filter: String
    ): Flow<ApiResponse<CurrentData>> {
        return flow {
            try {
                val response = apiValHendrik.getUserMmr(username, tag, filter)
                val responseData = response.data?.currentData
                if (responseData != null) {
                    this.emit(ApiResponse.Success(responseData))
                } else {
                    this.emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                this.emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}