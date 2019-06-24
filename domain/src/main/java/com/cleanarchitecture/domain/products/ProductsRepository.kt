package com.cleanarchitecture.domain.albums

import io.reactivex.Single

/**
 * The interface of repositories is defined in domain layer, for its' implementations look
 * in data layer
 */
interface ProductsRepository {
    fun getProducts(): Single<List<Domainproduct>>
}