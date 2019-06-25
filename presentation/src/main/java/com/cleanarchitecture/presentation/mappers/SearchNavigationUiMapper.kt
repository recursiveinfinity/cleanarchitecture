package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.searchnavigation.*
import com.cleanarchitecture.presentation.search.*


class SearchNavigationUiMapper : Mapper<DomainSearchNavigation, UiSearchNavigation> {

    override fun map(from: DomainSearchNavigation) = toUi(from)

    private fun toUi(Domain: DomainSearchNavigation): UiSearchNavigation = UiSearchNavigation(
            general = toUiGeneral(Domain.general),
            banners = Domain.banners.map { toUiBanners(it) },
            menus = Domain.menus.map { toUiMenus(it) },
            breadcrumbs = Domain.breadcrumbs,
            pagination = toUiPagination(Domain.pagination),
            facets = Domain.facets.map { toUiFacets(it) },
            resultsets = toUiResultSets(Domain.resultsets),
            resultcount = toUiResultCount(Domain.resultcount),
            price_range = toUiPriceRange(Domain.price_range)
    )

    private fun toUiPriceRange(Domain: DomainPriceRange): UiPriceRange = UiPriceRange(
            max = Domain.max,
            min = Domain.min
    )

    private fun toUiResultCount(Domain: DomainResultCount): UiResultCount = UiResultCount(
            total = Domain.total,
            pagelower = Domain.pagelower,
            pageupper = Domain.pageupper
    )

    private fun toUiResultSets(Domain: DomainResultsets): UiResultsets = UiResultsets(
            default = toUiDefault(Domain.default)
    )

    private fun toUiDefault(Domain: DomainDefault): UiDefault = UiDefault(
            name = Domain.name,
            results = Domain.results.map { toUiResults(it) }
    )

    private fun toUiResults(Domain: DomainResults): UiResult = UiResult(
            id = Domain.id,
            sku = Domain.sku,
            title = Domain.title,
            brand = Domain.brand,
            price = Domain.price,
            image = Domain.image,
            reevoo_score = Domain.reevoo_score,
            reevoo_count = Domain.reevoo_count,
            discount = Domain.discount,
            short_description = Domain.short_description

    )

    private fun toUiFacets(Domain: DomainFacets): UiFacets = UiFacets(
            id = Domain.id,
            label = Domain.label,
            values = Domain.values.map { toUiValues(it) }
    )

    private fun toUiValues(Domain: DomainValues): UiValues = UiValues(
            value = Domain.value,
            label = Domain.label,
            count = Domain.count,
            selected = Domain.selected
    )

    private fun toUiPagination(Domain: DomainPagination): UiPagination = UiPagination(
            name = Domain.name,
            previous = Domain.previous,
            current = Domain.current,
            next = Domain.next,
            last = Domain.last,
            pages = Domain.pages.map { toUiPages(it) }

    )

    private fun toUiPages(Domain: DomainPages): UiPages = UiPages(
            page = Domain.page,
            selected = Domain.selected
    )

    private fun toUiGeneral(Domain: DomainGeneral): UiGeneral = UiGeneral(
            query = Domain.query,
            tag = Domain.tag,
            ids = Domain.ids,
            skus = Domain.skus,
            total = Domain.total,
            redirect = Domain.redirect,
            bannerTitle = Domain.bannerTitle,
            redirect_without_analytics = Domain.redirect_without_analytics,
            redirect_type = Domain.redirect_type,
            page_lower = Domain.page_lower,
            page_upper = Domain.page_upper,
            page_total = Domain.page_total,
            index = Domain.index
    )

    private fun toUiBanners(Domain: DomainBanners): UiBanners = UiBanners(Domain.top)

    private fun toUiMenus(Domain: DomainMenus): UiMenus = UiMenus(
            name = Domain.name,
            label = Domain.label,
            type = Domain.type,
            items = Domain.items.map { toUiItems(it) }
    )

    private fun toUiItems(Domain: DomainItems): UiItems = UiItems(
            value = Domain.value,
            label = Domain.label,
            selected = Domain.selected
    )
}