package com.cleanarchitecture.domain.home

import com.cleanarchitecture.domain.common.SingleNoParamsUseCase
import com.cleanarchitecture.domain.common.SingleRxTransformer
import io.reactivex.Single

class GetPromotedItemsUseCase(transformer: SingleRxTransformer<List<DomainPromotedItem>>,
                              private val promotedItemsRepository: PromotedItemsRepository)
    : SingleNoParamsUseCase<List<DomainPromotedItem>>(transformer) {

    override fun create() = promotedItemsRepository.getPromotedItems()

}