package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.products.DomainProductListing
import com.cleanarchitecture.presentation.products.UiProductListing
import com.cleanarchitecture.presentation.products.UiProductMapper

class ProductListingMapper(private val uiProductMapper: UiProductMapper, private val searchNavigationUiMapper: SearchNavigationUiMapper) {

//    val product: UiProduct,
//        val deliveryOption: UiDeliveryOption,
//        val wasPrice: UiWasPrice,
//        val result: UiResult
//
//    data class UiProductListings(
//            val results: List<UiResult>,
//            val deliveryOptions: List<UiDeliveryOption>,
//            val wasPrices: List<UiWasPrice>
//    )
//
//    fun mapToProductListings(domainProductListing: DomainProductListing): UiProductListings = UiProductListings(
//            results = toResults(domainProductListing)
//    )
//
//    fun map(domainProductListing: DomainProductListing): UiProductListing = UiProductListing(
//            product =,
//            deliveryOption = uiProductMapper.map(domainProductListing.storeProducts),
//            wasPrice =,
//            result = searchNavigationUiMapper.map(domainProductListing.searchNavigation).resultsets.,
//            )

//    fun toResults(domainProductListing: DomainProductListing): List<UiResult> = domainProductListing.searchNavigation.resultsets.default.results.map { searchNavigationUiMapper.toUiResult(it) }

    fun map(domainProductListing: DomainProductListing): List<UiProductListing> =
            mutableListOf<UiProductListing>().also { list ->
                domainProductListing.searchNavigation.resultsets.default.results.forEach { result ->
                    list.add(UiProductListing(
                            product = uiProductMapper.toProduct(domainProductListing.storeProducts.products?.firstOrNull { it.id == result.id.toString() }),
                            result = searchNavigationUiMapper.toUiResult(result)

                    ))
                }
            }
}


//       list.add(UiProductListing(
//                            product = uiProductMapper.toProduct(domainProductListing.storeProducts.products?.find { it.id == result.id.toString() }),
//                            result = searchNavigationUiMapper.toUiResult(result),
//                            wasPrice = uiProductMapper.toWasPrice(domainProductListing.storeProducts.products?.get(index)?.wasPrice),
//                            deliveryOption = domainProductListing.storeProducts.products?.get(index)?.deliveryOptions?.map { uiProductMapper.toDeliveryOptions(it) }
//
//                    ))