package com.arash.altafi.arashaltafi.api

import com.arash.altafi.arashaltafi.models.ResponsePrice
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("sana/json/index.html")
    fun getPrice() : Single<ResponsePrice>

}