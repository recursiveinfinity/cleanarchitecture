package com.cleanarchitecture.data.datastore

import com.richrelevance.Callback
import com.richrelevance.RichRelevance
import com.richrelevance.recommendations.Placement
import com.richrelevance.recommendations.PlacementResponseInfo
import io.reactivex.Single

class RichRelevanceRemoteDataStore : RichRelevanceDataStore {

    override fun getPromotedProducts(): Single<PlacementResponseInfo> {
        val placement = Placement(Placement.PlacementType.ADD_TO_CART, "prod1")
        return Single.create { emitter ->
            RichRelevance.buildRecommendationsForPlacements(placement)
                    .setCallback(object : Callback<PlacementResponseInfo> {
                        override fun onError(error: com.richrelevance.Error) {
                            emitter.onError(Exception(error.message))
                        }

                        override fun onResult(result: PlacementResponseInfo) {
                            emitter.onSuccess(result)
                        }
                    })
                    .execute()
        }
    }
}