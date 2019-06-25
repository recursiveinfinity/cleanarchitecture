package com.cleanarchitecture.data.repository

import com.cleanarchitecture.data.datastore.ProductRemoteDataStore
import com.cleanarchitecture.data.entities.DataResults
import com.cleanarchitecture.data.mappers.SearchNavigationMapper
//import com.cleanarchitecture.data.mappers.ProductMapper
//import com.cleanarchitecture.domain.albums.Domainproduct
import com.cleanarchitecture.domain.albums.ProductsRepository
import com.cleanarchitecture.domain.searchnavigation.DomainResults
import io.reactivex.Single

/**
 * Implementation of AlbumsRepository from domain layer
 * @param remote - A data store to retrieve data from a remote data source
 */
class ProductsRepositoryImpl(private val remote: ProductRemoteDataStore) : ProductsRepository {

    private val productMapper = SearchNavigationMapper()

    /**
     * @return Single<List<DomainAlbum>> - converts Single<List<Albums> retrieved from the API to
     * List<DomainAlbum>> by utilising the mapper
     */
    override fun getProducts(): Single<List<DomainResults>> = remote.getProductList()
            .map { productMapper.(it) }



}
