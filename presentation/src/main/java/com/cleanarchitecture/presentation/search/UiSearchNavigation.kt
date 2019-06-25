package com.cleanarchitecture.presentation.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class UiSearchNavigation(
        val general: UiGeneral,
        val banners: List<UiBanners>,
        val menus: List<UiMenus>,
        val breadcrumbs: List<String>,
        val pagination: UiPagination,
        val facets: List<UiFacets>,
        val resultsets: UiResultsets,
        val resultcount: UiResultCount,
        val price_range: UiPriceRange
)

data class UiBanners(
        val top: String
)

data class UiDefault(
        val name: String,
        val results: List<UiResult>
)

data class UiFacets(
        val id: String,
        val label: String,
        val values: List<UiValues>
)

data class UiGeneral(
        val query: String,
        val tag: String,
        val ids: String,
        val skus: String,
        val total: Int,
        val redirect: String,
        val bannerTitle: String,
        val redirect_without_analytics: String,
        val redirect_type: String,
        val page_lower: Int,
        val page_upper: Int,
        val page_total: Int,
        val index: String
)

data class UiItems(
        val value: String,
        val label: String,
        val selected: Boolean
)

data class UiMenus(
        val name: String,
        val label: String,
        val type: String,
        val items: List<UiItems>
)

data class UiPages(
        val page: Int,
        val selected: Boolean
)

data class UiPagination(
        val name: String,
        val previous: String,
        val current: Int,
        val next: Int,
        val last: Int,
        val pages: List<UiPages>
)

data class UiPriceRange(
        val max: Int,
        val min: Int
)

data class UiResultCount(
        val total: Int,
        val pagelower: Int,
        val pageupper: Int
)

@Parcelize
data class UiResult(
        val id: Int,
        val sku: Int,
        val title: String,
        val brand: String,
        val price: String,
        val image: String,
        val reevoo_score: Double,
        val reevoo_count: Int,
        val discount: String,
        val short_description: String
): Parcelable

data class UiResultsets(
        val default: UiDefault
)

data class UiValues(
        val value: String,
        val label: String,
        val count: Int,
        val selected: Boolean
)
