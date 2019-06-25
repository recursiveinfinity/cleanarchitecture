package com.cleanarchitecture.data.api

import com.cleanarchitecture.data.entities.DataSearchAsYouType
import com.cleanarchitecture.data.entities.DataSearchNavigation
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 *  Our API handles only HTTP GET queries with parameters being passed using query string. We offer three endpoints:
Autocomplete – suggests how an input of a search term from customer might end
Search as you type (SAYT) – suggests products related to search term
Navigation – provides more complex search functionality which can be adjusted by multiple parameters passed in query string

General query structure:
First parameter in path specified client. Client can be currys, pcw or test.
Second parameter specifies functionality (if empty then SAYT is used). Possible values are <nothing>, autocomplete and navigation
 *
 *
 *
 */

interface SearchApi {

    @GET("currys/navigation")
    fun getNavigation(): Single<DataSearchNavigation>

    @GET("currys/autocomplete")
    fun getAutocomplete(
            @Query("query") query: String,
            @Query("max_results") max_results: Int,
            @Query("beginning") beginning: Int,
            @Query("callback") callback: String?): Single<List<String>>

    @GET("currys")
    fun getSearchAsYouType(@Query("query") query: String): Single<DataSearchAsYouType>

}