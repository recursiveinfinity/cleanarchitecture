package com.cleanarchitecture.domain.products

import com.cleanarchitecture.domain.common.SingleNoParamsUseCase
import com.cleanarchitecture.domain.common.SingleRxTransformer
import com.cleanarchitecture.domain.searchnavigation.DomainSearchNavigation
import com.cleanarchitecture.domain.searchnavigation.SearchRepository
import io.reactivex.Single

/**
 * A use case that retrieves a list of albums on execution. It extends SingleNoParamsUseCase and
 * overrides the create method to create a Single<List<DomainAlbum>>
 * @param transformer - A SingleRxTransformer of type List<DomainAlbum>
 * @param repositories - An implementation of AlbumsRepository
 */
class GetProductsUseCase(transformer: SingleRxTransformer<DomainProductListing>,
                         private val searchRepository: SearchRepository,
                         private val storeRepository: StoreRepository) : SingleNoParamsUseCase<DomainProductListing>(transformer) {

    override fun create(): Single<DomainProductListing> =
            searchRepository.getNavigation()
                    .flatMap { searchNavigation ->
                        getProductIds(searchNavigation)
                                .flatMap { productIds ->
                                    storeRepository.getProducts(productIds)
                                }
                                .map { products ->
                                    DomainProductListing(searchNavigation, products)
                                }
                    }

    private fun getProductIds(searchNavigation: DomainSearchNavigation): Single<List<String>> =
            Single.just(searchNavigation)
                    .toObservable()
                    .flatMapIterable { it.resultsets.default.results }
                    .map { it.id }
                    .toList()
}
