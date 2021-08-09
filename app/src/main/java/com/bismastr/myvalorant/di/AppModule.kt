package com.bismastr.myvalorant.di

import androidx.room.Room
import com.bismastr.myvalorant.data.Repository
import com.bismastr.myvalorant.data.local.LocalDataSource
import com.bismastr.myvalorant.data.local.ValorantDatabase
import com.bismastr.myvalorant.data.remote.RemoteDataSource
import com.bismastr.myvalorant.data.remote.api.ApiValHendrik
import com.bismastr.myvalorant.domain.IRepository
import com.bismastr.myvalorant.ui.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofitHenrikdev = Retrofit.Builder()
            .baseUrl("https://api.henrikdev.xyz/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitHenrikdev.create(ApiValHendrik::class.java)
    }

//    single {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://docs.henrikdev.xyz/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(get())
//            .build()
//    }
}



val databaseModule = module {
    factory { get<ValorantDatabase>().Dao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ValorantDatabase::class.java,
            "valorant_database"
        ).build()
    }
}
val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IRepository> { Repository(get(), get()) }
}

val viewModelModule = module {
    factory { Repository(get(), get()) }
    viewModel { MainViewModel(get()) }
}