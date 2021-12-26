package com.arash.altafi.arashaltafi.sources

import com.arash.altafi.arashaltafi.models.ResponsePrice
import io.reactivex.Single

interface PriceDataSource {

    fun getPrice() : Single<ResponsePrice>

}