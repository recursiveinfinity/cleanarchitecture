package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.data.entities.DataProduct
import io.reactivex.Single

/**
 * Interface for AlbumDataStore - aka Data Source
 */

interface ProductDataStore {
    fun getNews(): Single<List<DataProduct>>
}