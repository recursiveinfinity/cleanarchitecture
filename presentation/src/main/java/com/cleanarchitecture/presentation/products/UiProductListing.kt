package com.cleanarchitecture.presentation.products

import com.cleanarchitecture.presentation.search.UiResult

data class UiProductListing(
        val product: UiProduct,
        val deliveryOption: UiDeliveryOption,
        val wasPrice: UiWasPrice,
        val result: UiResult
)