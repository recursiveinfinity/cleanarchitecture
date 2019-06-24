package com.cleanarchitecture.domain.searchnavigation


import io.reactivex.Single

interface SearchRepository {
    fun getNavigation(): Single<DomainSearchNavigation>
    fun getAutocomplete(query: String, max_results: Int, beginning: Int): Single<List<String>>
    fun getSearchAsYouType(query: String): Single<DomainSearchAsYouType>
}