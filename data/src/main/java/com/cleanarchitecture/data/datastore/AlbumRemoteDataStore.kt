package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.api.AlbumsApi
import com.cleanarchitecture.data.entities.DataAlbum
import io.reactivex.Single

class AlbumRemoteDataStore constructor(private val api: AlbumsApi) : AlbumDataStore {

    override fun getNews(): Single<List<DataAlbum>> =
            api.getNews()

}