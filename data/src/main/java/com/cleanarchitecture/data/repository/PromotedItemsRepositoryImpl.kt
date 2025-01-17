package com.cleanarchitecture.data.repository

import com.cleanarchitecture.data.datastore.RichRelevanceRemoteDataStore
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.home.DomainPromotedItem
import com.cleanarchitecture.domain.home.PromotedItemsRepository
import com.richrelevance.recommendations.RecommendedProduct

class PromotedItemsRepositoryImpl(private val remoteDataStore: RichRelevanceRemoteDataStore,
                                  private val promotedItemMapper
                                  : Mapper<RecommendedProduct, DomainPromotedItem>)
    : PromotedItemsRepository {

    override fun getPromotedItems() = remoteDataStore.getPromotedProducts()
            .map { promotedItemMapper.mapList(it.placements.first().recommendedProducts) }
}