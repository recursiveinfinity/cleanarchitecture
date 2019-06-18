package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.api.AlbumsApi
import com.cleanarchitecture.data.entities.DataAlbum
import io.reactivex.Single

/**
 * An implementation of the AlbumDataStore interface, serves as the Remote Data Source
 * @param api - Retrofit service to retrieve data from the API
 */
class AlbumRemoteDataStore constructor(private val api: AlbumsApi) : AlbumDataStore {

    override fun getNews(): Single<List<DataAlbum>> =
            api.getNews()

}