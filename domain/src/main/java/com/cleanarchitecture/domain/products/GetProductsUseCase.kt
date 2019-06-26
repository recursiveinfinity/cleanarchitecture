package com.cleanarchitecture.domain.albums

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
class GetProductsUseCase(transformer: SingleRxTransformer<DomainSearchNavigation>,
                         private val searchRepository: SearchRepository,
                         private val storeRepository: StoreRepository) : SingleNoParamsUseCase<DomainSearchNavigation>(transformer) {

    override fun create(): Single<DomainSearchNavigation> =
            storeRepository.getProducts().flatMap {
                searchRepository.getNavigation()
            }
}