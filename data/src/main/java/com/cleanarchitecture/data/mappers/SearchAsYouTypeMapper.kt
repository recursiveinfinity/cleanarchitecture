package com.cleanarchitecture.data.mappers

import com.cleanarchitecture.data.entities.DataSearchAsYouType
import com.cleanarchitecture.data.entities.DataSearchAsYouTypeGeneral
import com.cleanarchitecture.data.entities.DataSearchAsYouTypeResult
import com.cleanarchitecture.domain.searchnavigation.DomainSearchAsYouType
import com.cleanarchitecture.domain.searchnavigation.DomainSearchAsYouTypeGeneral
import com.cleanarchitecture.domain.searchnavigation.DomainSearchAsYouTypeResult

class SearchAsYouTypeMapper {

    fun toDomain(data: DataSearchAsYouType): DomainSearchAsYouType = DomainSearchAsYouType(
            general = data.general?.let { toDomainSearchAsYouTypeGeneral(it) },
            results = data.results?.map { toDomainSearchAsYouTypeResult(it) }
    )

    private fun toDomainSearchAsYouTypeResult(data: DataSearchAsYouTypeResult): DomainSearchAsYouTypeResult = DomainSearchAsYouTypeResult(
            id = data.id.toIntOrZero(),
            title = data.title,
            brand = data.brand,
            url = data.url,
            price = data.price.toDoubleOrZero(),
            image = data.image,
            review_score = data.review_score.toDoubleOrZero(),
            number_of_reviews = data.number_of_reviews.toIntOrZero()
    )

    fun toDomainSearchAsYouTypeGeneral(data: DataSearchAsYouTypeGeneral): DomainSearchAsYouTypeGeneral = DomainSearchAsYouTypeGeneral(
            query = data.query,
            sayt_q = data.sayt_q,
            total = data.total.toIntOrZero(),
            page_lower = data.page_lower.toIntOrZero(),
            page_upper = data.page_upper.toIntOrZero(),
            index = data.index
    )
}
