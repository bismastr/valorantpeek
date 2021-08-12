package com.bismastr.myvalorant.data

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    companion object {
        lateinit var Error: Any
        lateinit var Success: Any
        lateinit var Loading: Any
    }

}