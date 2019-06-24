package com.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName


data class DataSearchNavigation(
        @SerializedName("general") val general: DataGeneral,
        @SerializedName("banners") val banners: List<DataBanners>,
        @SerializedName("menus") val menus: List<DataMenus>,
        @SerializedName("breadcrumbs") val breadcrumbs: List<String>,
        @SerializedName("pagination") val pagination: DataPagination,
        @SerializedName("facets") val facets: List<DataFacets>,
        @SerializedName("resultsets") val resultsets: Resultsets,
        @SerializedName("resultcount") val resultcount: DataResultCount,
        @SerializedName("price_range") val price_range: DataPriceRange
)

data class DataBanners(
        @SerializedName("top") val top: String
)

data class DataDefault(
        @SerializedName("name") val name: String,
        @SerializedName("results") val results: List<DataResults>
)

data class DataFacets(
        @SerializedName("id") val id: String,
        @SerializedName("label") val label: String,
        @SerializedName("values") val values: List<Values>
)

data class DataGeneral(
        @SerializedName("query") val query: String,
        @SerializedName("tag") val tag: String,
        @SerializedName("ids") val ids: String,
        @SerializedName("skus") val skus: String,
        @SerializedName("total") val total: Int,
        @SerializedName("redirect") val redirect: String,
        @SerializedName("bannerTitle") val bannerTitle: String,
        @SerializedName("redirect_without_analytics") val redirect_without_analytics: String,
        @SerializedName("redirect_type") val redirect_type: String,
        @SerializedName("page_lower") val page_lower: Int,
        @SerializedName("page_upper") val page_upper: Int,
        @SerializedName("page_total") val page_total: Int,
        @SerializedName("index") val index: String
)

data class DataItems(
        @SerializedName("value") val value: String,
        @SerializedName("label") val label: String,
        @SerializedName("selected") val selected: Boolean
)

data class DataMenus(
        @SerializedName("name") val name: String,
        @SerializedName("label") val label: String,
        @SerializedName("type") val type: String,
        @SerializedName("items") val items: List<DataItems>
)

data class DataPages(
        @SerializedName("page") val page: Int,
        @SerializedName("selected") val selected: Boolean
)

data class DataPagination(
        @SerializedName("name") val name: String,
        @SerializedName("previous") val previous: String,
        @SerializedName("current") val current: Int,
        @SerializedName("next") val next: Int,
        @SerializedName("last") val last: Int,
        @SerializedName("pages") val pages: List<DataPages>
)

data class DataPriceRange(
        @SerializedName("max") val max: Int,
        @SerializedName("min") val min: Int
)

data class DataResultCount(
        @SerializedName("total") val total: Int,
        @SerializedName("pagelower") val pagelower: Int,
        @SerializedName("pageupper") val pageupper: Int
)

data class DataResults(
        @SerializedName("id") val id: Int,
        @SerializedName("sku") val sku: Int,
        @SerializedName("title") val title: String,
        @SerializedName("brand") val brand: String,
        @SerializedName("price") val price: Double,
        @SerializedName("image") val image: String,
        @SerializedName("reevoo_score") val reevoo_score: Double,
        @SerializedName("reevoo_count") val reevoo_count: Int,
        @SerializedName("discount") val discount: String,
        @SerializedName("short_description") val short_description: String
)

data class Resultsets(
        @SerializedName("default") val default: DataDefault
)

data class Values(
        @SerializedName("value") val value: String,
        @SerializedName("label") val label: String,
        @SerializedName("count") val count: Int,
        @SerializedName("selected") val selected: Boolean
)