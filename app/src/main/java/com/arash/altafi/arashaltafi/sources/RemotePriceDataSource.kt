package com.arash.altafi.arashaltafi.sources

import com.arash.altafi.arashaltafi.api.ApiService
import com.arash.altafi.arashaltafi.models.ResponsePrice
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

class RemotePriceDataSource @Inject constructor(private val apiService: ApiService) : PriceDataSource {

    override fun getPrice(): Single<ResponsePrice> = apiService.getPrice()

}