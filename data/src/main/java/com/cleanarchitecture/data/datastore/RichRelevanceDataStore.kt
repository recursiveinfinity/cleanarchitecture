package com.cleanarchitecture.data.datastore

import com.richrelevance.recommendations.PlacementResponseInfo
import io.reactivex.Single

interface RichRelevanceDataStore {
    fun getPromotedProducts(): Single<PlacementResponseInfo>
}