package com.cleanarchitecture.data.api

import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.data.entities.DataProduct
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Retrofit interface to communicate with the API
 */
interface ProductsApi {

    @GET("products")
    fun getNews(): Single<List<DataProduct>>

}