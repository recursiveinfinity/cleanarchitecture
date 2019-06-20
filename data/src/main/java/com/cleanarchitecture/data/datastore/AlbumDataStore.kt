package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.entities.DataAlbum
import io.reactivex.Single

/**
 * Interface for AlbumDataStore - aka Data Source
 */

interface AlbumDataStore {
    fun getNews(): Single<List<DataAlbum>>
}