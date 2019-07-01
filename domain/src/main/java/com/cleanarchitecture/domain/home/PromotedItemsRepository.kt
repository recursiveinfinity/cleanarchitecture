package com.cleanarchitecture.domain.home

import io.reactivex.Single

interface PromotedItemsRepository {
    fun getPromotedItems(): Single<List<DomainPromotedItem>>
}