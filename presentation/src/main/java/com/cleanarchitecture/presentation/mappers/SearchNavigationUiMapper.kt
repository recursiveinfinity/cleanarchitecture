package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.searchnavigation.*
import com.cleanarchitecture.presentation.common.CurrencyFormatter
import com.cleanarchitecture.presentation.search.*


class SearchNavigationUiMapper : Mapper<DomainSearchNavigation, UiSearchNavigation> {

    override fun map(from: DomainSearchNavigation) = toUi(from)

    private fun toUi(from: DomainSearchNavigation): UiSearchNavigation = UiSearchNavigation(
            general = toUiGeneral(from.general),
            banners = from.banners.map { toUiBanners(it) },
            menus = from.menus.map { toUiMenus(it) },
            breadcrumbs = from.breadcrumbs,
            pagination = toUiPagination(from.pagination),
            facets = from.facets.map { toUiFacets(it) },
            resultsets = toUiResultSets(from.resultsets),
            resultcount = toUiResultCount(from.resultcount),
            price_range = toUiPriceRange(from.price_range)
    )

    private fun toUiPriceRange(from: DomainPriceRange): UiPriceRange = UiPriceRange(
            max = from.max,
            min = from.min
    )

    private fun toUiResultCount(from: DomainResultCount): UiResultCount = UiResultCount(
            total = from.total,
            pagelower = from.pagelower,
            pageupper = from.pageupper
    )

    private fun toUiResultSets(from: DomainResultsets): UiResultsets = UiResultsets(
            default = toUiDefault(from.default)
    )

    private fun toUiDefault(from: DomainDefault): UiDefault = UiDefault(
            name = from.name,
            results = from.results.map { toUiResult(it) }
    )

    fun toUiResult(from: DomainResult): UiResult = UiResult(
            id = from.id,
            sku = from.sku,
            title = from.title,
            brand = from.brand,
            price = CurrencyFormatter.format(from.price),
            image = from.image,
            reevoo_score = from.reevoo_score,
            reevoo_count = from.reevoo_count,
            discount = from.discount,
            short_description = from.short_description

    )

    private fun toUiFacets(from: DomainFacets): UiFacets = UiFacets(
            id = from.id,
            label = from.label,
            values = from.values.map { toUiValues(it) }
    )

    private fun toUiValues(from: DomainValues): UiValues = UiValues(
            value = from.value,
            label = from.label,
            count = from.count,
            selected = from.selected
    )

    private fun toUiPagination(from: DomainPagination): UiPagination = UiPagination(
            name = from.name,
            previous = from.previous,
            current = from.current,
            next = from.next,
            last = from.last,
            pages = from.pages.map { toUiPages(it) }

    )

    private fun toUiPages(from: DomainPages): UiPages = UiPages(
            page = from.page,
            selected = from.selected
    )

    private fun toUiGeneral(from: DomainGeneral): UiGeneral = UiGeneral(
            query = from.query,
            tag = from.tag,
            ids = from.ids,
            skus = from.skus,
            total = from.total,
            redirect = from.redirect,
            bannerTitle = from.bannerTitle,
            redirect_without_analytics = from.redirect_without_analytics,
            redirect_type = from.redirect_type,
            page_lower = from.page_lower,
            page_upper = from.page_upper,
            page_total = from.page_total,
            index = from.index
    )

    private fun toUiBanners(from: DomainBanners): UiBanners = UiBanners(from.top)

    private fun toUiMenus(from: DomainMenus): UiMenus = UiMenus(
            name = from.name,
            label = from.label,
            type = from.type,
            items = from.items.map { toUiItems(it) }
    )

    private fun toUiItems(from: DomainItems): UiItems = UiItems(
            value = from.value,
            label = from.label,
            selected = from.selected
    )
}