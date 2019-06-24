package com.cleanarchitecture.domain.albums

data class Domainproduct(
        val productId: String? = null,
        val description: String? = null,
        val url: String? = null,
        val price: String? = null,
        val ratings: Float? = null,
        val reviewCount: Int? = null
)