package com.bismastr.myvalorant.di

import com.bismastr.myvalorant.data.remote.api.ApiValHendrik
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiValHendrik::class.java)
    }
}

val databaseModule = module {
//    factory { get<FilmDatabase>().Dao() }
//    single {
//        val passphrase: ByteArray = SQLiteDatabase.getBytes("movie_database".toCharArray())
//        val factory = SupportFactory(passphrase)
//        Room.databaseBuilder(
//            androidContext(),
//            FilmDatabase::class.java,
//            "movie_database"
//        ).fallbackToDestructiveMigration()
//            .openHelperFactory(factory)
//            .build()
//    }
}