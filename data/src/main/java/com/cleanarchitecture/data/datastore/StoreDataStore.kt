package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.entities.DataProducts
import io.reactivex.Single

/**
 * Interface for AlbumDataStore - aka Data Source
 */

interface StoreDataStore {
    fun getProducts(productId: Int): Single<DataProducts>
    fun getProducts(productIds: String): Single<DataProducts>
}