package com.cleanarchitecture.domain.products

import io.reactivex.Single

/**
 * The interface of repositories is defined in domain layer, for its' implementations look
 * in data layer
 */
interface StoreRepository {
    fun getProducts(productId: Int): Single<DomainProducts>
    fun getProducts(productId: List<Int>): Single<DomainProducts>
}