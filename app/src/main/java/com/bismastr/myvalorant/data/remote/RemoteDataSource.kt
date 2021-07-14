package com.bismastr.myvalorant.data.remote

import com.bismastr.myvalorant.data.remote.api.ApiResponse
import com.bismastr.myvalorant.data.remote.api.ApiValHendrik
import com.bismastr.myvalorant.data.remote.response.AllNewsResponse
import com.bismastr.myvalorant.data.remote.response.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import java.util.concurrent.Flow

class RemoteDataSource(private val apiValHendrik: ApiValHendrik) {

    suspend fun getAllNews(countryCode: String, filter: String): Flow<ApiResponse<ArrayList<DataItem>>> {
        return flow {
            try {
                val response = apiValHendrik.getAllNews(countryCode, filter)
                val responseArray = response.data as ArrayList<DataItem>
                if (responseArray.isNotEmpty()){
                    this.emit(ApiResponse.Success(response.data))
                } else {
                    this.emit(ApiResponse.Empty)
                }

            } catch (e: Exception){
                this.emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}