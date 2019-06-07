package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.entities.DataAlbum
import io.reactivex.Single

interface AlbumDataStore {
    fun getNews(): Single<List<DataAlbum>>
}