package com.cleanarchitecture.data.api

import com.cleanarchitecture.data.entities.DataProducts
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit interface to communicate with the API
 */
interface StoreApi {

    @GET("store/api/products/{productId}")
    fun getProducts(@Path("productId") productId: Int): Single<DataProducts>

    @GET("store/api/products/{productIds}")
    fun getProducts(@Path("productIds") productIds: String): Single<DataProducts>
}

