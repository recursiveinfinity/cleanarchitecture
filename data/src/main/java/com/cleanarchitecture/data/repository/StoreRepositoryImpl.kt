package com.cleanarchitecture.data.repository

import com.cleanarchitecture.data.datastore.StoreRemoteDataStore
import com.cleanarchitecture.data.mappers.SearchNavigationMapper
import com.cleanarchitecture.domain.albums.StoreRepository

/**
 * Implementation of AlbumsRepository from domain layer
 * @param remote - A data store to retrieve data from a remote data source
 */
class StoreRepositoryImpl(private val remote: StoreRemoteDataStore) : StoreRepository {

    private val productMapper = SearchNavigationMapper()

}
