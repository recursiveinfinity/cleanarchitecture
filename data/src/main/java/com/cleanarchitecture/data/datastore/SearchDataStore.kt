package com.cleanarchitecture.data.datastore

import com.cleanarchitecture.data.entities.DataSearchAsYouType
import com.cleanarchitecture.data.entities.DataSearchNavigation
import io.reactivex.Single

interface SearchDataStore {
    fun getNavigation(): Single<DataSearchNavigation>
    fun getAutocomplete(query: String, max_results: Int, beginning: Int): Single<List<String>>
    fun getSearchAsYouType(query: String): Single<DataSearchAsYouType>
}
