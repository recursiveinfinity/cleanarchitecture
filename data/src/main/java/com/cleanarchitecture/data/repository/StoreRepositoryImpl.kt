package com.cleanarchitecture.data.repository

import android.text.TextUtils
import com.cleanarchitecture.data.datastore.StoreRemoteDataStore
import com.cleanarchitecture.data.mappers.ProductMapper
import com.cleanarchitecture.domain.products.DomainProducts
import com.cleanarchitecture.domain.products.StoreRepository
import io.reactivex.Single

/**
 * Implementation of AlbumsRepository from domain layer
 * @param remote - A data store to retrieve data from a remote data source
 */
class StoreRepositoryImpl(private val remote: StoreRemoteDataStore) : StoreRepository {

    override fun getProducts(productId: List<String>): Single<DomainProducts> = remote.getProducts(TextUtils.join(",", productId))
            .map { productMapper.map(it) }

    private val productMapper = ProductMapper()

    override fun getProducts(productId: Int): Single<DomainProducts> = remote.getProducts(productId)
            .map { productMapper.map(it) }
}
