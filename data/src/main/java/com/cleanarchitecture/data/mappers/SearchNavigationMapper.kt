package com.cleanarchitecture.data.mappers

import com.cleanarchitecture.data.entities.DataSearchNavigation
import com.cleanarchitecture.domain.searchnavigation.DomainSearchNavigation

class SearchNavigationMapper {

    fun toDomain(data: DataSearchNavigation): DomainSearchNavigation = DomainSearchNavigation(
            userId = "123",
            url = "456",
            description = "789"
    )
}