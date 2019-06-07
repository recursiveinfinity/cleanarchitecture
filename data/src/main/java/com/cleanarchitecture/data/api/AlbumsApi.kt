package com.cleanarchitecture.data.api

import com.cleanarchitecture.data.entities.DataAlbum
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumsApi {

    @GET("albums")
    fun getNews(): Single<List<DataAlbum>>

}