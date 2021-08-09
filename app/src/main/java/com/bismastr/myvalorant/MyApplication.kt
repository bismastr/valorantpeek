package com.bismastr.myvalorant

import android.app.Application
import com.bismastr.myvalorant.di.databaseModule
import com.bismastr.myvalorant.di.networkModule
import com.bismastr.myvalorant.di.repositoryModule
import com.bismastr.myvalorant.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}