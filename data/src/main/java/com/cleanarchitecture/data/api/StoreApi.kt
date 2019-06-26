package com.cleanarchitecture.data.api

import com.cleanarchitecture.data.entities.DataResults
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Retrofit interface to communicate with the API
 */
interface StoreApi {

    @GET("products")
    fun getNews(): Single<List<DataResults>>

}