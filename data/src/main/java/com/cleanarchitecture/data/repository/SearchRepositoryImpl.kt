package com.cleanarchitecture.data.repository

import com.cleanarchitecture.data.datastore.SearchRemoteDataStore
import com.cleanarchitecture.data.mappers.SearchAsYouTypeMapper
import com.cleanarchitecture.data.mappers.SearchNavigationMapper
import com.cleanarchitecture.domain.searchnavigation.DomainSearchAsYouType
import com.cleanarchitecture.domain.searchnavigation.DomainSearchNavigation
import com.cleanarchitecture.domain.searchnavigation.SearchRepository
import io.reactivex.Single

class SearchRepositoryImpl(private val remote: SearchRemoteDataStore) : SearchRepository {

    private val searchNavigationMapper = SearchNavigationMapper()
    private val searchAsYouTypeMapper = SearchAsYouTypeMapper()

    override fun getNavigation(): Single<DomainSearchNavigation> = remote.getNavigation()
            .map { searchNavigationMapper.toDomain(it) }

    override fun getAutocomplete(query: String, max_results: Int, beginning: Int): Single<List<String>> =
            remote.getAutocomplete(query, max_results, beginning)

    override fun getSearchAsYouType(query: String): Single<DomainSearchAsYouType> = remote.getSearchAsYouType(query)
            .map { searchAsYouTypeMapper.toDomain(it) }

}

