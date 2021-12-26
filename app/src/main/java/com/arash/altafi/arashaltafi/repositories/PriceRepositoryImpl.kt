package com.arash.altafi.arashaltafi.repositories

import com.arash.altafi.arashaltafi.models.ResponsePrice
import com.arash.altafi.arashaltafi.sources.PriceDataSource
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PriceRepositoryImpl @Inject constructor(private val remotePrice: PriceDataSource) : PriceRepository {

    override fun getPrice(): Single<ResponsePrice> = remotePrice.getPrice()

}