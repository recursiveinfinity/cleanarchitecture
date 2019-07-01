package com.cleanarchitecture.presentation.products

import com.cleanarchitecture.presentation.search.UiResult

data class UiProductListing(
        val product: UiProduct,
        val result: UiResult
)