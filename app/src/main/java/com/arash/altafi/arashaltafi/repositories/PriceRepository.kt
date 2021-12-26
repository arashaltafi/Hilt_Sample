package com.arash.altafi.arashaltafi.repositories

import com.arash.altafi.arashaltafi.models.ResponsePrice
import io.reactivex.Single

interface PriceRepository {

    fun getPrice() : Single<ResponsePrice>

}