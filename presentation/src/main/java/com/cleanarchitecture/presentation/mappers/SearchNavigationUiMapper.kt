package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.searchnavigation.DomainSearchNavigation
import com.cleanarchitecture.presentation.search.UiSearchNavigation


class SearchNavigationUiMapper : Mapper<DomainSearchNavigation, UiSearchNavigation>() {
    override fun toUi(from: DomainSearchNavigation) = UiSearchNavigation(
            userId = from.userId,
            description = from.description,
            url = from.url
    )
}