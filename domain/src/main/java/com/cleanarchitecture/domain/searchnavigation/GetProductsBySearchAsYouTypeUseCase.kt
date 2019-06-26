package com.cleanarchitecture.domain.searchnavigation


import com.cleanarchitecture.domain.common.SingleRxTransformer
import com.cleanarchitecture.domain.common.SingleUseCase
import io.reactivex.Single

class GetProductsBySearchAsYouTypeUseCase(transformer: SingleRxTransformer<DomainSearchAsYouType>,
                                          private val repositories: SearchRepository) : SingleUseCase<String, DomainSearchAsYouType>(transformer) {

    override fun create(query: String): Single<DomainSearchAsYouType> =
            repositories.getSearchAsYouType(query)
}