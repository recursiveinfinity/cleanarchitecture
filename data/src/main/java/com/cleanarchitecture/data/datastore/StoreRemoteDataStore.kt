package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.api.StoreApi
import com.cleanarchitecture.data.entities.DataResults
import io.reactivex.Single

/**
 * An implementation of the AlbumDataStore interface, serves as the Remote Data Source
 * @param api - Retrofit service to retrieve data from the API
 */
class StoreRemoteDataStore constructor(private val api: StoreApi) : StoreDataStore {

    override fun getProductList(): Single<List<DataResults>> =
            api.getNews()

}