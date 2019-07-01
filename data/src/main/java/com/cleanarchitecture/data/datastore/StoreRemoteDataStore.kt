package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.api.StoreApi
import com.cleanarchitecture.data.entities.DataProducts
import io.reactivex.Single

/**
 * An implementation of the AlbumDataStore interface, serves as the Remote Data Source
 * @param api - Retrofit service to retrieve data from the API
 */
class StoreRemoteDataStore constructor(private val api: StoreApi) : StoreDataStore {

    override fun getProducts(productId: Int): Single<DataProducts> =
            api.getProducts(productId)

    override fun getProducts(productIds: String): Single<DataProducts> = api.getProducts(productIds)


}