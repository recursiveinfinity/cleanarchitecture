package com.cleanarchitecture.data.api

import com.cleanarchitecture.data.entities.DataAlbum
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Retrofit interface to communicate with the API
 */
interface AlbumsApi {

    @GET("albums")
    fun getNews(): Single<List<DataAlbum>>

}