package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.api.AlbumsApi
import com.cleanarchitecture.data.api.ProductsApi
import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.data.entities.DataProduct
import io.reactivex.Single

/**
 * An implementation of the AlbumDataStore interface, serves as the Remote Data Source
 * @param api - Retrofit service to retrieve data from the API
 */
class ProductRemoteDataStore constructor(private val api: ProductsApi) : ProductDataStore {

    override fun getNews(): Single<List<DataProduct>> =
            api.getNews()

}