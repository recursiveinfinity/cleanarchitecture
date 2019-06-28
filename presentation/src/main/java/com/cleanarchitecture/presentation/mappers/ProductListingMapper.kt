package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.products.DomainProductListing
import com.cleanarchitecture.presentation.products.UiDeliveryOption
import com.cleanarchitecture.presentation.products.UiProductListing
import com.cleanarchitecture.presentation.products.UiProductMapper
import com.cleanarchitecture.presentation.products.UiWasPrice
import com.cleanarchitecture.presentation.search.UiResult

class ProductListingMapper(val uiProductMapper: UiProductMapper, val searchNavigationUiMapper: SearchNavigationUiMapper) {

//    val product: UiProduct,
//        val deliveryOption: UiDeliveryOption,
//        val wasPrice: UiWasPrice,
//        val result: UiResult

    data class UiProductListings(
            val results: List<UiResult>,
            val deliveryOptions: List<UiDeliveryOption>,
            val wasPrices: List<UiWasPrice>
    )

    fun mapToProductListings(domainProductListing: DomainProductListing): UiProductListings = UiProductListings(
            results = toResults(domainProductListing)
    )

    fun map(domainProductListing: DomainProductListing): UiProductListing = UiProductListing(
            product =,
            deliveryOption = uiProductMapper.map(domainProductListing.storeProducts),
            wasPrice =,
            result = searchNavigationUiMapper.map(domainProductListing.searchNavigation).resultsets.,

            )

    fun toResults(domainProductListing: DomainProductListing): List<UiResult> = domainProductListing.searchNavigation.resultsets.default.results.map { searchNavigationUiMapper.toUiResult(it) }


}