package com.arash.altafi.arashaltafi.modules

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.arashaltafi.adapters.MainAdapter
import com.arash.altafi.arashaltafi.adapters.PriceHolder
import com.arash.altafi.arashaltafi.api.ApiService
import com.arash.altafi.arashaltafi.models.DataItem
import com.arash.altafi.arashaltafi.models.ResponsePrice
import com.arash.altafi.arashaltafi.models.Sana
import com.arash.altafi.arashaltafi.repositories.PriceRepository
import com.arash.altafi.arashaltafi.repositories.PriceRepositoryImpl
import com.arash.altafi.arashaltafi.sources.PriceDataSource
import com.arash.altafi.arashaltafi.sources.RemotePriceDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.accessban.com/v1/data/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit : Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideRemoteData(apiService: ApiService) : PriceDataSource {
        return RemotePriceDataSource(apiService)
    }

    @Singleton
    @Provides
    fun providePriceRepo(remotePrice: PriceDataSource) : PriceRepository {
        return PriceRepositoryImpl(remotePrice)
    }

}