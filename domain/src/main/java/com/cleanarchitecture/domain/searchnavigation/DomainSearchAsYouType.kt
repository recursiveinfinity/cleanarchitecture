package com.cleanarchitecture.domain.searchnavigation

data class DomainSearchAsYouType(
        var general: DomainSearchAsYouTypeGeneral? = null,
        var results: List<DomainSearchAsYouTypeResult>? = null
)

data class DomainSearchAsYouTypeGeneral(
        val query: String,
        val sayt_q: String,
        val total: Int,
        val page_lower: Int,
        val page_upper: Int,
        val index: String
)

data class DomainSearchAsYouTypeResult(
        val id: Int,
        val title: String,
        val url: String,
        val image: String,
        val brand: String,
        val price: Double,
        val review_score: Double,
        val number_of_reviews: Int
)