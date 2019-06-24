package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.api.SearchApi
import com.cleanarchitecture.data.entities.DataSearchAsYouType
import com.cleanarchitecture.data.entities.DataSearchNavigation
import io.reactivex.Single

class SearchRemoteDataStore constructor(private val api: SearchApi) : SearchDataStore {

    override fun getSearchAsYouType(query: String): Single<DataSearchAsYouType> = api.getSearchAsYouType(query)

    override fun getNavigation(): Single<DataSearchNavigation> =
            api.getNavigation()

    override fun getAutocomplete(query: String, max_results: Int, beginning: Int): Single<List<String>> = api.getAutocomplete(
            query = query,
            max_results = max_results,
            beginning = beginning,
            callback = null
    )
}