package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.data.entities.DataProduct
import com.cleanarchitecture.data.entities.DataResults
import io.reactivex.Single

/**
 * Interface for AlbumDataStore - aka Data Source
 */

interface StoreDataStore {
    fun getProductList(): Single<List<DataResults>>
}